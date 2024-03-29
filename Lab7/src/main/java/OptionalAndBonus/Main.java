package OptionalAndBonus;

import OptionalAndBonus.Shell.Command;
import OptionalAndBonus.Shell.Shell;
import OptionalAndBonus.Utils.Utils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Shell shell = CompulsoryOptionalBonus.Utils.getShell();
        System.out.println("Commands:");
        System.out.println(shell);

        boolean running = true;
        while (running) {
            String line = CompulsoryOptionalBonus.Utils.readLine(scanner, "shell>>");
            String[] cmdArgs = line.split(" ", 2);
            Command command = shell.getCommand(cmdArgs[0]);

            running = CompulsoryOptionalBonus.Utils.executeCommand(shell, command);
        }
    }
}
