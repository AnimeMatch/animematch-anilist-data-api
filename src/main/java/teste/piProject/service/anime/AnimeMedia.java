package teste.piProject.service.anime;
import teste.piProject.domain.*;
import teste.piProject.service.Character.CharacterData;
import teste.piProject.service.Character.dto.PersonagemEdges;
import java.util.List;

public class AnimeMedia {
    private int id;
    private int averageScore;
    private String type;
    private String format;
    private int episodes;
    private String status;
    private StartEndDate startDate;
    private StartEndDate endDate;
    private List<String> genres;
    private Titulo title;
    private CoverImage coverImage;
    private String description;
    private Characters characters;
    private List<Plataforma> externalLinks;

    public AnimeMedia() {
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

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
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

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
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
}
