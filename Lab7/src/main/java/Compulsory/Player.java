package EntityClasses;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Player implements the Runnable interface and describes a player.
 */
public class Player implements Runnable {
    private String name;
    private static volatile ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    private List<Token> tokenList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Method that prints the score of a player
     */
    public void printPlayer() {
        System.out.print(name + " has: ");
        for (Token token : tokenList) {
            System.out.print(token.getNumber() + " ");
        }
        System.out.println();
    }

    @Override
    public void run() {
        Token token;

        do {
            lock.lock();
            token = Board.removeToken();
            if (token != null) {
                tokenList.add(token);
            } else {
                lock.unlock();
                break;
            }

            count++;
            int secondCounter = count;
            lock.unlock();
            while (secondCounter == count) ;
        } while (token != null);
        count++;
        lock.lock();
        printPlayer();
        lock.unlock();
    }
}
