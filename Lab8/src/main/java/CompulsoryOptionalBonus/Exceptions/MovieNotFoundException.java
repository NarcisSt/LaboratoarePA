package CompulsoryOptionalBonus.Exceptions;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String title) {
        super("There is no movie titled " + title + " in the database!");
    }
}
