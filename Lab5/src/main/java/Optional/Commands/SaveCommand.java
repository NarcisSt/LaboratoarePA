package Optional.Commands;

import Optional.Errors.IncorrectPathException;
import Optional.BaseItem;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Class SaveCommand extends the Command interface and overrides the execute() method.
 */
@AllArgsConstructor
public class SaveCommand implements Command{
    private String path;
    private List<BaseItem> items;

    /**
     * Method overridden from the Command interface, which implements the save command.
     *
     * @throws IncorrectPathException if the path is incorrect
     */
    @Override
    public void execute() throws IncorrectPathException {
        try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (BaseItem baseItem : items) {
                o.writeObject(baseItem);
            }

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new IncorrectPathException("Incorrect path");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
