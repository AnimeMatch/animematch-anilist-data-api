package teste.piProject.domain.anime;

public class Anime {
    private int id;
    private String title;
    private String description;
    private String coverImgExtraLarge;
    private String coverImgLarge;
    private String coverImgMedium;
    private String bannerImg;

    public Anime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImgExtraLarge() {
        return coverImgExtraLarge;
    }

    public void setCoverImgExtraLarge(String coverImgExtraLarge) {
        this.coverImgExtraLarge = coverImgExtraLarge;
    }

    public String getCoverImgLarge() {
        return coverImgLarge;
    }

    public void setCoverImgLarge(String coverImgLarge) {
        this.coverImgLarge = coverImgLarge;
    }

    public String getCoverImgMedium() {
        return coverImgMedium;
    }

    public void setCoverImgMedium(String coverImgMedium) {
        this.coverImgMedium = coverImgMedium;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }
}
