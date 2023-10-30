package teste.piProject.domain;

import java.text.DateFormat;

public class Personagem {
    private int id;
    private String fullName;
    private String imgLarge;
    private String imgMedium;
    private String description;
    private String gender;
    private String age;
    private DateFormat dateOfBirth;

    public Personagem() {
    }
    public Personagem(int id) {
        this.id = id;
    }

    public Personagem(int id, String fullName,
                      String imgLarge, String imgMedium,
                      String description, String gender,
                      String age, DateFormat dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.imgLarge = imgLarge;
        this.imgMedium = imgMedium;
        this.description = description;
        this.gender = gender;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public String getImgMedium() {
        return imgMedium;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public DateFormat getDateOfBirth() {
        return dateOfBirth;
    }
}
