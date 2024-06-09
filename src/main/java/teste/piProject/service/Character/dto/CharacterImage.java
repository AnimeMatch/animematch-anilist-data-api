package teste.piProject.service.Character.dto;

public class CharacterImage {
    private int id;
    private ImageCharacterUnitario image;

    public CharacterImage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageCharacterUnitario getImage() {
        return image;
    }

    public void setImage(ImageCharacterUnitario image) {
        this.image = image;
    }

    public class ImageCharacterUnitario {
        private String large;

        public ImageCharacterUnitario() {
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }
}
