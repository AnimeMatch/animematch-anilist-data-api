package teste.piProject.service.anime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.domain.Page;
import teste.piProject.service.anime.dto.*;
import teste.piProject.util.DefaultMetods;
import teste.piProject.service.anime.queries.AnimeQueries;

import java.util.Map;

@Service
public class AnimeService{
//    public ResponseEntity<AnimeSimplesDto> requestAnimeSimples(String animeName){
//        Map<String, Map<String, Map<String, Map<String, String>>>> request =
//                DefaultMetods.request(
//                        AnimeQueries.buscaAnimeSimples(animeName));
//        var response = request.get("data");
//
//        AnimeSimplesDto anime = AnimeMapper.createAnimeSimples(response);
//        return ResponseEntity.status(200).body(anime);
//    }

    public ResponseEntity<AnimeMedia> requestAnime(Integer animeId){
        AnimeQuery response =
                DefaultMetods.requestByClass(
                        AnimeQueries.buscaAnime(animeId), AnimeQuery.class);
        if (response != null) {
            AnimeMedia res = response.getData().getmedia();
            return ResponseEntity.status(200).body(res);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
