package CompulsoryOptionalBonus.Utils;

import CompulsoryOptionalBonus.Model.Genre;
import CompulsoryOptionalBonus.Model.Movie;

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

    public static void printDatabaseMovieInsertEvent(Movie movie) {
        System.out.println("movie " + movie + " inserted in the database!");
    }

    public static void printDatabaseGenreInsertEvent(Genre genre) {
        System.out.println("genre " + genre + " inserted in the database!");
    }

}
