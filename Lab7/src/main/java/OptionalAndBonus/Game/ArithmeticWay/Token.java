package OptionalAndBonus.Game.ArithmeticWay;

/**
 * The Token class implements the Comparable interface and describes the tokens from the table.
 */
public class Token implements Comparable{
    private int value;

    public Token(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o == null || getClass() != o.getClass()) {
            return 1;
        }
        return Integer.compare(value, ((Token) o).value);
    }
}
