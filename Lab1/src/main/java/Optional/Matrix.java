package Optional;

/**
 * @author Barat Narcis Stefan
 * In this class Matrix, i am generating thg adjacency matrix of a random graph, and display it on the screen.
 */
public class Matrix {
    int n;
    int[][] matrix;

    /**
     * Constructor that initialize matrix randomly with 1 and 0.
     * @param nodes represent the number of nodes of the graph
     */
    public Matrix(int nodes) {
        n = nodes;
        matrix = new int[n][n];

        for (int i = 0; i < nodes; i++) {

            for (int j = i; j < nodes; j++) {

                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    int val = (int) (Math.random() * 2);
                    matrix[i][j] = matrix[j][i] = val;
                }
            }
        }

    }

    /**
     * Method that displays the randomly generated matrix.
     * @param nodes represent the number of nodes of the graph
     */
    public void showMatrix(int nodes) {
        System.out.println("The adjacency matrix of the graph:");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
