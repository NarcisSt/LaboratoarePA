package OptionalAndBonus.Game.CliqueWay;

import OptionalAndBonus.Game.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerCliqueGame extends Player {
    protected CliqueGame game;
    protected Graph graph;
    protected List<Edge> edges;

    public PlayerCliqueGame(CliqueGame game, String name) {
        super(name);
        this.game = game;
        this.graph = game.getGraph();
        this.edges = new ArrayList<>();
    }

    public void printClique() {
        Clique clique = getMaximumClique();
        List<Integer> nodes = clique.getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i));
            if (i + 1 < nodes.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printEdges() {
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }

    protected void printMyEdges() {
        for (int i = 0; i < edges.size(); ++i) {
            System.out.println(edges.get(i));
            if (i + 1 < edges.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    protected void verifyScore() {
        int myScore = getScore();

        if (myScore == game.getK()) {
            game.announceWinner(this);
        }
    }

    @Override
    protected boolean checkIfTheGameIsRunning() {
        return game.isRunning();
    }

    @Override
    protected void myTurnLogic() {

    }

    @Override
    public int getScore() {
        return getMaximumClique().getNodesCount();
    }

    private Clique getMaximumClique() {
        Clique clique = new Clique();
        Collections.sort(edges);
        int n = graph.getNumberOfNodes();
        int lastConfiguration = (1 << n);

        for (int i = 0; i < lastConfiguration; i++) {
            List<Integer> nodes = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    nodes.add(j + 1);
                }
            }
            if (goodSubsetOfNodes(nodes)) {
                if (nodes.size() > clique.getNodesCount()) {
                    clique.setNodes(nodes);
                }
            }
        }
        return clique;
    }

    private boolean goodSubsetOfNodes(List<Integer> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                int positionInArray = binarySearchEdgePosition(nodes.get(i), nodes.get(j));
                if (positionInArray == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int binarySearchEdgePosition(Integer firstNode, Integer secondNode) {
        int left = 0;
        int right = edges.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Edge edge = edges.get(mid);
            if (edge.getFirstNode() == firstNode) {
                if (edge.getSecondNode() == secondNode) {
                    return mid;
                } else if (edge.getSecondNode() > secondNode) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (edge.getSecondNode() > secondNode) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
