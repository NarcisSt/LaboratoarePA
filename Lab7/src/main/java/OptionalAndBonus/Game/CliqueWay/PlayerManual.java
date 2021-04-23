package OptionalAndBonus.Game.CliqueWay;

import OptionalAndBonus.Utils.Utils;

import java.util.Scanner;

/**
 * This class represents the manual player that will play the game in clique way
 */
public class PlayerManual extends PlayerCliqueGame{
    public PlayerManual(CliqueGame game, String name) {
        super(game, name);
    }

    @Override
    protected void myTurnLogic() {
        int edgesCount = graph.getEdgesCount();
        if (edgesCount == 0) {
            return;
        }
        System.out.println(name + "'s turn. Available edges: ");
        graph.printEdges();
        System.out.println("Your edges: ");
        printMyEdges();

        Edge myEdge = graph.getNthEdge(readEdgePosition());

        edges.add(myEdge);
        graph.removeEdge(myEdge);

        verifyScore();
    }


    /**
     * Method that reads the edge that the player choose from standard input
     * @return
     */
    private int readEdgePosition() {
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        while (true) {
            int firstNode = CompulsoryOptionalBonus.Utils.readIntOption(scanner, "Enter the first node: ");
            int secondNode = CompulsoryOptionalBonus.Utils.readIntOption(scanner, "Enter the second node: ");
            position = graph.getPositionOfEdge(firstNode, secondNode);
            if (position == -1) {
                System.out.println("Wrong edge!");
                continue;
            }
            break;
        }
        return position;
    }
}
