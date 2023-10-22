package teste.piProject.service.anime.model;

import teste.piProject.service.Defaults;

import java.util.HashMap;
import java.util.Map;

public class AnimeRequests {
    public static Map<String, String> buscaAnimeComum(String nome){
        String body = "query {\n" +
                "Media(search: \"%s\", type: ANIME, format_in: TV, status: FINISHED) {\n".formatted(nome) +
                "id\n" +
                "title {\n" +
                "romaji\n" +
                "english\n" +
                "native\n" +
                "}\n" +
                "}\n" +
                "}";
        return Defaults.query(body);
    }
}
