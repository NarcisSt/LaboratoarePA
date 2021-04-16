package OptionalAndBonus.Game.CliqueWay;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the graph
 */
public class Graph {
    private List<Edge> edges;
    private int numberOfNodes;

    public Graph(int n) {
        numberOfNodes = n;
        edges = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edges.add(new Edge(i, j));
            }
        }
    }

    /**
     * Method that returns the number of edges from the graph
     * @return
     */
    public int getEdgesCount() {
        return edges.size();
    }

    /**
     * Method that returns the number of nodes from the graph
     * @return
     */
    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Method that returns the position of the edge represented by firstNode and secondNode.
     * It uses binary search
     * @param firstNode
     * @param secondNode
     * @return
     */
    public int getPositionOfEdge(int firstNode, int secondNode) {
        if (firstNode > secondNode) {
            int aux = secondNode;
            secondNode = firstNode;
            firstNode = aux;
        }

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
            } else if (edge.getFirstNode() > firstNode) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Method that returns the n'th edge from the graph
     * @param n
     * @return
     */
    public Edge getNthEdge(int n) {
        return edges.get(n);
    }

    /**
     * Method that removes the given edge as a parameter
     * @param edge
     */
    public void removeEdge(Edge edge) {
        int index = -1;
        for (int i = 0; i < edges.size(); i++) {
            if (edge.equals(edges.get(i))) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        edges.remove(index);
    }

    /**
     * Method that prints the edges from the graph
     */
    public void printEdges() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.print(edges.get(i));
            if (i + 1 < edges.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

