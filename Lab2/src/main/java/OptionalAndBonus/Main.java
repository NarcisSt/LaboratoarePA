package OptionalAndBonus;

/**
 *  The main class of the program. Here, for the "problem" object, we can call the method readData, and typing the vales in the method,
 *  or call the method generateRandomData and generate large random instances.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();

        test.startPerformanceTest();

        Problem problem = new Problem();
        problem.readData();
    //    problem.generateRandomData(50, 50, 1000, 10);
        Solution solution = new Solution(problem);
        System.out.println("The minimized cost is: " + solution.computeCost());

        test.endPerformanceTest();
        test.displayPerformanceTime();
        test.displayMemoryUsage();
    }
}
