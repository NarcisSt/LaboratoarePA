package Compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * The board class that contains a number of tokens.
 */
public class Board {
    private static List<Token> tokenList;

    Board (){
        tokenList = new ArrayList<>(1);
    }

    Board (int n){
        tokenList = new ArrayList<>(n);
    }

    /**
     * Method that adds a token to the list of tokens.
     * @param token that will be added
     */
    public void addTokenToList(Token token) {
        if(! tokenList.contains(token)){
            tokenList.add(token);
        }
    }

    /**
     * Method that returns the first token from the board and then removes it.
     * @return the first token from the board
     */
    public static Token removeToken(){
        if(tokenList.size() < 1){
            return null;
        }
        Token token = tokenList.get(0);
        tokenList.remove(0);
        return token;
    }

    /**
     * Method that show on screen the generated board
     */
    public void showBoard(){
        System.out.print("The board is: ");
        for (int i = 0; i < tokenList.size(); i++){
            System.out.print(tokenList.get(i).getNumber() + " ");
        }
        System.out.println();
    }
}
