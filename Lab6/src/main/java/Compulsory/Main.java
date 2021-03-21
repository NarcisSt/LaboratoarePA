package Compulsory;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().getPanelMain());
        frame.pack();
        frame.setVisible(true);
    }

}
