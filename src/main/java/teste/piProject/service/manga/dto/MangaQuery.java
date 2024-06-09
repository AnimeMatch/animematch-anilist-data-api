package teste.piProject.service.manga.dto;

import teste.piProject.service.manga.MangaData;

public class MangaQuery {
    private MangaData data;

    public MangaQuery() {
    }

    public MangaQuery(MangaData data) {
        this.data = data;
    }

    public MangaData getData() {
        return data;
    }

    public void setData(MangaData data) {
        this.data = data;
    }
}
