package teste.piProject.service.Character.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataCharacterImage {
    @JsonProperty("Page")
    private PageCharacter page;

    public DataCharacterImage() {
    }

    public PageCharacter getPage() {
        return page;
    }

    public void setPage(PageCharacter page) {
        this.page = page;
    }
}
