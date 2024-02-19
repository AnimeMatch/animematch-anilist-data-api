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
import teste.piProject.service.anime.AnimeService;
import teste.piProject.service.anime.dto.AnimeCompletoDto;
import teste.piProject.service.manga.MangaPage;
import teste.piProject.service.manga.MangaService;
import teste.piProject.service.manga.dto.MangaCompletoDto;

import java.util.Map;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    MangaService service = new MangaService();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recebimento de manga bem-sucedido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnimeCompletoDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/manga")
    public ResponseEntity<MangaCompletoDto> getManga(@RequestParam Integer mangaId){
        MangaCompletoDto manga = service.requestManga(mangaId);
        return ResponseEntity.status(200).body(manga);
    }

    @GetMapping("/cards/temporada")
    public ResponseEntity<MangaPage> getMangasDaTemporada(@RequestParam int page, @RequestParam int qtdPaginas){
        ResponseEntity<MangaPage> response = service.cardMangasDaTemporada(page, qtdPaginas);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/cards/mais-curtidos")
    public ResponseEntity<MangaPage> getMangaMaisCurtidos(){
        ResponseEntity<MangaPage> response = service.cardMangasMaisCurtidos();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

}
