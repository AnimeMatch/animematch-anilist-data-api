package teste.piProject.service.anime;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.domain.Page;
import teste.piProject.service.anime.dto.*;
import teste.piProject.util.DefaultMetods;
import teste.piProject.service.anime.queries.AnimeQueries;

import java.util.Map;

@Service
public class AnimeService{

    public ResponseEntity<AnimeCompletoDto> requestAnime(Integer animeId){
        AnimeQuery response =
                DefaultMetods.requestByClass(
                        AnimeQueries.buscaAnime(animeId), AnimeQuery.class);
        if (response != null) {
            AnimeMedia res = response.getData().getmedia();
            try{
                AnimeDadosComplementaresDto dadosComplementares =
                        receberDadosComplementaresAnime(animeId);
                AnimeCompletoDto anime = AnimeMapper.createAnimeCompleto(
                        dadosComplementares,
                        res);
                return ResponseEntity.status(200).body(anime);
            }catch (Exception e){
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Erro ao consultar dados de vizualisação, like e deslike");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public AnimeDadosComplementaresDto receberDadosComplementaresAnime(int id){
        String url = "https://localhost:8080/anime/dados-complementares";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> corpo = Map.of("id", "%d".formatted(id));
        ResponseEntity<AnimeDadosComplementaresDto> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(corpo),
                new ParameterizedTypeReference<AnimeDadosComplementaresDto>() {}
        );
        return response.getBody();
    }

    public ResponseEntity<Page> animeCard(Integer page, Integer qtdPaginas){
        CardQuery response =
                DefaultMetods.requestByClass(
                        AnimeQueries.animeSeason(page, qtdPaginas), CardQuery.class
                );
        if (response != null) {
            Page res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
