package OptionalAndBonus.Game;

/**
 * The abstract class Player implements the Runnable interface and is the prototype for the players.
 */
public abstract class Player implements Runnable {
    private Object lock;
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public String getName() {
        return name;
    }

    /**
     * Method that makes the player to wait for his turn.
     * It will remain blocked in the wait() call until the synchronizer will notify that his turn has come
     */
    private void waitForMyTurn() {
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Method that notifies the synchronizer that a player's turn has ended
     */
    private void endMyTurn() {
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    /**
     * Method that chack if the game is still running
     * @return
     */
    protected abstract boolean checkIfTheGameIsRunning();

    /**
     * This method contains the logic of a turn of a player
     */
    protected abstract void myTurnLogic();

    /**
     * Method that implements the order of the operations done by a player
     */
    @Override
    public void run() {
        while (true) {
            waitForMyTurn();
            if (! checkIfTheGameIsRunning()) {
                break;
            }
            myTurnLogic();
            endMyTurn();
        }
        endMyTurn();
    }

    /**
     * Method that returns the current score of the player
     * @return
     */
    public abstract int getScore();
}
