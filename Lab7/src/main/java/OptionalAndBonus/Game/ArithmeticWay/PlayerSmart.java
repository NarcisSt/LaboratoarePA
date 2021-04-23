package OptionalAndBonus.Game.ArithmeticWay;

import OptionalAndBonus.Utils.Utils;

import java.util.Collections;

/**
 * This class represents the smart player that will play the game in arithmetic way.
 * This player always tries to increase his largest arithmetic progression.
 */
public class PlayerSmart extends PlayerArithmeticProgressionGame {
    public PlayerSmart(ArithmeticProgressionGame game, String name) {
        super(game, name);
    }

    @Override
    protected void myTurnLogic() {
        int tokensCount = board.getTokensCount();
        if (tokensCount == 0) {
            return;
        }
        System.out.println(name + "'s turn. Smart player.");
        int tokenPosition = getBestTokenPosition();
        if (tokenPosition == -1) {
            tokenPosition = CompulsoryOptionalBonus.Utils.generateRandomInt(0, board.getTokensCount());
        }
        Token token = board.getNthToken(tokenPosition);
        tokens.add(token);
        board.removeToken(token);

        verifyScore();
    }

    /**
     * In this method, the smart player tries to extend its largest arithmetic progression
     * @return
     */
    private int getBestTokenPosition() {
        int maxPossibleScore = 0, tokenPosition = -1;

        Collections.sort(tokens);

        for (int i = 0; i < tokens.size() - 1; i++) {
            for (int j = i + 1; j < tokens.size(); j++) {
                int ratio = tokens.get(j).getValue() - tokens.get(i).getValue();
                int next = tokens.get(j).getValue() + ratio;
                int currentScore = 2;

                for (int k = j + 1; k < tokens.size(); k++) {
                    if (tokens.get(k).getValue() == next) {
                        ++currentScore;
                        next += ratio;
                    }
                }
                int nextPosition = board.getIndexOfTokenValue(next);
                if (nextPosition == -1) {
                    if (currentScore > maxPossibleScore) {
                        maxPossibleScore = currentScore;
                        tokenPosition = -1;
                    }
                } else {
                    ++currentScore;
                    if (currentScore > maxPossibleScore) {
                        maxPossibleScore = currentScore;
                        tokenPosition = nextPosition;
                    }
                }
            }
        }
        return tokenPosition;
    }
}
