package Main;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame JFrame ;
    public Window(Panel panel){
        JFrame = new JFrame();

        JFrame.setResizable(false);
        JFrame.setLocationRelativeTo(null);
        JFrame.setDefaultCloseOperation(3);
        JFrame.add(panel);
        Button up = new Button();
        JFrame.pack();
        JFrame.setVisible(true);

    }
}
