package OptionalAndBonus.Game;

import javafx.util.Pair;

import java.util.List;

/**
 * The abstract class Game is the prototype of the game
 */
public abstract class Game {

    /**
     * Method that adds a player to the game
     * @param type
     * @param name
     */
    public abstract void addPlayer (String type, String name);

    /**
     * Method that checks if the game is still running
     * @return
     */
    public abstract boolean isRunning();

    /**
     * Method that starts the game
     */
    public abstract void start();

    /**
     * Method that will interrupt the game if the duration of the game exceeded the specified duration
     * @param message
     */
    public abstract void interruptGame(String message);

    /**
     * Method that will set a player as the winner. Of course, the plyer that deserves to win
     * @param player
     */
    public abstract void announceWinner(Player player);

    /**
     * Method that returns the winner
     * @return
     */
    protected abstract Player getWinner();

    /**
     * Method that will print some information about the winner
     */
    protected abstract void printWinnerDetails();

    /**
     * Method that returns the final ranking of the game
     * @return
     */
    protected  abstract List<Pair<Integer, Player>> getRanking();

    /**
     * Method that prints the winner of the game
     */
    public void printWinnerOrRanking() {
        Player winner = getWinner();

        if (winner == null) {
            List<Pair<Integer, Player>> ranking = getRanking();
            ranking.sort((o1, o2) -> -1 * Integer.compare(o1.getKey(), o2.getKey()));
            System.out.println("Ranking: ");
            for (int i = 0; i < ranking.size(); i++) {
                System.out.println((i + 1) + ". " + ranking.get(i).getValue().getName() + " - " + ranking.get(i).getKey());
            }
            announceWinner(ranking.get(0).getValue());
            System.out.println("Winner: " + ranking.get(0).getValue().getName());
        } else {
            System.out.println("Winner: " + winner.getName());
        }
        printWinnerDetails();
        System.out.println();
    }

}
