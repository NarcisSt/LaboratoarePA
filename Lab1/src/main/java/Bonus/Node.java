package Bonus;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Barat Narcis Stefan
 */

public class Node {
    int level;
    int position;
    int number;
    ArrayList<Node> subNodes = new ArrayList<>();

    /**
     * The initial constructor for the parent node(0), used once.
     */
    public Node() {
        this.level = 0;
        this.position = 0;
        this.number = 0;
        this.generateSubNodes(this.level + 1);
    }

    /**
     * This constructor is used to set the level, position and the number of the node.
     * And it starts to generate the nodes for the next level.
     * @param level used to the tree depth
     * @param position used for the position on the same level
     * @param number used to count the total number of nodes
     */
    public Node(int level, int position, int number) {
        this.level = level;
        this.position = position;
        this.number = number;
        this.generateSubNodes(this.level + 1);
    }

    /**
     * The method that generates the sub nodes of the current node.
     * @param level used to the tree depth
     */
    public void generateSubNodes(int level) {
        int size = this.generateRandom();
        for (int i = 0; i < size; i++) {
            Node node = new Node(level, i, this.getLatestNumber() + 1);
            this.subNodes.add(node);
        }
    }

    /**
     * This method shows recursive the details about the nodes, and display the tree structure.
     */
    public void showNodes() {
        String sign = this.subNodes.size() > 0 ? "+" : "-";
        String spaces = this.getSpaces();
        System.out.println(spaces + sign + "node" + this.number + " | " + "node" + this.level + "." + this.position);
        for (Node node : this.subNodes) {
            node.showNodes();
        }
    }

    /**
     * @return the number of the latest node created.
     */
    public int getLatestNumber() {
        if (this.subNodes.size() > 0) {
            Node latestNode = this.subNodes.get(this.subNodes.size() - 1);
            return latestNode.getLatestNumber();
        } else {
            return this.number;
        }
    }

    /**
     * @return the spaces based on the level.
     */
    private String getSpaces() {
        String value = "";
        for (int i = 0; i < this.level; i++) {
            value += "  ";
        }
        return value;
    }

    /**
     * @return a random number between 0 and bound (in our case it can be 0, 1, or 2 to avoid big trees)
     */
    private int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
