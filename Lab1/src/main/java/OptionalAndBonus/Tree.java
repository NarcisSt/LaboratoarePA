package OptionalAndBonus;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Barat Narcis Stefan
 * In this class i am creating the adjacency matrix of the partial tree.
 */
public class Tree extends Matrix {
    ArrayList<Node> nodes = new ArrayList<Node>();

    int[][] partialGraphMatrix;
    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

    public Tree(int nodes) {
        super(nodes);
    }

    /**
     * This method return a node based on his id.
     * @param id the id of the node
     * @return the Node based on the id
     */
    public Node getNode(int id) {
        for (Node node : this.nodes) {
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }

    /**
     * Method that display the adjacency list of the graph.
     */
    public void showNodes() {
        System.out.println();
        for (Node node : this.nodes) {
            System.out.println("Node: " + node.id);
            System.out.print("Connected to: ");
            for (int connect : node.connectedNodes) {
                System.out.print(connect + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method that generate the adjacency list of the graph.
     * Initialize the hashmap which will be used to visit all the nodes, and the adjacency matrix of the partial tree.
     */
    public void generateNodes() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (matrix[i][j] == 1) {
                    //if node not exist, add it with connection
                    //if node exist, add connection
                    Node node = this.getNode(i);
                    if (node == null) {
                        Node newNode = new Node(i);
                        newNode.connectedNodes.add(j);
                        this.nodes.add(newNode);
                    } else {
                        node.connectedNodes.add(j);
                    }
                }
            }
        }

        //set visited dictionary and partial graph matrix
        for (Node node : this.nodes) {
            this.visited.put(node.id, false);
        }
        this.partialGraphMatrix = new int[n][n];
    }

    /**
     * Method that check if all the nodes are visited or not.
     * @return true if all nodes are visited, or false if not
     */
    public boolean areAllNodeVisited() {
        for (Boolean value : this.visited.values()) {
            if (value == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method, starting from node 0, check if all the nodes are visited, if not, it goes to the next node (e.g 1).
     * And display the adjacency matrix of the partial tree.
     */
    public void getPartialGraphMatrix() {
        int count = 0;
        while (!areAllNodeVisited()) {
            if (!this.visited.get(count)) {
                this.setMatrixForGivenNode(count);
            }
            count++;
        }

        System.out.println("The adjacency matrix of the partial tree:");
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(this.partialGraphMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method, based on an id, get the node, and mark it as visited in the hashmap with all his connections.
     * Also, complete the adjacency matrix of the partial tree.
     * @param id the id of starting node
     */
    public void setMatrixForGivenNode(int id) {
        Node startingNode = this.getNode(id);
        this.visited.put(startingNode.id, true);

        for (int node : startingNode.connectedNodes) {
            this.visited.put(node, true);
            this.partialGraphMatrix[startingNode.id][node] = 1;
            this.partialGraphMatrix[node][startingNode.id] = 1;
        }
    }
}
