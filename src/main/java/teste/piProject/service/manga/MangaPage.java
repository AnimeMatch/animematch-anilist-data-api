package teste.piProject.service.manga;

import teste.piProject.domain.PageInfo;
import teste.piProject.service.manga.MangaMedia;

import java.util.List;

public class MangaPage {
    private PageInfo pageInfo;
    private List<MangaMedia> media;

    public MangaPage() {
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<MangaMedia> getMedia() {
        return media;
    }

    public void setMedia(List<MangaMedia> media) {
        this.media = media;
    }
}
