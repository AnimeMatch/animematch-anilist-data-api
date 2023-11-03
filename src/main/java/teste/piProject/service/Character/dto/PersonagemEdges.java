package teste.piProject.service.Character.dto;

import java.util.List;

public class PersonagemEdges {
    private List<PersonagemIdDto> edges;

    public PersonagemEdges() {
    }

    public List<PersonagemIdDto> getEdges() {
        return edges;
    }

    public void setEdges(List<PersonagemIdDto> edges) {
        this.edges = edges;
    }
}
