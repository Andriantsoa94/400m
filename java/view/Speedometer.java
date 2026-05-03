package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class Speedometer extends JComponent {
    private double vAct = 0;
    private double vmax = 260;

    public Speedometer() {
        setPreferredSize(new Dimension(250, 250));
    }

    public void setVitesse(double v) {
        this.vAct = v;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int padding = 20;
        int diamondSize = w - (padding * 2);

        // 1. Dessiner l'arc du cadran
        g2.setStroke(new BasicStroke(5f));
        g2.setColor(Color.WHITE);
        // On dessine un arc de 180 degrés (de 180 à 0)
        g2.draw(new Arc2D.Double(padding, padding, diamondSize, diamondSize * 1.5, 0, 180, Arc2D.OPEN));

        // 2. Calculer l'angle de l'aiguille
        // 180° = 0 km/h, 0° = Vmax km/h
        double proportion = vAct / vmax;
        double angle = 180 - (proportion * 180);

        // 3. Dessiner l'aiguille
        int centerX = w / 2;
        int centerY = h - 10;
        int r = diamondSize / 2;

        double rad = Math.toRadians(angle);
        int x2 = (int) (centerX + r * Math.cos(rad));
        int y2 = (int) (centerY - r * Math.sin(rad));

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3f));
        g2.drawLine(centerX, centerY, x2, y2);

        // Petit pivot au centre
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }
}
