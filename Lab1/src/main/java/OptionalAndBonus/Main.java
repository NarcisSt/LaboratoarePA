package OptionalAndBonus;

import java.io.IOException;

/**
 * @author Barat Narcis Stefan
 * Compile
 * //https://www.jitendrazaa.com/blog/java/compile-and-run-java-program-in-package-from-command-line/
 * <p>
 * javac -d "classes" Matrix.java
 * javac -d "classes" Node.java
 * javac -d "classes" -classpath "classes" Graph.java
 * javac -d "classes" -classpath "classes" Tree.java
 * javac -d "classes" -classpath "classes" Main.java
 * <p>
 * Execute
 * java -classpath "classes" Optional.Main 4
 * java -Xms4G -Xmx4G -classpath "classes" Optional.Main 30000
 */

public class Main {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        int n;
        try {
            n = Integer.parseInt(args[0]);
            if (n < 0) {
                System.out.println("Invalid argument");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid argument");
            return;
        }

        Graph graph = new Graph(n);
        if (n < 20000) {
            graph.showMatrix(n);
        }
        graph.isConnected(n);

        if (graph.numberComponent == 1) {
            Tree tree = new Tree(n);
            tree.matrix = graph.matrix;

            tree.generateNodes();
            tree.showNodes();
            tree.getPartialGraphMatrix();
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("The application execution time in nanoseconds is: " + totalTime);
    }
}
