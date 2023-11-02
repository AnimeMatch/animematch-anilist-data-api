package teste.piProject.service.anime.queries;

import teste.piProject.util.DefaultMetods;

import java.util.Map;

public class AnimeQueries {
    public static Map<String, String> buscaAnime(Integer id){
        String body = "query \n" +
                "{\n" +
                "    Media (type: ANIME, id: %d){\n".formatted(id) +
                "      id\n" +
                "      averageScore\n" +
                "      type\n" +
                "      format\n" +
                " \t\t\tepisodes     \n" +
                "      status\n" +
                "      startDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "      endDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "      genres\n" +
                "      title{\n" +
                "        romaji\n" +
                "        native\n" +
                "        english\n" +
                "      }\n" +
                "      \n" +
                "      description\n" +
                "      characters {\n" +
                "        edges {\n" +
                "          id\n" +
                "        }\n" +
                "      }\n" +
                "\t\t\texternalLinks {\n" +
                "        site\n" +
                "        url\n" +
                "        icon\n" +
                "\t\t\t}\n" +
                "    }\n" +
                "}";
        return DefaultMetods.query(body);
    }

    public static Map<String, String> buscaCards(String nome){
        String body = "query \n" +
                "{\n" +
                "  Page (page: 1, perPage: 1) {\n" +
                "        pageInfo {\n" +
                "            total\n" +
                "            currentPage\n" +
                "            lastPage\n" +
                "            hasNextPage\n" +
                "            perPage\n" +
                "        }\n" +
                "    media (search: \"%s\", type: ANIME, sort:SCORE_DESC, format_in: TV){\n".formatted(nome) +
                "      id\n" +
                "      averageScore\n" +
                "      type\n" +
                "      format\n" +
                " \t\t\tepisodes     \n" +
                "      status\n" +
                "      startDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "      endDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "      genres\n" +
                "      title{\n" +
                "        romaji\n" +
                "        native\n" +
                "        english\n" +
                "      }\n" +
                "      \n" +
                "      description\n" +
                "      characters {\n" +
                "        edges {\n" +
                "          id\n" +
                "        }\n" +
                "      }\n" +
                "\t\t\texternalLinks {\n" +
                "        site\n" +
                "        url\n" +
                "        icon\n" +
                "\t\t\t}\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        return DefaultMetods.query(body);
    }

    public static Map<String, String> buscaAnimeSimples(String nome){
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
        return DefaultMetods.query(body);
    }
}
