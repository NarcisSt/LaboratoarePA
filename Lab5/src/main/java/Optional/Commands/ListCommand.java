package Optional.Commands;

import Optional.BaseItem;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Class ListCommand extends the Command interface and overrides the execute() method.
 */
@AllArgsConstructor
public class ListCommand implements Command{
    private List<BaseItem> items;

    /**
     * Method overridden from the Command interface, which implements the list command.
     */
    @Override
    public void execute() {
        for (BaseItem baseItem : items) {
            System.out.println(baseItem);
        }
    }
}
