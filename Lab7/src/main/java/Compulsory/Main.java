package EntityClasses;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10);

        for (int i = 0; i < 10; i++) {
            board.addTokenToList(new Token(100));
        }

        board.showBoard();

        Thread thread1 = new Thread(new Player("Narcis"));
        Thread thread2 = new Thread(new Player("Stefan"));

        thread1.start();
        thread2.start();
    }
}
