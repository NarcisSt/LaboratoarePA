package OptionalAndBonus.Game.ArithmeticWay;

public class ArithmeticProgression {
    private int elementsCount;
    private int start;
    private int ratio;

    public ArithmeticProgression(int elementsCount, int start, int ratio) {
        this.elementsCount = elementsCount;
        this.start = start;
        this.ratio = ratio;
    }

    public int getElementsCount() {
        return elementsCount;
    }

    public int getStart() {
        return start;
    }

    public int getRatio() {
        return ratio;
    }
}
