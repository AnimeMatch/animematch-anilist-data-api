package teste.piProject.service.manga;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.service.anime.dto.AnimeCompletoDto;
import teste.piProject.service.anime.dto.DadosComplementaresDto;
import teste.piProject.service.anime.dto.AnimeMapper;
import teste.piProject.service.manga.dto.MangaCompletoDto;
import teste.piProject.service.manga.dto.MangaMapper;
import teste.piProject.service.manga.dto.MangaQuery;
import teste.piProject.service.queries.Queries;
import teste.piProject.util.DefaultMetods;

import static teste.piProject.service.queries.Queries.TypeMedia.MANGA;

@Service
public class MangaService {
    private Queries queries;

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

    public DadosComplementaresDto receberDadosComplementaresManga(int id){
        String url = "http://localhost:8080/manga/dados-complementares?id={id}";
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
}
