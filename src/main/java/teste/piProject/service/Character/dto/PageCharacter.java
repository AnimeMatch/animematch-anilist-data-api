package teste.piProject.service.Character.dto;

import teste.piProject.domain.PageInfo;

import java.util.List;

public class PageCharacter {
    private PageInfo pageInfo;
    private List<CharacterImage> characters;

    public PageCharacter() {
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<CharacterImage> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterImage> characters) {
        this.characters = characters;
    }
}
