package teste.piProject.service.midia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.piProject.service.anime.AnimeMedia;
import teste.piProject.service.anime.AnimeService;
import teste.piProject.service.anime.dto.AnimeCompletoDto;
import teste.piProject.service.anime.dto.AnimeMapper;
import teste.piProject.service.anime.dto.AnimeQuery;
import teste.piProject.service.midia.dto.MidiaMedia;
import teste.piProject.service.midia.dto.MidiaParaSalvarDto;
import teste.piProject.service.midia.dto.MidiaQuery;
import teste.piProject.service.queries.MidiaQueries;
import teste.piProject.util.DefaultMetods;
import teste.piProject.util.Types;

import static teste.piProject.util.Types.TypeMedia;
@Service
public class MidiaService {
    @Autowired
    private AnimeService animeService;
//    public void requestTypeMidia(Integer idApi){
//        try {
//            teste.piProject.service.midia.dto.MidiaQuery type = DefaultMetods
//                    .postRequestByClass(
//                            MidiaQueries.buscaMidia(idApi),
//                            teste.piProject.service.midia.dto.MidiaQuery.class);
//            if (type.getData().getType().getType().equals("ANIME")){
//
//            }
//        } catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
//        }
//    }

    public MidiaParaSalvarDto midiaParaSalvar(Integer idApi){
        try {
            MidiaQuery midia = DefaultMetods
                    .postRequestByClass(
                            MidiaQueries.buscaMidia(idApi),
                            MidiaQuery.class);
//            AnimeCompletoDto midia = this.requestMidia(idApi);
            return this.format(midia.getData().getMedia());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "%s".formatted(e));
        }
    }

    public static MidiaParaSalvarDto format(MidiaMedia midia){
        final MidiaParaSalvarDto midiaResponse = new MidiaParaSalvarDto(
                midia.getId(),
                midia.getTitle().getEnglish(),
                midia.getAverageScore(),
                midia.getCoverImage().getExtraLarge(),
                midia.getType()
        );
        return midiaResponse;
    }
//
//    public AnimeCompletoDto requestMidia(Integer idApi){
//        MidiaQuery response = DefaultMetods
//                .postRequestByClass(
//                        MidiaQueries.buscaMidia(idApi),
//                        MidiaQuery.class);
//        if (response != null) {
//            MidiaMedia res = response.getData().getMedia();
//            try{
//                MidiaDadosComplementaresDto dadosComplementares =
//                        receberDadosComplementaresMidia(idApi);
//                AnimeCompletoDto anime = AnimeMapper.createAnimeCompleto(
//                        dadosComplementares,
//                        res);
//                return anime;
//            }catch (Exception e){
//                throw new ResponseStatusException(
//                        HttpStatus.INTERNAL_SERVER_ERROR,
//                        "Erro ao consultar dados de vizualisação, like e deslike");
//            }
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro na consulta de animes");
//        }
//    }
//
//    public MidiaDadosComplementaresDto receberDadosComplementaresMidia(int id){
//        String url = "http://localhost:8080/anime/dados-complementares?id={id}";
//        MidiaDadosComplementaresDto response =
//                DefaultMetods.getRequestByClass(
//                        MidiaDadosComplementaresDto.class,
//                        url,
//                        id);
//        if (response != null) {
//            return response;
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
}
