package OptionalAndBonus.Shell;

import OptionalAndBonus.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    private List<Command> commands = new ArrayList<>();

    public Command getCommand(String command) {
        if (Utils.stringIsPositiveNat(command)) {
            int index = Integer.parseInt(command) - 1;
            if (index >= 0 && index < commands.size()) {
                return commands.get(index);
            }
        } else {
            for (Command command1 : commands) {
                if (command1.getCommand().equals(command)) {
                    return command1;
                }
            }
        }
        return null;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append((i + 1 < 10 ? " " : "")).append(i + 1);
            stringBuilder.append(". ").append(commands.get(i).toString());
            if (i + 1 < commands.size()) {
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }
}
