package OptionalAndBonus.Game;

import javafx.util.Pair;

import java.util.List;

public abstract class Game {

    public abstract void addPlayer (String type, String name);

    public abstract boolean isRunning();

    public abstract void start();

    public abstract void interruptGame(String message);

    public abstract void announceWinner(Player player);

    protected abstract Player getWinner();

    protected abstract void printWinnerDetails();

    protected  abstract List<Pair<Integer, Player>> getRanking();

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
