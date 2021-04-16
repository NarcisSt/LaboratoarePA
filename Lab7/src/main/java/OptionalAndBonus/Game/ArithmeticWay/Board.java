package OptionalAndBonus.Game.ArithmeticWay;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokens;

    public Board(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tokens.add(new Token(i));
        }
    }

    /**
     * Returns the number of the remaining tokens
     * @return
     */
    public int getTokensCount() {
        synchronized (this) {
            return tokens.size();
        }
    }

    /**
     * Returns the token from position n
     * @param n
     * @return
     */
    public Token getNthToken(int n) {
        synchronized (this) {
            return tokens.get(n);
        }
    }

    /**
     * Removes the given token from the board
     * @param token
     */
    public void removeToken(Token token) {
        synchronized (this) {
            int index = -1;
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(token)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return;
            }
            tokens.remove(index);
        }
    }

    /**
     * Mthod that uses the binary search to get the position of the token with the value given as parameter
     * @param value
     * @return
     */
    public int getIndexOfTokenValue(int value) {
        int left = 0;
        int right = tokens.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (tokens.get(mid).getValue() == value) {
                return mid;
            }
            if (tokens.get(mid).getValue() > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Displays the value of all the remaining tokens
     */
    public void printTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).getValue());
            if (i + 1 < tokens.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
