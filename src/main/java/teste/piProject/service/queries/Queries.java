package teste.piProject.service.queries;

import teste.piProject.util.DateDetails;
import teste.piProject.util.DefaultMetods;

import java.util.Map;
import static teste.piProject.util.Types.TypeMedia;
public class Queries {

    private TypeMedia typeMedia;

    public Queries(TypeMedia typeMedia) {
        this.typeMedia = typeMedia;
    }

    public Map<String, String> buscaAnime(Integer id){
        String contenty = this.typeMedia == TypeMedia.ANIME ? "episodes" : "    chapters\n    volumes";
        String body = "query \n" +
                "{\n" +
                "    Media (type: ANIME, id: %d){\n".formatted(id) +
                "    id\n" +
                "    averageScore\n" +
                "    type\n" +
                "    format\n" +
                contenty +
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
                "\n    studios {\n" +
                "      nodes{\n" +
                "        name\n" +
                "      }\n" +
                "    }" +
                "      externalLinks {\n" +
                "      site\n" +
                "      url\n" +
                "      icon\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return DefaultMetods.query(body);
    }

    public Map<String, String> animeSeason(Integer pagina, Integer porPagina){
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

//    public static Map<String, String> animeMoreliked(Integer pagina, Integer porPagina){
//
//    }

    public Map<String, String> buscaAnimePeloNome(String tituloBusca, Integer pagina, Integer porPagina){
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
                "    media (type: ANIME, search: \"%s\", sort: POPULARITY_DESC){\n".formatted(tituloBusca) +
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

    public Map<String, String> buscaPeloGenero(String generoBusca, Integer pagina, Integer porPagina){
        String uri;
        if (generoBusca == "") {
            uri =  "    media (type: ANIME, sort: POPULARITY_DESC){\n";
        } else {
            uri = "    media (type: ANIME, genre: \"%s\", sort: POPULARITY_DESC){\n".formatted(generoBusca);
        }
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
                uri +
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

    public Map<String, String> ReceberAnimesEmTrend(Integer pagina, Integer porPagina){
        String filtro = "    media (type: ANIME, sort: [TRENDING_DESC, POPULARITY_DESC]){\n";
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
                filtro +
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
