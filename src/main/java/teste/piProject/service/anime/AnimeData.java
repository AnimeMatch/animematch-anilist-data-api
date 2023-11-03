package teste.piProject.service.anime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimeData {
    @JsonProperty("Media")
    private AnimeMedia media;

    public AnimeData() {
    }

    public AnimeData(AnimeMedia media) {
        this.media = media;
    }

    public AnimeMedia getmedia() {
        return media;
    }

    public void setmedia(AnimeMedia media) {
        this.media = media;
    }
}
