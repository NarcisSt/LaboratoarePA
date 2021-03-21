package Optional.Errors;

public class IncorrectCommandException extends Exception{
    public IncorrectCommandException() {
        System.out.println("Invalid command");
    }
}
