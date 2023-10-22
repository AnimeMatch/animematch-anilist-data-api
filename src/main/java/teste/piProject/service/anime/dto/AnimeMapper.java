package teste.piProject.service.anime.dto;

import java.util.Map;

public class AnimeMapper {
    public static AnimeDto createAnime(Map<String, Map<String, Map<String, String>>> anime){
        AnimeDto animeCriado = new AnimeDto();

        animeCriado.setId(Integer.parseInt(String.valueOf(anime.get("Media").get("id"))));
        animeCriado.setTituloRomaji(String.valueOf(anime.get("Media").get("title").get("romaji")));
        animeCriado.setTituloEnglish(String.valueOf(anime.get("Media").get("title").get("english")));
        animeCriado.setTituloNative(String.valueOf(anime.get("Media").get("title").get("native")));
        return animeCriado;
    }
}
