package Optional.Commands;

import Optional.BaseItem;
import Optional.Errors.IncorrectPathException;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.List;

/**
 * Class LoadCommand extends the Command interface and overrides the execute() method.
 */
@AllArgsConstructor
public class LoadCommand implements Command{
    private String path;
    private List<BaseItem> items;

    /**
     * Method overridden from the Command interface, which implements the load command.
     *
     * @throws IncorrectPathException if the path is incorrect
     */
    @Override
    public void execute() throws IncorrectPathException {
        try {

            FileInputStream fis = new FileInputStream(path);
            try (ObjectInputStream input = new ObjectInputStream(fis)) {
                while (input.readObject() != null) {
                    BaseItem obj = (BaseItem) input.readObject();
                    items.add(obj);
                    System.out.println(obj.toString());
                }
            } catch (FileNotFoundException e) {
                throw new IncorrectPathException("Incorrect path");
            } catch (EOFException e) {
                return;
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException | IncorrectPathException e) {
            throw new IncorrectPathException("Incorrect path");
        }
    }
}
