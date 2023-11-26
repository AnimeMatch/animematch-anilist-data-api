package teste.piProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Titulo {
    @JsonProperty("romaji")
    private String romaji;
    @JsonProperty("native")
    private String nativeTitle;
    @JsonProperty("english")
    private String english;

    public Titulo() {
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getNativeTitle() {
        return nativeTitle;
    }

    public void setNativeTitle(String nativeTitle) {
        this.nativeTitle = nativeTitle;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
