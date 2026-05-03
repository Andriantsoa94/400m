package view;

import model.Voiture;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DashPanel extends JPanel{
    private List<JRadioButton> btnVtr = new ArrayList<>();
    private ButtonGroup group = new ButtonGroup();

    public DashPanel (List<Voiture> voitures) {
        setBorder(BorderFactory.createTitledBorder("Select a Car"));
        setLayout(new GridLayout(0, 1, 10, 10));

        for (Voiture vtr : voitures) {
            JRadioButton rb = new JRadioButton(vtr.getNom() + " VMax "+ vtr.getVitesseMax() + " Acceleration " +vtr.getAcceleration());
            group.add(rb);
            this.add(rb);
            btnVtr.add(rb);
        }

        if (!btnVtr.isEmpty()) {
            btnVtr.get(0).setSelected(true);
        }
    }

    public int getIndexVtr() {
        for (int i = 0 ; i < btnVtr.size(); i++) {
            if (btnVtr.get(i).isSelected()) {
                return i;
            }
        }
        return 0;
    }
}
