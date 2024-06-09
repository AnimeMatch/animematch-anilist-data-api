package teste.piProject.service.anime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teste.piProject.domain.Page;

public class CardDataDto {
    @JsonProperty("Page")
    private Page page;

    public CardDataDto() {
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
