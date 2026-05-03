package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame () {
        setTitle("400 meter Drag race");
        setSize(800 , 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        setVisible(true);

        JButton start = new JButton("Accelerer");
        JPanel track = new JPanel();
        JPanel dash = new JPanel();

        this.add(dash , BorderLayout.NORTH);
        this.add(track ,BorderLayout.CENTER);
        this.add(start , BorderLayout.SOUTH);

        setVisible(true);
    }
}
