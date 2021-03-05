package Optional;

/**
 * @author Barat Narcis Stefan
 * In this class i am using a bfs parse to find out if the graph is connected or not.
 * And also display his connected components, only for not so larger inputs.
 * If the input is larger, i only display the  running time of the application in nanoseconds.
 */
public class Graph extends Matrix {
    int visited[] = new int[n];
    int queue[] = new int[n];
    int numberComponent = 0;
    int first;
    int last;

    public Graph(int nodes) {
        super(nodes);
    }

    /**
     * This function print the connected components of the graph.
     * @param nodes represent the number of nodes of the graph
     */
    public void isConnected(int nodes) {
        for (int k = 0; k < nodes; k++) {
            if (visited[k] == 0) {
                numberComponent++;
                bfs(k, nodes);

                if (nodes < 20000) {
                    System.out.println("The component number " + numberComponent + ":");
                    for (int i = 0; i <= last; i++) {
                        System.out.print(queue[i] + " ");
                    }
                    System.out.println();
                }
            }
        }
        if (nodes < 20000) {
            if (numberComponent == 1) {
                System.out.println("The graph is connected");
            } else {
                System.out.println("The graph is not connected");
            }
        }
    }

    /**
     * This function implement a bfs algorithm.
     * @param top the star node
     * @param nodes represent the number of nodes of the graph
     */
    public void bfs(int top, int nodes) {
        int queueElement;
        first = last = 0;
        queue[first] = top;
        visited[top] = numberComponent;
        while (first <= last) {
            queueElement = queue[first];
            for (int i = 0; i < nodes; i++) {
                if (matrix[queueElement][i] != 0 && visited[i] == 0) {
                    visited[i] = numberComponent;
                    last++;
                    queue[last] = i;
                }
            }
            first++;
        }
    }
}
