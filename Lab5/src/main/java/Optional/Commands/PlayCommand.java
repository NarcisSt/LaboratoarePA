package Optional.Commands;

import Optional.BaseItem;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class PlayCommand implements Command {
    private BaseItem baseItem;
    private List<BaseItem> items;

    @Override
    public void execute() {
        if (items.contains(baseItem) && baseItem != null) {
            try {
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                desktop.open(new File(baseItem.getPath()));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }
    }
}

