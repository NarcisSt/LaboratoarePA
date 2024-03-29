package CompulsoryOptionalBonus.Commands;

import CompulsoryOptionalBonus.Database.Connection.ConnectionSource;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrentTasks {
    private ConnectionSource connectionSource;

    public ConcurrentTasks(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    /**
     * Method that generates 'threadsCount' threads, each of them requiring a database connection
     */
    public void generateThreads(int threadsCount) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        for (int i = 1; i <= threadsCount; ++i) {
            CommandConcurrentTask task = new CommandConcurrentTask("Task " + i, connectionSource);

            executor.execute(task);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.out.println(e.getMessage());
        }
    }
}
