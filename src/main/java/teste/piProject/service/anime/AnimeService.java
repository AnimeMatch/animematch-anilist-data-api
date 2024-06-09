package teste.piProject.service.anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.service.anime.dto.AnimePage;
import teste.piProject.service.anime.dto.*;
import teste.piProject.util.DefaultMetods;
import teste.piProject.service.queries.Queries;
import teste.piProject.util.IPConfig;

import static teste.piProject.util.Types.TypeMedia.ANIME;

@Service
public class AnimeService{
    private Queries queries;
    private IPConfig ipConfig = new IPConfig();

    public AnimeService() {
        this.queries = new Queries(ANIME);
    }

    public AnimeCompletoDto requestAnime(Integer animeId){
        try{
            AnimeQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.buscaMidia(animeId),
                            AnimeQuery.class);
            if (response != null) {
                AnimeMedia res = response.getData().getmedia();
                try{
                    DadosComplementaresDto dadosComplementares =
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
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
        }
    }

    public DadosComplementaresDto receberDadosComplementaresAnime(int id){
        String url = "http://%s/midia/dados-complementares?id={id}".formatted(ipConfig.getIpApi());
        DadosComplementaresDto response =
                DefaultMetods.getRequestByClass(
                        DadosComplementaresDto.class,
                        url,
                        id);
        if (response != null) {
            return response;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<AnimePage> cardAnimesDaTemporada(Integer page, Integer qtdPaginas){

        CardAnimeQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.animeSeason(page, qtdPaginas),
                        CardAnimeQuery.class);
        if (response != null) {
            AnimePage res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
//    public ResponseEntity<Page> cardAnimesMaisCurtidos(){
//        String url = "https://localhost:8080/anime/mais-curtidoscurtidos";
//        CardQuery response =
//                DefaultMetods.getRequestByClass(
//                        CardQuery.class,
//                        url);
//        if (response != null) {
//            Page res = response.getData().getPage();
//            return ResponseEntity.status(200).body(res);
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }

//    public AnimeParaSalvarDto animeParaSalvar(Integer idApi){
//        try {
//            AnimeCompletoDto anime = this.requestAnime(idApi);
//            return AnimeMapper.animeParaSalvar(anime);
//        } catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
//        }
//    }

    public AnimePage searchAnime(String tituloBusca, int page, int qtdPaginas){
        try {
            CardAnimeQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaMidiaPeloNome(tituloBusca, page, qtdPaginas),
                        CardAnimeQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public AnimePage getAnimesPeloGenero(String genero, int page, int qtdPaginas){
        try {
            CardAnimeQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaPeloGenero(genero, page, qtdPaginas),
                        CardAnimeQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public AnimePage getAnimesEmTrend(int page, int qtdPaginas){
        try {
            CardAnimeQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.ReceberAnimesEmTrend(page, qtdPaginas),
                            CardAnimeQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }
}
