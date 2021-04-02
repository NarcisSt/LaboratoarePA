package Compulsory;

import sun.security.krb5.internal.Ticket;

import java.util.Random;

/**
 * The class Token where a token have a specific positive value.
 */
public class Token {
    private int number;
    Random random = new Random();

    public Token(){
        this.number = random.nextInt(999999) + 1;
    }

    /**
     *
     * @param m the maximum value of a token
     */
    public Token(int m){
        this.number = random.nextInt(m) + 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
