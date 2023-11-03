package teste.piProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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

//    @PostMapping("/get-id")
//    public ResponseEntity<Integer> getID(@RequestBody Map<String,String> s){
//        var request = restTemplate.postForEntity(url,s, Map.class);
//        var response = (Map<String, Map<String,Map<String,Map<String,String>>>>)request.getBody().get("data");
//
//        String a = String.valueOf(response.get("Media").get("id"));
//        Integer id = Integer.parseInt(a);
//        return ResponseEntity.ok().body(id);
//    }

    @GetMapping("/anime")
    public ResponseEntity getAnime(@RequestParam Integer animeId){
        ResponseEntity response = animeService.requestAnime(animeId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

//    @GetMapping("/anime-simples")
//    public ResponseEntity getAnimeSimples(@RequestParam String name){
//        ResponseEntity response = animeService.requestAnimeSimples(name);
//        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
//    }

    @GetMapping("/cards")
    public ResponseEntity getCards(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity response = animeService.animeCard(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
