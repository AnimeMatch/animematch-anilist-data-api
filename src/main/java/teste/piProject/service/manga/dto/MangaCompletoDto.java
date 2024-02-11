package teste.piProject.service.manga.dto;

import teste.piProject.domain.*;
import teste.piProject.service.anime.dto.Studios;

import java.util.List;

public class MangaCompletoDto {
    private int id;
    private int averageScore;
    private String type;
    private String format;
    private int chapters;
    private int volumes;
    private String status;
    private StartEndDate startDate;
    private StartEndDate endDate;
    private List<String> genres;
    private Titulo title;
    private CoverImage coverImage;
    private String description;
    private Studios studios;
    private Characters characters;
    private List<Plataforma> externalLinks;
    private int like;
    private int deslike;
    private int views;

    public MangaCompletoDto() {
    }

    public MangaCompletoDto(int id, int averageScore, String type, String format, int chapters, int volumes, String status, StartEndDate startDate, StartEndDate endDate, List<String> genres, Titulo title, CoverImage coverImage, String description, Studios studios, Characters characters, List<Plataforma> externalLinks, int like, int deslike, int views) {
        this.id = id;
        this.averageScore = averageScore;
        this.type = type;
        this.format = format;
        this.chapters = chapters;
        this.volumes = volumes;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.genres = genres;
        this.title = title;
        this.coverImage = coverImage;
        this.description = description;
        this.studios = studios;
        this.characters = characters;
        this.externalLinks = externalLinks;
        this.like = like;
        this.deslike = deslike;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
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

    public StartEndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(StartEndDate endDate) {
        this.endDate = endDate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Titulo getTitle() {
        return title;
    }

    public void setTitle(Titulo title) {
        this.title = title;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Studios getStudios() {
        return studios;
    }

    public void setStudios(Studios studios) {
        this.studios = studios;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public List<Plataforma> getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(List<Plataforma> externalLinks) {
        this.externalLinks = externalLinks;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDeslike() {
        return deslike;
    }

    public void setDeslike(int deslike) {
        this.deslike = deslike;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
