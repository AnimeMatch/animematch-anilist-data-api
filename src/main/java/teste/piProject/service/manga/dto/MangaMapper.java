package teste.piProject.service.manga.dto;

import teste.piProject.service.anime.dto.DadosComplementaresDto;
import teste.piProject.service.manga.MangaMedia;

import java.util.Map;

public class MangaMapper {
    public static MangaSimplesDto createMangaSimples(Map<String, Map<String, Map<String, String>>> anime){
        MangaSimplesDto mangaCriado = new MangaSimplesDto();

        mangaCriado.setId(Integer.parseInt(String.valueOf(anime.get("Media").get("id"))));
        mangaCriado.setTituloRomaji(String.valueOf(anime.get("Media").get("title").get("romaji")));
        mangaCriado.setTituloEnglish(String.valueOf(anime.get("Media").get("title").get("english")));
        mangaCriado.setTituloNative(String.valueOf(anime.get("Media").get("title").get("native")));
        return mangaCriado;
    }

    public static MangaCompletoDto createMangaCompleto(DadosComplementaresDto complementar, MangaMedia manga){
        MangaCompletoDto mangaResponse = new MangaCompletoDto(
                manga.getId(),
                manga.getAverageScore(),
                manga.getType(),
                manga.getFormat(),
                manga.getChapters(),
                manga.getVolumes(),
                manga.getStatus(),
                manga.getStartDate(),
                manga.getEndDate(),
                manga.getGenres(),
                manga.getTitle(),
                manga.getCoverImage(),
                manga.getDescription(),
                manga.getStudios(),
                manga.getCharacters(),
                manga.getExternalLinks(),
                complementar.getLike(),
                complementar.getDeslike(),
                complementar.getView()
        );
        return mangaResponse;
    }
}
