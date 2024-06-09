package teste.piProject.service.manga;

import teste.piProject.domain.*;

import java.util.List;

public class MangaMedia {
    private int id;
    private Double notaMedia;
    private String tipoMidia;
    private String formato;
    private Integer Capitulos;
    private String status;
    private StartEndDate dataLancamento;
    private StartEndDate dataFinalizado;
    private List<String> generos;
    private Titulo titulos;
    private String descricao;
    private List<Personagem> personagens;
    private List<Plataforma> linksExternos;

    public MangaMedia(int id, Double notaMedia, String tipoMidia, String formato, Integer capitulos, String status, StartEndDate dataLancamento, StartEndDate dataFinalizado, List<String> generos, Titulo titulos, String descricao, List<Personagem> personagens, List<Plataforma> linksExternos) {
        this.id = id;
        this.notaMedia = notaMedia;
        this.tipoMidia = tipoMidia;
        this.formato = formato;
        Capitulos = capitulos;
        this.status = status;
        this.dataLancamento = dataLancamento;
        this.dataFinalizado = dataFinalizado;
        this.generos = generos;
        this.titulos = titulos;
        this.descricao = descricao;
        this.personagens = personagens;
        this.linksExternos = linksExternos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getCapitulos() {
        return Capitulos;
    }

    public void setCapitulos(Integer capitulos) {
        Capitulos = capitulos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StartEndDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(StartEndDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public StartEndDate getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(StartEndDate dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public Titulo getTitulos() {
        return titulos;
    }

    public void setTitulos(Titulo titulos) {
        this.titulos = titulos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public List<Plataforma> getLinksExternos() {
        return linksExternos;
    }

    public void setLinksExternos(List<Plataforma> linksExternos) {
        this.linksExternos = linksExternos;
    }
}
