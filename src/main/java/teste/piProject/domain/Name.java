package teste.piProject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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
