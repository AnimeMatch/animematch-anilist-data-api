package teste.piProject.service.anime.dto;

import teste.piProject.service.anime.AnimeMedia;

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

    public static AnimeCompletoDto createAnimeCompleto(AnimeDadosComplementaresDto complementar, AnimeMedia anime){
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
                anime.getCharacters(),
                anime.getExternalLinks(),
                complementar.getLike(),
                complementar.getDeslike(),
                complementar.getView()
        );
        return animeResponse;
    }

    public static AnimeParaSalvarDto animeParaSalvar(AnimeCompletoDto anime){
        final AnimeParaSalvarDto animeResponse = new AnimeParaSalvarDto(
                anime.getId(),
                anime.getTitle().getEnglish(),
                anime.getAverageScore(),
                anime.getCoverImage().getExtraLarge()
        );
        return animeResponse;
    }
}
