package teste.piProject.service.anime.dto;

import teste.piProject.domain.PageInfo;
import teste.piProject.service.anime.dto.AnimeCard;

import java.util.List;

public class AnimePage {
    private PageInfo pageInfo;
    private List<AnimeCard> media;

    public AnimePage() {
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
