package teste.piProject.service.anime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TituloDto {
    private String romaji;
    private String english;

    public TituloDto() {
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
