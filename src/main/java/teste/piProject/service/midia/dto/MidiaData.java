package teste.piProject.service.midia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.print.attribute.standard.Media;

public class MidiaData {
    @JsonProperty("Media")
    private MidiaMedia media;

    public MidiaData() {
    }

    public MidiaMedia getMedia() {
        return media;
    }

    public void setMedia(MidiaMedia media) {
        this.media = media;
    }
}
