package teste.piProject.service.anime;
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
    public AnimeCompletoDto requestAnime(Integer animeId){
        AnimeQuery response =
                DefaultMetods.postRequestByClass(
                        AnimeQueries.buscaAnime(animeId),
                        AnimeQuery.class);
        if (response != null) {
            AnimeMedia res = response.getData().getmedia();
            try{
                AnimeDadosComplementaresDto dadosComplementares =
                        receberDadosComplementaresAnime(animeId);
                AnimeCompletoDto anime = AnimeMapper.createAnimeCompleto(
                        dadosComplementares,
                        res);
                return anime;
            }catch (Exception e){
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Erro ao consultar dados de vizualisação, like e deslike");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro na consulta de animes");
        }
    }

    public AnimeDadosComplementaresDto receberDadosComplementaresAnime(int id){
//        String url = "https://localhost:8080/anime/dados-complementares";
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> corpo = Map.of("id", "%d".formatted(id));
//        ResponseEntity<AnimeDadosComplementaresDto> response = restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                new HttpEntity<>(corpo),
//                new ParameterizedTypeReference<AnimeDadosComplementaresDto>() {}
//        );
//        return response.getBody();
        String url = "http://localhost:8080/anime/dados-complementares?id={id}";
        AnimeDadosComplementaresDto response =
                DefaultMetods.getRequestByClass(
                        AnimeDadosComplementaresDto.class,
                        url,
                        id);
        if (response != null) {
            return response;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Page> cardAnimesDaTemporada(Integer page, Integer qtdPaginas){
        CardQuery response =
                DefaultMetods.postRequestByClass(
                        AnimeQueries.animeSeason(page, qtdPaginas),
                        CardQuery.class);
        if (response != null) {
            Page res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Page> cardAnimesMaisCurtidos(){
        String url = "https://localhost:8080/anime/mais-curtidoscurtidos";
        CardQuery response =
                DefaultMetods.getRequestByClass(
                        CardQuery.class,
                        url);
        if (response != null) {
            Page res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public AnimeParaSalvarDto animeParaSalvar(Integer idApi){
        try {
            AnimeCompletoDto anime = this.requestAnime(idApi);
            return AnimeMapper.animeParaSalvar(anime);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
        }
    }
}
