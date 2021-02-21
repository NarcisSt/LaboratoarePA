package Compulsory;

/**
 * @author Barat Narcis Stefan
 * In this class i made all the operations asked for the randomized integer n.
 */
public class ProgrammingLanguage {

    String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

    int n = (int) (Math.random() * 1_000_000);

    /**
     * Calculations over n.
     */
    public void calculateResult() {
        System.out.println(n);
        n *= 3;
        System.out.println(n);
        int trans = Integer.parseInt("10101", 2);
        System.out.println(trans);
        n += trans;
        System.out.println(n);
        int trans1 = Integer.parseInt("FF", 16);
        System.out.println(trans1);
        n += trans1;
        System.out.println(n);
        n *= 6;
        System.out.println(n);
    }

    /**
     * Method for the control digit of a number which is > 9
     */
    public void controlDigit() {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        System.out.println(n);
    }

    /**
     * Method which prints the requested message
     */
    public void showMessage() {
        System.out.println("Willy-nilly, this semester i will learn " + languages[n]);
    }
}
