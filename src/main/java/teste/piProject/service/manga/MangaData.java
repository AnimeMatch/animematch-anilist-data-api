package teste.piProject.service.manga;

import com.fasterxml.jackson.annotation.JsonProperty;
import teste.piProject.service.anime.AnimeMedia;

public class MangaData {
    @JsonProperty("Media")
    private MangaMedia media;

    public MangaData() {
    }

    public MangaData(MangaMedia media) {
        this.media = media;
    }

    public MangaMedia getMedia() {
        return media;
    }

    public void setMedia(MangaMedia media) {
        this.media = media;
    }
}
