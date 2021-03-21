package Optional.Commands;

import Optional.BaseItem;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListCommand implements Command{
    private List<BaseItem> items;

    @Override
    public void execute() {
        for (BaseItem baseItem : items) {
            System.out.println(baseItem);
        }
    }
}
