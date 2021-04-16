package OptionalAndBonus.Game.ArithmeticWay;

import OptionalAndBonus.Utils.Utils;

/**
 * This class describes a random player that will choose the tokens random
 */
public class PlayerRandom extends PlayerArithmeticProgressionGame{

    public PlayerRandom(ArithmeticProgressionGame game, String name) {
        super(game, name);
    }

    @Override
    protected void myTurnLogic() {
        int tokensCount = board.getTokensCount();
        if (tokensCount == 0) {
            return;
        }
        System.out.println(name + "'s turn. Random player.");
        Token myToken = board.getNthToken(Utils.generateRandomInt(0, tokensCount - 1));
        board.removeToken(myToken);
        tokens.add(myToken);

        verifyScore();
    }
}
