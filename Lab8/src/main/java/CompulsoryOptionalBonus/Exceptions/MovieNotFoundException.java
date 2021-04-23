package CompulsoryOptionalBonus.Exceptions;

/**
 * This class is for the situation when a movie was not found in the database
 */
public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String title) {
        super("There is no movie titled " + title + " in the database!");
    }
}
