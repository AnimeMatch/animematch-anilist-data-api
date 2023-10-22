package teste.piProject.service.anime.dto;

public class AnimeDto {
    private int id;
    private String tituloRomaji;
    private String tituloEnglish;
    private String tituloNative;

    public AnimeDto() {
    }

    public AnimeDto(int id, String tituloRomaji, String tituloEnglish, String tituloNative) {
        this.id = id;
        this.tituloRomaji = tituloRomaji;
        this.tituloEnglish = tituloEnglish;
        this.tituloNative = tituloNative;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloRomaji() {
        return tituloRomaji;
    }

    public void setTituloRomaji(String tituloRomaji) {
        this.tituloRomaji = tituloRomaji;
    }

    public String getTituloEnglish() {
        return tituloEnglish;
    }

    public void setTituloEnglish(String tituloEnglish) {
        this.tituloEnglish = tituloEnglish;
    }

    public String getTituloNative() {
        return tituloNative;
    }

    public void setTituloNative(String tituloNative) {
        this.tituloNative = tituloNative;
    }
}
