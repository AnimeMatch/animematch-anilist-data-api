package teste.piProject.service.midia.dto;

import teste.piProject.service.anime.AnimeData;

public class MidiaQuery {
    private MidiaData data;

    public MidiaQuery() {
    }

    public MidiaQuery(MidiaData data) {
        this.data = data;
    }

    public MidiaData getData() {
        return data;
    }

    public void setData(MidiaData data) {
        this.data = data;
    }
}

