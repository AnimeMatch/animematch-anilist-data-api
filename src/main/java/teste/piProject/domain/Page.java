package teste.piProject.domain;

import teste.piProject.service.anime.AnimeMedia;
import teste.piProject.service.anime.dto.AnimeCard;

import java.util.List;

public class Page {
    private PageInfo pageInfo;
    private List<AnimeCard> media;

    public Page() {
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AnimeCard> getMedia() {
        return media;
    }

    public void setMedia(List<AnimeCard> media) {
        this.media = media;
    }
}
