package Optional;

import Optional.Commands.*;
import Optional.Errors.IncorrectCommandException;
import Optional.Errors.IncorrectPathException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Catalog {
    private List<BaseItem> items = new ArrayList<>();

    public void execute(String action, String name, String path) throws IncorrectCommandException, IncorrectPathException {
        switch (action) {
            case "add": {
                BaseItem baseItem = new BaseItem(name, path);
                AddCommand command = new AddCommand(baseItem, items);
                command.execute();
                items = command.getItems();
                break;
            }
            case "list": {
                ListCommand command = new ListCommand(items);
                command.execute();
                break;
            }
            case "play": {
                BaseItem baseItem = findByName(name);
                PlayCommand command = new PlayCommand(baseItem, items);
                command.execute();
                break;
            }
            case "save": {
                SaveCommand command = new SaveCommand(path, items);
                command.execute();
                break;
            }
            case "load": {
                LoadCommand command = new LoadCommand(path, items);
                command.execute();
                break;
            }
            case "report": {
                ReportCommand command = new ReportCommand(items);
                command.execute();
                break;
            }
            default: {
                throw new IncorrectCommandException();
            }
        }
        System.out.println("Command " + action + " was run successfully");
    }

    private BaseItem findByName(String name) {
        return items.stream()
                .filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }

    public void start() throws IOException, IncorrectCommandException, IncorrectPathException {
        System.out.println("Catalog is started!");

        boolean open = true;

        while (open) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Action: ");
            String action = reader.readLine();
            action.toLowerCase(Locale.ROOT);

            switch (action) {
                case "add": {
                    System.out.print("Name: ");
                    String name = reader.readLine();
                    System.out.print("Path: ");
                    String path = reader.readLine();
                    this.execute(action, name, path);
                    break;
                }
                case "play": {
                    System.out.print("Name: ");
                    String name = reader.readLine();
                    this.execute(action, name, null);
                    break;
                }
                case "save":
                case "load": {
                    System.out.print("Path: ");
                    String path = reader.readLine();
                    this.execute(action, null, path);
                    break;
                }
                case "exit": {
                    open = false;
                    System.out.println("Catalog is closed!");
                    break;
                }
                default: {
                    this.execute(action, null, null);
                    break;
                }
            }

        }
    }
}
