package OptionalAndBonus.Game.CliqueWay;

import OptionalAndBonus.Game.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class describes the player that will plat the clique game
 */
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

    /**
     * Prints to the standard input the best clique of this player
     */
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

    /**
     * Method that display the edges of the current player
     */
    protected void printMyEdges() {
        for (int i = 0; i < edges.size(); ++i) {
            System.out.println(edges.get(i));
            if (i + 1 < edges.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Method that checks if the player has won the game
     */
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

    /**
     * Method that returns the clique with the maximum number of nodes of this player
     */
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

    /**
     * Method that checks if the player's clique is formed by existent nodes
     * @param nodes
     * @return
     */
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

    /**
     * Method that returns the position of the edge represented by firstNode and secondNode.
     * It uses binary search
     * @param firstNode
     * @param secondNode
     * @return
     */
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
