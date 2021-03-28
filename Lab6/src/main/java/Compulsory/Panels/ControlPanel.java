package Compulsory.Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * The ControlPanel class is used for managing the image being created
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JFileChooser fileChooser;

    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(2, 2));

        //add where to save file chooser
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG images:   *.png", "png"));


        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        //add buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void save(ActionEvent e) {
        try {
            fileChooser.setDialogTitle("Specify where to save and the name:");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.drawingPanel.image, "PNG", fileChooser.getSelectedFile());
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            fileChooser.setDialogTitle("Specify the file you want to load:");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                frame.drawingPanel.image = ImageIO.read(fileChooser.getSelectedFile());
                frame.drawingPanel.repaint();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void reset(ActionEvent e) {
        frame.drawingPanel.createOffscreenImage();
    }

    private void exit(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
