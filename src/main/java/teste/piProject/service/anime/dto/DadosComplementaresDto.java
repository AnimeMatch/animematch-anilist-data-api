package teste.piProject.service.anime.dto;

<<<<<<<< HEAD:src/main/java/teste/piProject/service/anime/dto/AnimeDadosComplementaresDto.java
public class AnimeDadosComplementaresDto {
========
public class DadosComplementaresDto {
>>>>>>>> a35d42dac9b2ce4983f75ba85ccf79ba7d6bcf51:src/main/java/teste/piProject/service/anime/dto/DadosComplementaresDto.java
    private int like;
    private int deslike;
    private int view;

<<<<<<<< HEAD:src/main/java/teste/piProject/service/anime/dto/AnimeDadosComplementaresDto.java
    public AnimeDadosComplementaresDto() {
    }

    public AnimeDadosComplementaresDto(int like, int deslike, int view) {
========
    public DadosComplementaresDto() {
    }

    public DadosComplementaresDto(int like, int deslike, int view) {
>>>>>>>> a35d42dac9b2ce4983f75ba85ccf79ba7d6bcf51:src/main/java/teste/piProject/service/anime/dto/DadosComplementaresDto.java
        this.like = like;
        this.deslike = deslike;
        this.view = view;
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

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
