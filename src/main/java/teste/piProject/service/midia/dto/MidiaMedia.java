package teste.piProject.service.midia.dto;

import teste.piProject.domain.CoverImage;
import teste.piProject.domain.Titulo;

public class MidiaMedia {
    private int id;
    private Titulo title;
    private int averageScore;
    private CoverImage coverImage;

    public MidiaMedia() {
    }

    public MidiaMedia(int id, Titulo title, int averageScore, CoverImage coverImage) {
        this.id = id;
        this.title = title;
        this.averageScore = averageScore;
        this.coverImage = coverImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Titulo getTitle() {
        return title;
    }

    public void setTitle(Titulo title) {
        this.title = title;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }
}
