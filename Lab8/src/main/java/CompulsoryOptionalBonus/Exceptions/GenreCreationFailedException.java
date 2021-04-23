package CompulsoryOptionalBonus.Exceptions;

public class GenreCreationFailedException extends Exception{
    public GenreCreationFailedException(String name) {
        super("Failed to insert genre " + name + " in the database!");
    }
}
