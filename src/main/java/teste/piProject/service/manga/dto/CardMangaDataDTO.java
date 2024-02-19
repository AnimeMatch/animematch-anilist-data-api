package teste.piProject.service.manga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teste.piProject.domain.Page;
import teste.piProject.service.manga.MangaPage;

public class CardMangaDataDTO {
    @JsonProperty("Page")
    private MangaPage page;

    public CardMangaDataDTO() {
    }

    public MangaPage getPage() {
        return page;
    }

    public void setPage(MangaPage page) {
        this.page = page;
    }
}
