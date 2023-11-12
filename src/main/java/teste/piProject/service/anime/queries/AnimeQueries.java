package teste.piProject.service.anime.queries;

import teste.piProject.util.DateDetails;
import teste.piProject.util.DefaultMetods;

import java.util.Map;

public class AnimeQueries {
    public static Map<String, String> buscaAnime(Integer id){
        String body = "query \n" +
                "{\n" +
                "    Media (type: ANIME, id: %d){\n".formatted(id) +
                "    id\n" +
                "    averageScore\n" +
                "    type\n" +
                "    format\n" +
                "   \tepisodes     \n" +
                "    status\n" +
                "    startDate {\n" +
                "      year\n" +
                "      month\n" +
                "      day\n" +
                "    }\n" +
                "    endDate {\n" +
                "      year\n" +
                "      month\n" +
                "      day\n" +
                "    }\n" +
                "    genres\n" +
                "    title{\n" +
                "      romaji\n" +
                "      native\n" +
                "      english\n" +
                "    }\n" +
                "\t\tcoverImage {\n" +
                "\t\t  extraLarge\n" +
                "\t\t  large\n" +
                "\t\t}\n" +
                "    description\n" +
                "    characters {\n" +
                "      nodes {\n" +
                "          id\n" +
                "          name {\n" +
                "            full\n" +
                "            native\n" +
                "          }\n" +
                "          image {\n" +
                "            large\n" +
                "          }\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "      externalLinks {\n" +
                "      site\n" +
                "      url\n" +
                "      icon\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return DefaultMetods.query(body);
    }

    public static Map<String, String> animeSeason(Integer pagina, Integer porPagina){
        String body = "query\n" +
                "{\n" +
                "  Page (page: %d, perPage: %d) {\n".formatted(pagina, porPagina) +
                "        pageInfo {\n" +
                "            total\n" +
                "            currentPage\n" +
                "            lastPage\n" +
                "            hasNextPage\n" +
                "            perPage\n" +
                "        }\n" +
                "\n" +
                "    media (type: ANIME, season: %s, seasonYear: %d, sort: POPULARITY_DESC){\n".formatted(
                        DateDetails.estacaoAtual(), DateDetails.anoAtual()) +
                "      id\n" +
                "      averageScore\n" +
                "      type\n" +
                "      format\n" +
                "      status\n" +
                "      startDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "      title{\n" +
                "        romaji\n" +
                "        english\n" +
                "      }\n" +
                "      coverImage {\n" +
                "        extraLarge\n" +
                "        large\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return DefaultMetods.query(body);
    }
}
