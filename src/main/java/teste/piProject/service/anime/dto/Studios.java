package teste.piProject.service.anime.dto;

import teste.piProject.domain.Name;

import java.util.List;

public class Studios {
    private List<NameStudio> nodes;

    public Studios() {
    }

    public List<NameStudio> getNodes() {
        return nodes;
    }

    public void setNodes(List<NameStudio> nodes) {
        this.nodes = nodes;
    }
}
