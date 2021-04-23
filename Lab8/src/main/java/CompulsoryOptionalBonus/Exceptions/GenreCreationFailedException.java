package CompulsoryOptionalBonus.Exceptions;

/**
 * This class is for the situation when the genre could not be inserted
 */
public class GenreCreationFailedException extends Exception{
    public GenreCreationFailedException(String name) {
        super("Failed to insert genre " + name + " in the database!");
    }
}
