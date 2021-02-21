package Bonus;

/**
 * @author Barat Narcis Stefan
 */

public class Main {
    public static void main(String[] args) {
        Node parent = new Node();
        parent.showNodes();
        System.out.println();
        System.out.println("Generated " + (parent.getLatestNumber() + 1) + " nodes");
    }
}
