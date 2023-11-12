package teste.piProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Titulo {
    @JsonProperty("romaji")
    private String romaji;
    @JsonProperty("native")
    private String nativeTitle;
    @JsonProperty("english")
    private String english;
}
