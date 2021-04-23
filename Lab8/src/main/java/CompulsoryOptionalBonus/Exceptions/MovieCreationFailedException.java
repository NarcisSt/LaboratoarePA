package CompulsoryOptionalBonus.Exceptions;

/**
 * This class is for the situation when the movie could not be inserted
 */
public class MovieCreationFailedException extends Exception{
    public MovieCreationFailedException(String title, int releaseYear) {
        super("Failed to insert movie " + title + " (released in " + releaseYear + ") in the database!");
    }
}
