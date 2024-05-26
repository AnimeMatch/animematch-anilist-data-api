package teste.piProject.service.manga;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.service.anime.dto.DadosComplementaresDto;
import teste.piProject.service.manga.dto.*;
import teste.piProject.service.queries.Queries;
import teste.piProject.util.DefaultMetods;
import teste.piProject.util.IPConfig;

import static teste.piProject.util.Types.TypeMedia.MANGA;

@Service
public class MangaService {
    private Queries queries;
    private IPConfig ipConfig = new IPConfig();

    public MangaService() {
        this.queries = new Queries(MANGA);
    }

    public MangaCompletoDto requestManga(Integer mangaId){
        MangaQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.buscaMidia(mangaId),
                        MangaQuery.class);
        if (response != null) {
            MangaMedia res = response.getData().getMedia();
            try{
                DadosComplementaresDto dadosComplementares =
                        receberDadosComplementaresManga(mangaId);
                MangaCompletoDto manga = MangaMapper.createMangaCompleto(
                        dadosComplementares,
                        res);
                return manga;
            }catch (Exception e){
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Erro ao consultar dados de visualização, like e deslike");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro na consulta de animes");
        }
    }

    public ResponseEntity<MangaPage> cardMangasDaTemporada(int page, int qtdPaginas){
        CardMangaQuery response =
                DefaultMetods.postRequestByClass(
                        this.queries.animeSeason(page, qtdPaginas),
                        CardMangaQuery.class);
        if (response != null) {
            MangaPage res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MangaPage> cardMangasMaisCurtidos(){
        String url = "https://%s/manga/mais-curtidoscurtidos".formatted(ipConfig.getIpApi());
        CardMangaQuery response =
                DefaultMetods.getRequestByClass(
                        CardMangaQuery.class,
                        url);
        if (response != null) {
            MangaPage res = response.getData().getPage();
            return ResponseEntity.status(200).body(res);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public DadosComplementaresDto receberDadosComplementaresManga(int id){
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

    public MangaPage searchManga(String tituloBusca, int page, int qtdPaginas){
        try {
            CardMangaQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.buscaMidiaPeloNome(tituloBusca, page, qtdPaginas),
                            CardMangaQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public MangaPage getMangasPeloGenero(String genero, int page, int qtdPaginas){
        try {
            CardMangaQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.buscaPeloGenero(genero, page, qtdPaginas),
                            CardMangaQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }

    public MangaPage getMangasEmTrend(int page, int qtdPaginas){
        try {
            CardMangaQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.ReceberAnimesEmTrend(page, qtdPaginas),
                            CardMangaQuery.class);
            return response.getData().getPage();
        } catch (Exception e){
            throw e;
        }
    }
}
