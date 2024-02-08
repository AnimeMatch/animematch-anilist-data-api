package teste.piProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeCharacter {
    private int id;
    private Name name;
    private Image image;

    public NodeCharacter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public class Name {
        private String full;
        @JsonProperty("native")
        private String nativeName;

        public Name() {
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }
    }

    public class Image {
        private String large;

        public Image() {
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }
}
