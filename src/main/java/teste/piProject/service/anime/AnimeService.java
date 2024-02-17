package teste.piProject.service.anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.domain.Page;
import teste.piProject.service.anime.dto.*;
import teste.piProject.service.midia.MidiaService;
import teste.piProject.util.DefaultMetods;
import teste.piProject.service.queries.Queries;

import static teste.piProject.util.Types.TypeMedia.ANIME;

@Service
public class AnimeService{
    private Queries queries;

    public AnimeService() {
        this.queries = new Queries(ANIME);
    }

    public AnimeCompletoDto requestAnime(Integer animeId){
        AnimeQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaAnime(animeId),
                        AnimeQuery.class);
        if (response != null) {
            AnimeMedia res = response.getData().getmedia();
            try{
                MidiaDadosComplementaresDto dadosComplementares =
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

    public MidiaDadosComplementaresDto receberDadosComplementaresAnime(int id){
        String url = "http://localhost:8080/anime/dados-complementares?id={id}";
        MidiaDadosComplementaresDto response =
                DefaultMetods.getRequestByClass(
                        MidiaDadosComplementaresDto.class,
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
                        this.queries.animeSeason(page, qtdPaginas),
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

//    public AnimeParaSalvarDto animeParaSalvar(Integer idApi){
//        try {
//            AnimeCompletoDto anime = this.requestAnime(idApi);
//            return AnimeMapper.animeParaSalvar(anime);
//        } catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
//        }
//    }

    public Page searchAnime(String tituloBusca, int page, int paginas){
        try {
            CardQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaAnimePeloNome(tituloBusca, page, paginas),
                        CardQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public Page getAnimesPeloGenero(String generos, int page, int paginas){
        try {
            CardQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaPeloGenero(generos, page, paginas),
                        CardQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public Page getAnimesEmTrend(int page, int paginas){
        try {
            CardQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.ReceberAnimesEmTrend(page, paginas),
                            CardQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }
}
