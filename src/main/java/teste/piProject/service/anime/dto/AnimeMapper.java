package teste.piProject.service.anime.dto;

import teste.piProject.service.anime.AnimeMedia;
import teste.piProject.service.midia.dto.MidiaMedia;
import teste.piProject.service.midia.dto.MidiaParaSalvarDto;

import java.util.Map;

public class AnimeMapper {
    public static AnimeSimplesDto createAnimeSimples(Map<String, Map<String, Map<String, String>>> anime){
        AnimeSimplesDto animeCriado = new AnimeSimplesDto();

        animeCriado.setId(Integer.parseInt(String.valueOf(anime.get("Media").get("id"))));
        animeCriado.setTituloRomaji(String.valueOf(anime.get("Media").get("title").get("romaji")));
        animeCriado.setTituloEnglish(String.valueOf(anime.get("Media").get("title").get("english")));
        animeCriado.setTituloNative(String.valueOf(anime.get("Media").get("title").get("native")));
        return animeCriado;
    }

    public static AnimeCompletoDto createAnimeCompleto(DadosComplementaresDto complementar, AnimeMedia anime){
        AnimeCompletoDto animeResponse = new AnimeCompletoDto(
                anime.getId(),
                anime.getAverageScore(),
                anime.getType(),
                anime.getFormat(),
                anime.getEpisodes(),
                anime.getStatus(),
                anime.getStartDate(),
                anime.getEndDate(),
                anime.getGenres(),
                anime.getTitle(),
                anime.getCoverImage(),
                anime.getDescription(),
                anime.getStudios(),
                anime.getCharacters(),
                anime.getExternalLinks(),
                complementar.getLike(),
                complementar.getDeslike(),
                complementar.getView()
        );
        return animeResponse;
    }

    public static MidiaParaSalvarDto midiaParaSalvar(MidiaMedia midia){
        final MidiaParaSalvarDto midiaResponse = new MidiaParaSalvarDto(
                midia.getId(),
                midia.getTitle().getEnglish(),
                midia.getAverageScore(),
                midia.getCoverImage().getExtraLarge()
        );
        return midiaResponse;
    }

//    public static MidiaParaSalvarDto midiaParaSalvar(AnimeCompletoDto anime){
//        final MidiaParaSalvarDto animeResponse = new MidiaParaSalvarDto(
//                anime.getId(),
//                anime.getTitle().getEnglish(),
//                anime.getAverageScore(),
//                anime.getCoverImage().getExtraLarge()
//        );
//        return animeResponse;
//    }
}
