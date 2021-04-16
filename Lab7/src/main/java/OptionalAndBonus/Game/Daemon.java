package OptionalAndBonus.Game;

/**
 * The Daemon class sleeps for a given number of seconds, and stops the game after
 */
public class Daemon implements Runnable{
    private Game game;
    private int duration;

    public Daemon(Game game, int duration) {
        this.game = game;
        this.duration = duration;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e){
            return;
        }
        game.interruptGame("The game ended because it crossed the set duration");
    }
}
