package CompulsoryOptionalBonus.Exceptions;

public class MovieCreationFailedException extends Exception{
    public MovieCreationFailedException(String title, int releaseYear) {
        super("Failed to insert movie " + title + " (released in " + releaseYear + ") in the database!");
    }
}
