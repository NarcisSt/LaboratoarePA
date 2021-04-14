package OptionalAndBonus.Game.ArithmeticWay;

import OptionalAndBonus.Game.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerArithmeticProgressionGame extends Player {
    protected ArithmeticProgressionGame game;
    protected List<Token> tokens;
    protected Board board;

    public PlayerArithmeticProgressionGame(ArithmeticProgressionGame game, String name) {
        super(name);
        this.game = game;
        this.board = game.getBoard();
        this.tokens = new ArrayList<>();
    }

    public void printArithmeticProgression() {
        ArithmeticProgression arithmeticProgression = getBestArithmeticProgression();

        int bestScore = arithmeticProgression.getElementsCount();
        int bestRatio = arithmeticProgression.getRatio();
        int start = arithmeticProgression.getStart();

        for (int i = 1; i <= bestScore; i++) {
            System.out.print(start);
            start += bestRatio;
            if (i + 1 <= bestScore) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).getValue());
            if (i + 1 < tokens.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    protected void verifyScore() {
        int myScore = getScore();
        if (myScore == game.getK()) {
            game.announceWinner(this);
        }
    }

    @Override
    protected boolean checkIfTheGameIsRunning() {
        return game.isRunning();
    }

    @Override
    protected void myTurnLogic() {

    }


    @Override
    public int getScore() {
        return getBestArithmeticProgression().getElementsCount();
    }

    private ArithmeticProgression getBestArithmeticProgression() {
        int tokensCount = tokens.size();

        if (tokensCount == 0) {
            return new ArithmeticProgression(0, 0, 0);
        } else if (tokensCount == 1) {
            return new ArithmeticProgression(1, tokens.get(0).getValue(), 0);
        }

        Collections.sort(tokens);

        if (tokensCount == 2) {
            return new ArithmeticProgression(2, tokens.get(0).getValue(), tokens.get(1).getValue() - tokens.get(0).getValue());
        }

        int bestScore = 2, start = 0, bestRatio = 1;

        for (int i = 0; i < tokensCount - 1; i++) {
            for (int j = i + 1; j < tokensCount; j++) {
                int ratio = tokens.get(j).getValue() - tokens.get(i).getValue();
                int next = tokens.get(j).getValue() + ratio;
                int currentScore = 2;

                for (int k = j + 1; k < tokensCount; k++) {
                    if (tokens.get(k).getValue() == next) {
                        ++currentScore;
                        next += ratio;
                    }
                }
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                    start = tokens.get(i).getValue();
                    bestRatio = ratio;
                }
            }
        }
        return new ArithmeticProgression(bestScore, start, bestRatio);
    }
}
