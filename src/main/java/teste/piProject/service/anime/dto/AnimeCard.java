package teste.piProject.service.anime.dto;

import teste.piProject.domain.CoverImage;
import teste.piProject.domain.StartEndDate;
import teste.piProject.domain.Titulo;

import java.util.List;

public class AnimeCard {

    private int id;
    private String format;
    private String status;
    private StartEndDate startDate;
    private TituloDto title;
    private CoverImage coverImage;

    public AnimeCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StartEndDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartEndDate startDate) {
        this.startDate = startDate;
    }

    public TituloDto getTitle() {
        return title;
    }

    public void setTitle(TituloDto title) {
        this.title = title;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }
}
