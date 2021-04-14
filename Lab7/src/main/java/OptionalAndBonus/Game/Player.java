package OptionalAndBonus.Game;

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

    private void waitForMyTurn() {
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void endMyTurn() {
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    protected abstract boolean checkIfTheGameIsRunning();

    protected abstract void myTurnLogic();

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

    public abstract int getScore();
}
