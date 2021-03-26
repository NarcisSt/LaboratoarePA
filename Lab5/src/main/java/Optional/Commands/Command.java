package Optional.Commands;

import Optional.Errors.IncorrectPathException;

/**
 * The Command interface, it has a method that is overridden in other classes.
 */
public interface Command {
    void execute() throws IncorrectPathException;
}
