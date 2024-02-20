package teste.piProject.service.anime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDataDto {
    @JsonProperty("Page")
    private AnimePage animePage;

    public CardDataDto() {
    }

    public AnimePage getPage() {
        return animePage;
    }

    public void setPage(AnimePage animePage) {
        this.animePage = animePage;
    }
}
