package OptionalAndBonus.Utils;

import OptionalAndBonus.Game.ArithmeticWay.ArithmeticProgressionGame;
import OptionalAndBonus.Game.Game;
import OptionalAndBonus.Shell.Command;
import OptionalAndBonus.Shell.CommandEnum;
import OptionalAndBonus.Shell.Shell;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static Random random = new Random();

    public static int generateRandomInt(int min, int max) {
        if (min >= max) {
            return max;
        }
        return min + random.nextInt(max - min);
    }

    public static boolean stringIsPositiveNat(String str) {
        return (Integer.parseInt(str) >= 0);
    }

    public static String readLine(Scanner scanner, String message) {
        String line;
        while (true) {
            if (message != null) {
                System.out.println(message);
            }
            line = scanner.nextLine();
            if (line. length() == 0){
                continue;
            }
            break;
        }
        return line.trim();
    }

    public static String readStringOption (Scanner scanner, String message, String[] options) {
        while (true) {
            System.out.println("Options: {");
            for (int i = 0; i < options.length; i++) {
                System.out.println(" " + options[i]);
                if (i + 1 < options.length) {
                    System.out.println(",");
                }
            }
            System.out.println(" }");
            System.out.println(message);
            String line = scanner.nextLine();
            for (String option : options) {
                if (option.equals(line)) {
                    return option;
                }
            }
            System.out.println("You must put a valid option!");
        }
    }

    public static int readIntOption(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String line = scanner.nextLine();
            try {
                if(! stringIsPositiveNat(line)) {
                    System.out.println("You must put a positive number!");
                } else {
                    return Integer.parseInt(line);
                }
            } catch (Exception e) {
                System.out.println("You must put a positive number!");
            }
        }
    }

    public static boolean executeCommand(Shell shell, Command cmd) {
        switch (cmd.getCommandEnum()) {
            case PLAY:
                Game game = initializeGame();
                if (game == null) {
                    System.out.println("Error! Please try again!");
                } else {
                    game.start();
                    game.printWinnerOrRanking();
                }
                break;
            case LIST:
                System.out.println(shell);
                break;
            case QUIT:
                return false;
            default:
                System.out.println("Invalid command!");
        }
        return true;
    }

    private static Game initializeGame() {
        Game game = null;
        Scanner scanner = new Scanner(System.in);

        String gameName = Utils.readStringOption(scanner, "Enter the game you want to play: ", new String[]{"arith"});

        int n = 0;
        if (gameName.equals("arith")) {
            n = Utils.readIntOption(scanner, "Enter the number of tokens on the table: ");
        }
        int duration = Utils.readIntOption(scanner, "Enter the duration of the game (in seconds): ");
        int k = 0;
        if (gameName.equals("arith")) {
            k = Utils.readIntOption(scanner, "Enter the target size of the arithmetic progression: ");
        }

        if (gameName.equals("arith")) {
            game = new ArithmeticProgressionGame(n, duration, k);
        }

        initializePlayers(game, scanner, gameName);

        return game;
    }

    private static void initializePlayers(Game game, Scanner scanner, String gameName) {
        int numberOfPlayers = 0;
        while (true) {
            numberOfPlayers = Utils.readIntOption(scanner, "Enter the number of players: ");
            if (numberOfPlayers > 0) {
                break;
            }
            System.out.println("The number of player cannot be zero!");
        }
        for (int i = 0; i < numberOfPlayers; ++i) {
            String playerType = null;
            if (gameName.equals("arith")) {
                playerType = Utils.readStringOption(scanner, "Enter the player type: ", new String[]{"smart", "random", "manual"});
            } else if (gameName.equals("clique")) {
                playerType = Utils.readStringOption(scanner, "Enter the player type: ", new String[]{"random", "manual"});
            }
            System.out.print("Enter player name: ");
            String playerName = scanner.nextLine();

            game.addPlayer(playerType, playerName);
        }
    }

    public static Shell getShell() {
        Shell shell = new Shell();

        shell.addCommand(new Command(CommandEnum.PLAY, "play"));
        shell.addCommand(new Command(CommandEnum.LIST, "list"));
        shell.addCommand(new Command(CommandEnum.QUIT, "quit"));

        return shell;
    }
}
