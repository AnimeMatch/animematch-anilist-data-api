package teste.piProject.api.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import teste.piProject.domain.Page;
import teste.piProject.service.anime.AnimeMedia;
import teste.piProject.service.anime.AnimeService;
import teste.piProject.service.anime.dto.AnimeCompletoDto;

import java.util.Map;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    public static final String url =  "https://graphql.anilist.co";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AnimeService animeService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recebimento de anime bem-sucedido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimeCompletoDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
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
