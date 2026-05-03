package view;

import model.Voiture;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private DashPanel dash;

    public MainFrame (List<Voiture> vtr) {

        setTitle("400 meter Drag race");
        setSize(800 , 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DashPanel dash = new DashPanel(vtr);
        setLayout(new BorderLayout());

        JButton start = new JButton("Accelerer");
        JPanel track = new JPanel();

        this.add(dash , BorderLayout.NORTH);
        this.add(track ,BorderLayout.CENTER);
        this.add(start , BorderLayout.SOUTH);

        setVisible(true);
    }
}
