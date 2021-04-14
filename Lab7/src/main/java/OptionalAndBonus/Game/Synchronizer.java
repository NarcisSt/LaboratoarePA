package OptionalAndBonus.Game;

import java.util.List;

public class Synchronizer implements Runnable {
    private Game game;
    private Object[] locks;
    private List<Player> players;

    public Synchronizer(Game game, List<Player> players) {
        this.game = game;
        this.players = players;
    }

    @Override
    public void run() {
        int currentPlayer = 0;

        locks = new Object[this.players.size()];
        for (int i = 0; i < this.locks.length; i++) {
            locks[i] = new Object();
            this.players.get(i).setLock(this.locks[i]);
            new Thread(this.players.get(i)).start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        while (game.isRunning()) {
            synchronized (locks[currentPlayer]) {
                locks[currentPlayer].notify();
                try {
                    locks[currentPlayer].wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentPlayer = (currentPlayer + 1) % players.size();
        }
        unlockAllPlayers();
    }

    private void unlockAllPlayers() {
        for (Object lock : this.locks) {
            synchronized (lock) {
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
