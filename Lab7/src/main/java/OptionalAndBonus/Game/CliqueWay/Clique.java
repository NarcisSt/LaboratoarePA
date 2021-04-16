package OptionalAndBonus.Game.CliqueWay;

import java.util.ArrayList;
import java.util.List;

/**
 * The Clique class represents a clique(a complete subgraph of a graph)
 */
public class Clique {
    private List<Integer> nodes;

    public Clique() {
         nodes = new ArrayList<>();
    }

    public List<Integer> getNodes() {
        return nodes;
    }

    public void setNodes(List<Integer> nodes) {
        this.nodes = nodes;
    }

    public int getNodesCount() {
        return nodes.size();
    }
}
