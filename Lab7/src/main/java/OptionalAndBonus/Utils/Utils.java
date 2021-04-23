package OptionalAndBonus.Utils;

import OptionalAndBonus.Game.ArithmeticWay.ArithmeticProgressionGame;
import OptionalAndBonus.Game.CliqueWay.CliqueGame;
import OptionalAndBonus.Game.Game;
import OptionalAndBonus.Shell.Command;
import OptionalAndBonus.Shell.CommandEnum;
import OptionalAndBonus.Shell.Shell;

import java.util.Random;
import java.util.Scanner;

/**
 * Class CompulsoryOptionalBonus.Utils contains methods that will help with the shell commands and the initialization of the game.
 */
public class Utils {
    private static Random random = new Random();

    /**
     * Method that generates a random integer between min and max
     *
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomInt(int min, int max) {
        if (min >= max) {
            return max;
        }
        return min + random.nextInt(max - min);
    }

    /**
     * Method that checks if a string given as parameter is a positive integer
     * @param str
     * @return
     */
    public static boolean stringIsPositiveNat(String str) {
        if (str.length() > 9 || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that is used by the shells and reads a line from the standard input
     * @param scanner
     * @param message
     * @return the line
     */
    public static String readLine(Scanner scanner, String message) {
        String line;
        while (true) {
            if (message != null) {
                System.out.print(message);
            }
            line = scanner.nextLine();
            if (line.length() == 0) {
                continue;
            }
            break;
        }
        return line.trim();
    }


    /**
     * Method that reads an option from the standard input, and prints a message
     * @param scanner
     * @param message
     * @param options
     * @return the option
     */
    public static String readStringOption(Scanner scanner, String message, String[] options) {
        while (true) {
            System.out.print("Options: {");
            for (int i = 0; i < options.length; i++) {
                System.out.print(" " + options[i]);
                if (i + 1 < options.length) {
                    System.out.print(",");
                }
            }
            System.out.println(" }");
            System.out.print(message);
            String line = scanner.nextLine();
            for (String option : options) {
                if (option.equals(line)) {
                    return option;
                }
            }
            System.out.println("You must put a valid option!");
        }
    }

    /**
     * Method that reads a positive integer from the stdin, and prints a message
     * @param scanner
     * @param message
     * @return the number
     */
    public static int readIntOption(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                int nr =Integer.parseInt(line);
                if (nr < 0) {
                    System.out.println("You must put a positive number!");
                } else {
                    return nr;
                }
            } catch (Exception e) {
                System.out.println("You must put a positive number!");
            }
        }
    }

    /**
     * Method that will execute the wanted command
     * @param shell
     * @param cmd
     * @return true if the command was successfully executed, false otherwise
     */
    public static boolean executeCommand(Shell shell, Command cmd) {
        switch (cmd.getCommandEnum()) {
            case PLAY: {
                Game game = initializeGame();
                if (game == null) {
                    System.out.println("Error! Please try again!");
                } else {
                    game.start();
                    game.printWinnerOrRanking();
                }
                break;
            }
            case LIST: {
                System.out.println(shell);
                break;
            }
            case QUIT: {
                return false;
            }
            default: {
                System.out.println("Invalid command!");
            }
        }
        return true;
    }

    /**
     * Method that initialize the game by reading the desired parameters
     * @return the game
     */
    private static Game initializeGame() {
        Game game = null;
        Scanner scanner = new Scanner(System.in);

        String gameName = Utils.readStringOption(scanner, "Enter the game you want to play: ", new String[]{"arithmetic", "clique"});

        int n = 0;
        if (gameName.equals("arithmetic")) {
            n = Utils.readIntOption(scanner, "Enter the number of tokens on the table: ");
        } else if (gameName.equals("clique")) {
            n = Utils.readIntOption(scanner, "Enter the number of vertices: ");
        }
        int duration = Utils.readIntOption(scanner, "Enter the duration of the game (in seconds): ");
        int k = 0;

        if (gameName.equals("arithmetic")) {
            k = Utils.readIntOption(scanner, "Enter the target size of the arithmetic progression: ");
        } else if (gameName.equals("clique")) {
            k = Utils.readIntOption(scanner, "Enter the target size of the clique: ");
        }

        if (gameName.equals("arithmetic")) {
            game = new ArithmeticProgressionGame(n, duration, k);
        } else if (gameName.equals("clique")) {
            game = new CliqueGame(n, duration, k);
        }

        initializePlayers(game, scanner, gameName);

        return game;
    }

    /**
     * Method that adds the players to the game, the number of players and their type
     * @param game
     * @param scanner
     * @param gameName
     */
    private static void initializePlayers(Game game, Scanner scanner, String gameName) {
        int numberOfPlayers = 0;
        while (true) {
            numberOfPlayers = Utils.readIntOption(scanner, "Enter the number of players: ");
            if (numberOfPlayers > 0) {
                break;
            }
            System.out.println("The number of players cannot be zero!");
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerType = null;
            if (gameName.equals("arithmetic")) {
                playerType = Utils.readStringOption(scanner, "Enter the player type: ", new String[]{"smart", "random", "manual"});
            } else if (gameName.equals("clique")) {
                playerType = Utils.readStringOption(scanner, "Enter the player type: ", new String[]{"random", "manual"});
            }
            System.out.print("Enter player name: ");
            String playerName = scanner.nextLine();

            game.addPlayer(playerType, playerName);
        }
    }

    /**
     * Method that initializes the shell.
     * @return the shell
     */
    public static Shell getShell() {
        Shell shell = new Shell();

        shell.addCommand(new Command(CommandEnum.PLAY, "play"));
        shell.addCommand(new Command(CommandEnum.LIST, "list"));
        shell.addCommand(new Command(CommandEnum.QUIT, "quit"));

        return shell;
    }
}
