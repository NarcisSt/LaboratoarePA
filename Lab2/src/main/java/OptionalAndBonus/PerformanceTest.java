package OptionalAndBonus;

import java.text.NumberFormat;

/**
 * In this class, i'm analyzing the performance of the algorithm.
 */

public class PerformanceTest {
    private long startTime, endTime;

    /**
     * Initializing the start.
     */
    public void startPerformanceTest() {
        startTime = System.nanoTime();
    }

    /**
     * The end of the program.
     */
    public void endPerformanceTest() {
        endTime = System.nanoTime();
    }

    /**
     * This method calculates and displays the time of execution in nanoseconds.
     */
    public void displayPerformanceTime() {
        long totalTime = endTime - startTime;
        System.out.println("Performance of the program:");
        System.out.println("Time of execution: " + totalTime + " nanoseconds");
    }

    /**
     * This method calculates and displays the memory consumption.
     */
    public void displayMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("Free memory: " + format.format(freeMemory / 1024) + " mb\n");
        sb.append("Allocated memory: " + format.format(allocatedMemory / 1024) + " mb\n");
        sb.append("Max memory: " + format.format(maxMemory / 1024) + " mb\n");
        sb.append("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + " mb\n");

        System.out.println(sb.toString());
    }
}
