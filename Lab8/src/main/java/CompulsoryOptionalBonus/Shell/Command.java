package CompulsoryOptionalBonus.Shell;

/**
 * The Command class represents the commands which can be: COMPULSORY, REPORT, CONCURRENT_SINGLETON, CONCURRENT_CONN_POOL, LIST, QUIT
 */
public class Command {
    private String command;
    private CommandEnum commandEnum;

    public Command(CommandEnum commandEnum, String command) {
        this.command = command;
        this.commandEnum = commandEnum;
    }

    public String getCommand() {
        return command;
    }

    public CommandEnum getCommandEnum() {
        return commandEnum;
    }

    @Override
    public String toString() {
        return command;
    }
}
