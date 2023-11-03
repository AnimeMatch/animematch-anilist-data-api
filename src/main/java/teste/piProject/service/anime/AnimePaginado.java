package teste.piProject.service.anime;

import teste.piProject.domain.PageInfo;

import java.util.List;

public class AnimePaginado {
    private PageInfo pageInfo;
    private List<AnimeMedia> media;

    public AnimePaginado() {
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AnimeMedia> getMedia() {
        return media;
    }

    public void setMedia(List<AnimeMedia> media) {
        this.media = media;
    }
}
