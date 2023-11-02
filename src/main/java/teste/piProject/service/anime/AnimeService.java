package teste.piProject.service.anime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.domain.AnimeMedia;
import teste.piProject.service.anime.dto.AnimeQuery;
import teste.piProject.util.DefaultMetods;
import teste.piProject.service.anime.dto.AnimeSimplesDto;
import teste.piProject.service.anime.dto.AnimeMapper;
import teste.piProject.service.anime.queries.AnimeQueries;

import java.util.Map;

@Service
public class AnimeService{
    public ResponseEntity<AnimeSimplesDto> requestAnimeSimples(String animeName){
        Map<String, Map<String, Map<String, Map<String, String>>>> request =
                DefaultMetods.request(
                        AnimeQueries.buscaAnimeSimples(animeName));
        var response = request.get("data");

        AnimeSimplesDto anime = AnimeMapper.createAnimeSimples(response);
        return ResponseEntity.status(200).body(anime);
    }

    public ResponseEntity<AnimeQuery> requestAnime(Integer animeId){
        AnimeQuery response =
                DefaultMetods.requestByClass(
                        AnimeQueries.buscaAnime(animeId), AnimeQuery.class);
        if (response != null) {
            return ResponseEntity.status(200).body(response);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    public static AnimeMedia requestByClass(Map<String, String> corpo){
//        String url = "https://graphql.anilist.co";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<AnimeMedia> response = restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                new HttpEntity<>(corpo),
//                new ParameterizedTypeReference<AnimeMedia>() {}
//        );
//        return response.getBody();
//    }
}
