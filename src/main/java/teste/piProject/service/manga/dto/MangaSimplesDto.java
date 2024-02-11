package teste.piProject.service.manga.dto;

public class MangaSimplesDto {
    private int id;
    private String tituloRomaji;
    private String tituloEnglish;
    private String tituloNative;

    public MangaSimplesDto() {
    }

    public MangaSimplesDto(int id, String tituloRomaji, String tituloEnglish, String tituloNative) {
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
