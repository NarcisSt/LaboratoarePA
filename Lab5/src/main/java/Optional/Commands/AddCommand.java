package Optional.Commands;

import Optional.BaseItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AddCommand implements Command{
    private BaseItem item;
    private List<BaseItem> items;

    @Override
    public void execute() {
        items.add(item);
    }
}
