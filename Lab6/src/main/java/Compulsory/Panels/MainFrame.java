package Compulsory.Panels;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = screenSize.width - 350;
    public static final int height = screenSize.height - 350;

    ConfigurationPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame() {
        super("Paint varianta 2050");
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(850, 500));

        //Set the object size
        this.setSize(width, height);
        this.setResizable(false);

        //Calculate and Set the new frame location
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        //create the components
        configPanel = new ConfigurationPanel(this);
        drawingPanel = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        add(configPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }
}
