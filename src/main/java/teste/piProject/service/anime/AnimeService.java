package teste.piProject.service.anime;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import teste.piProject.service.Defaults;
import teste.piProject.service.anime.dto.AnimeSimplesDto;
import teste.piProject.service.anime.dto.AnimeMapper;
import teste.piProject.service.anime.model.AnimeRequests;

import java.util.Map;

@Service
public class AnimeService{
    public ResponseEntity<AnimeSimplesDto> requestAnimeSimples(String animeName){
        Map<String, Map<String, Map<String, Map<String, String>>>> request =
                Defaults.request(
                        AnimeRequests.buscaAnimeSimples(animeName));
        var response = request.get("data");

        AnimeSimplesDto anime = AnimeMapper.createAnimeSimples(response);
        return ResponseEntity.status(200).body(anime);
    }

    public ResponseEntity<AnimeMedia> requestAnime(String animeName){
        AnimeMedia response =
                requestByClass(
                        AnimeRequests.buscaAnime(animeName));
        AnimeDto anime = AnimeMapper.createAnime(response);
        return ResponseEntity.status(200).body(anime);
    }

    public static AnimeMedia requestByClass(Map<String, String> corpo){
        String url = "https://graphql.anilist.co";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AnimeMedia> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(corpo),
                new ParameterizedTypeReference<AnimeMedia>() {}
        );
        return response.getBody();
    }
}
