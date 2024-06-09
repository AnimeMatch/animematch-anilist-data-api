package teste.piProject.service.queries;

import teste.piProject.util.DefaultMetods;

import java.util.Map;

public class MidiaQueries {

    public static Map<String, String> buscaMidia(Integer idApi){
        String body = "query\n" +
                "{\n" +
                "  Media (id: %d){\n".formatted(idApi) +
                "   id\n" +
                "    title {\n" +
                "      romaji\n" +
                "      native\t\n" +
                "      english\n" +
                "    }\n" +
                "    averageScore\n" +
                "    coverImage {\n" +
                "      extraLarge\n" +
                "      large\n" +
                "    }\n" +
                "    type" +
                "  }\n" +
                "}";
        return DefaultMetods.query(body);
    }
}
