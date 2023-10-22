package teste.piProject.service.anime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import teste.piProject.service.Defaults;
import teste.piProject.service.anime.dto.AnimeDto;
import teste.piProject.service.anime.dto.AnimeMapper;
import teste.piProject.service.anime.model.AnimeRequests;

import java.util.Map;

@Service
public class AnimeService{
    public ResponseEntity<AnimeDto> requestAnime(String animeName){
        Map<String, Map<String, Map<String, Map<String, String>>>> request =
                Defaults.request(
                        AnimeRequests.buscaAnimeComum(animeName));
        var response = request.get("data");

        AnimeDto anime = AnimeMapper.createAnime(response);
        return ResponseEntity.status(200).body(anime);
    }
}
