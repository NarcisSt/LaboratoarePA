package Optional.Commands;

import Optional.BaseItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Class AddCommand extends the Command interface and overrides the execute() method.
 */
@AllArgsConstructor
@Getter
public class AddCommand implements Command{
    private BaseItem item;
    private List<BaseItem> items;

    /**
     * Method overridden from the Command interface, which implements the add command.
     */
    @Override
    public void execute() {
        items.add(item);
    }
}
