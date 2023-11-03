package teste.piProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Titulo {
    private String romaji;
    @JsonProperty("native")
    private String nativeTitle;
    private String english;
}
