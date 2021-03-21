package Optional.Commands;

import Optional.Errors.IncorrectPathException;

public interface Command {
    void execute() throws IncorrectPathException;
}
