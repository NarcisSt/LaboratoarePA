package OptionalAndBonus.Game.ArithmeticWay;

import OptionalAndBonus.Utils.Utils;

import java.util.Scanner;

/**
 * This class represents the manual player that will play the game in arithmetic way
 */
public class PlayerManual extends  PlayerArithmeticProgressionGame{

    public PlayerManual(ArithmeticProgressionGame game, String name) {
        super(game, name);
    }

    @Override
    protected void myTurnLogic() {
        int tokensCount = board.getTokensCount();
        if (tokensCount == 0) {
            return;
        }
        System.out.print(name + "'s turn. Manual player. Available tokens: ");
        board.printTokens();
        System.out.print("Your tokens: ");
        printTokens();

        Token token = board.getNthToken(readTokenPosition());

        tokens.add(token);
        board.removeToken(token);

        verifyScore();
    }

    /**
     * Method that reads the token that the player choose from standard input
     *
     * @return
     */
    private int readTokenPosition() {
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        while (true) {
            int token = CompulsoryOptionalBonus.Utils.readIntOption(scanner, "Choose a token: ");
            position = board.getIndexOfTokenValue(token);
            if (position == -1) {
                System.out.println("Wrong token!");
                continue;
            }
            break;
        }
        return position;
    }
}
