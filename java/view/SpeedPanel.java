package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SpeedPanel extends JPanel{
    private Speedometer speed; 

    public SpeedPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Speed display"));
        speed = new Speedometer();
        add(speed);
    }
}
