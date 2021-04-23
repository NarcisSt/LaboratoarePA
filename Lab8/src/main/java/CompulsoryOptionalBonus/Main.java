package CompulsoryOptionalBonus;

import CompulsoryOptionalBonus.Shell.Command;
import CompulsoryOptionalBonus.Shell.Shell;
import CompulsoryOptionalBonus.Utils.Utils;

import java.util.Scanner;

import static CompulsoryOptionalBonus.Utils.Utils.executeCommand;
import static CompulsoryOptionalBonus.Utils.Utils.getShell;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shell shell = getShell();
        System.out.println("Commands:");
        System.out.println(shell);

        boolean running = true;
        while (running) {
            String line = Utils.readLine(scanner, "shell>");
            String[] cmdArgs = line.split(" ", 2);
            Command cmd = shell.getCommand(cmdArgs[0]);

            if (cmd == null) {
                System.out.println("Invalid command!");
                continue;
            }

            running = executeCommand(shell, cmd);
        }
    }
}
