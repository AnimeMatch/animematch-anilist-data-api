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
import teste.piProject.service.anime.dto.AnimeParaSalvarDto;

import java.util.Map;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    private static final String url =  "https://graphql.anilist.co";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AnimeService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recebimento de anime bem-sucedido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimeCompletoDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/anime")
    public ResponseEntity<AnimeCompletoDto> getAnime(@RequestParam Integer animeId){
        AnimeCompletoDto anime = service.requestAnime(animeId);
        return ResponseEntity.status(200).body(anime);
    }

    @GetMapping("/cards")
    public ResponseEntity<Page> getCards(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity<Page> response = service.cardAnimesDaTemporada(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/cards/temporada")
    public ResponseEntity<Page> getAnimesDaTemporada(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity<Page> response = service.cardAnimesDaTemporada(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/cards/mais-curtidos")
    public ResponseEntity<Page> getAnimesMaisCurtidos(){
        ResponseEntity<Page> response = service.cardAnimesMaisCurtidos();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/anime-para-salvar/{idApi}")
    public ResponseEntity<AnimeParaSalvarDto> getAnimeParaSalvar(@PathVariable String idApi){
        AnimeParaSalvarDto anime = null;
        try {
           anime = service.animeParaSalvar(Integer.parseInt(idApi));
        } catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(200).body(anime);
    }

    @GetMapping("/cards/search")
    public ResponseEntity<Page> getSearch(@RequestParam String tituloBusca, @RequestParam int page, @RequestParam int qtdPaginas){
        Page animes = service.searchAnime(tituloBusca, page, qtdPaginas);
        return ResponseEntity.status(200).body(animes);
    }

    @GetMapping("/cards/genero")
    public ResponseEntity<Page> getAnimesPorGenero(@RequestParam String genero, @RequestParam int page, @RequestParam int qtdPaginas){
        Page animes = service.getAnimesPeloGenero(genero, page, qtdPaginas);
        return ResponseEntity.status(200).body(animes);
    }
}
