package teste.piProject.service.anime;

import teste.piProject.domain.*;

import java.util.List;

public class AnimeMedia {
    private int id;
    private Double notaMedia;
    private String tipoMidia;
    private String formato;
    private Integer episodios;
    private String status;
    private StartDate dataLancamento;
    private EndDate dataFinalizado;
    private List<String> generos;
    private Titulo titulos;
    private String descricao;
    private List<Personagem> personagens;
    private List<Plataforma> linksExternos;

    public AnimeMedia(int id, Double notaMedia, String tipoMidia, String formato, Integer episodios, String status, StartDate dataLancamento, EndDate dataFinalizado, List<String> generos, Titulo titulos, String descricao, List<Personagem> personagens, List<Plataforma> linksExternos) {
        this.id = id;
        this.notaMedia = notaMedia;
        this.tipoMidia = tipoMidia;
        this.formato = formato;
        this.episodios = episodios;
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

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StartDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(StartDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public EndDate getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(EndDate dataFinalizado) {
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
