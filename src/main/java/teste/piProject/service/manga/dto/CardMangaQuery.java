package teste.piProject.service.manga.dto;

import teste.piProject.service.anime.dto.CardDataDto;

public class CardMangaQuery {
    private CardMangaDataDTO data;

    public CardMangaQuery() {
    }

    public CardMangaDataDTO getData() {
        return data;
    }

    public void setData(CardMangaDataDTO data) {
        this.data = data;
    }
}
