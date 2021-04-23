package CompulsoryOptionalBonus.Utils;

import CompulsoryOptionalBonus.Commands.ConcurrentTasks;
import CompulsoryOptionalBonus.Database.Connection.ConnectionSourceConnPool;
import CompulsoryOptionalBonus.Database.Connection.ConnectionSourceSingleton;
import CompulsoryOptionalBonus.Database.Connection.Database;
import CompulsoryOptionalBonus.Database.DAO.GenreController;
import CompulsoryOptionalBonus.Database.DAO.MovieController;
import CompulsoryOptionalBonus.Model.Genre;
import CompulsoryOptionalBonus.Model.Movie;
import CompulsoryOptionalBonus.Shell.Command;
import CompulsoryOptionalBonus.Shell.CommandEnum;
import CompulsoryOptionalBonus.Shell.Shell;

import java.util.Scanner;

public class Utils {
    /**
     * Method that checks if a string given as parameter is a positive integer
     * @param str
     * @return
     */
    public static boolean stringIsPositiveNat(String str) {
        if (str.length() > 9 || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that is used by the shells and reads a line from the standard input
     * @param scanner
     * @param message
     * @return the line
     */
    public static String readLine(Scanner scanner, String message) {
        String line;
        while (true) {
            if (message != null) {
                System.out.print(message);
            }
            line = scanner.nextLine();
            if (line.length() == 0) {
                continue;
            }
            break;
        }
        return line.trim();
    }

    /**
     * Method that prints a message when a movie was inserted in the database
     * @param movie
     */
    public static void printDatabaseMovieInsertEvent(Movie movie) {
        System.out.println("movie " + movie + " inserted in the database!");
    }

    /**
     * Method that prints a message when a genre was inserted in the database
     * @param genre
     */
    public static void printDatabaseGenreInsertEvent(Genre genre) {
        System.out.println("genre " + genre + " inserted in the database!");
    }

    /**
     * Method that will execute the wanted command
     * @param shell
     * @param cmd
     * @return true if the command was successfully executed, false otherwise
     */
    public static boolean executeCommand(Shell shell, Command cmd) {
        switch (cmd.getCommandEnum()) {
            case COMPULSORY: {
                commandCompulsory();
                break;
            }
            case CONCURRENT_SINGLETON: {
                commandConcurrentTasksSingleton();
                break;
            }
            case CONCURRENT_CONN_POOL: {
                commandConcurrentTasksConnPool();
                break;
            }
            case LIST: {
                System.out.println(shell);
                break;
            }
            case QUIT: {
                return false;
            }
        }
        return true;
    }

    /**
     * Method for the compulsory command, for the compulsory tasks
     */
    private static void commandCompulsory() {
        Database database = Database.getInstance();

        MovieController movieController = new MovieController(database);
        GenreController genreController = new GenreController(database);

        try {
            Movie movie1 = MovieController.create("Titanic", 1997, 140, 9);
            Utils.printDatabaseMovieInsertEvent(movie1);

            Genre genre1 = genreController.create("Drama");
            Utils.printDatabaseGenreInsertEvent(genre1);
            Genre genre2 = genreController.create("Romantic");
            Utils.printDatabaseGenreInsertEvent(genre2);

            Movie movie2 = MovieController.create("The Godfather", 1991, 180, 10);
            Utils.printDatabaseMovieInsertEvent(movie2);

            Genre genre3 = genreController.create("Actiune");
            Utils.printDatabaseGenreInsertEvent(genre3);
            Genre genre4 = genreController.create("Drama");
            Utils.printDatabaseGenreInsertEvent(genre4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void commandConcurrentTasksSingleton() {
        ConcurrentTasks concurrentTasks = new ConcurrentTasks(new ConnectionSourceSingleton());
        concurrentTasks.generateThreads(500);
    }

    private static void commandConcurrentTasksConnPool() {
        ConcurrentTasks concurrentTasks = new ConcurrentTasks(new ConnectionSourceConnPool());
        concurrentTasks.generateThreads(500);
    }

    /**
     * Method that initializes the shell.
     * @return the shell
     */
    public static Shell getShell() {
        Shell shell = new Shell();

        shell.addCommand(new Command(CommandEnum.COMPULSORY, "compulsory"));
        shell.addCommand(new Command(CommandEnum.CONCURRENT_SINGLETON, "c_singleton"));
        shell.addCommand(new Command(CommandEnum.CONCURRENT_CONN_POOL, "c_conn_pool"));
        shell.addCommand(new Command(CommandEnum.LIST, "list"));
        shell.addCommand(new Command(CommandEnum.QUIT, "quit"));

        return shell;
    }

}
