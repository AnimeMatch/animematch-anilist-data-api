package teste.piProject.service.anime;

import teste.piProject.domain.AnimeMedia;

public class AnimeData {
    private AnimeMedia animeMedia;

    public AnimeData() {
    }

    public AnimeData(AnimeMedia animeMedia) {
        this.animeMedia = animeMedia;
    }

    public AnimeMedia getAnimeMedia() {
        return animeMedia;
    }

    public void setAnimeMedia(AnimeMedia animeMedia) {
        this.animeMedia = animeMedia;
    }
}
