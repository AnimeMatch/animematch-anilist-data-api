package teste.piProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import teste.piProject.domain.Page;
import teste.piProject.service.anime.AnimeService;

import java.util.Map;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    public static final String url =  "https://graphql.anilist.co";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AnimeService animeService;

    @GetMapping("/anime")
    public ResponseEntity getAnime(@RequestParam Integer animeId){
        ResponseEntity response = animeService.requestAnime(animeId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/cards")
    public ResponseEntity<Page> getCards(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity<Page> response = animeService.animeCard(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/cards-temporada")
    public ResponseEntity<Page> getMaisVizualizados(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity<Page> response = animeService.animeCard(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
