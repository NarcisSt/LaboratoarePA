package Optional;

import java.util.ArrayList;

/**
 * @author Barat Narcis Stefan
 * This class is used to create a node, which are identified by his id.
 * And also creates a list of nodes, which are connected to it.
 */
public class Node {
    int id;
    ArrayList<Integer> connectedNodes = new ArrayList<Integer>();

    /**
     * This is the constructor of the class with one parameter
     * @param id the node id
     */
    public Node(int id) {
        this.id = id;
    }
}
