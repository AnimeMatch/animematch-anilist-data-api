package teste.piProject.service.anime.dto;

public class AnimeCard {
    private int card;
    private String title;
    private String coverImage;

    public AnimeCard() {
    }

    public AnimeCard(int card, String title, String coverImage) {
        this.card = card;
        this.title = title;
        this.coverImage = coverImage;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
