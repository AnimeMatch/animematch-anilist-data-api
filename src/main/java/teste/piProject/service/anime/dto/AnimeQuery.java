package teste.piProject.service.anime.dto;

import teste.piProject.service.anime.AnimeData;

public class AnimeQuery {
    private AnimeData data;

    public AnimeQuery() {
    }

    public AnimeQuery(AnimeData data) {
        this.data = data;
    }

    public AnimeData getData() {
        return data;
    }

    public void setData(AnimeData data) {
        this.data = data;
    }
}
