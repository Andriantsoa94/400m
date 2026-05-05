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
        int padding = 5;
        int diamondSize = w - (padding * 2);

        g2.setStroke(new BasicStroke(5f));
        g2.setColor(Color.WHITE);
        g2.draw(new Arc2D.Double(padding, padding, diamondSize, diamondSize, 0, 180, Arc2D.OPEN));

        double proportion = vAct / vmax;
        double angle = 180 - (proportion * 180);

        int centerX = w / 2;
        int centerY = padding + (diamondSize / 2);
        int r = diamondSize / 2;

        double rad = Math.toRadians(angle);
        int x2 = (int) (centerX + r * Math.cos(rad));
        int y2 = (int) (centerY - r * Math.sin(rad));

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3f));
        g2.drawLine(centerX, centerY, x2, y2);

        g2.fillOval(centerX - 5, centerY - 5, 10, 10);

        g2.setFont(new Font("Arial", Font.BOLD, 12));

        int rTexte = r - 30; // On place les chiffres un peu à l'intérieur de l'arc (rayon moins 30px)

        for (int v = 0; v <= vmax; v += 20) { // Une graduation tous les 20 km/h
            // 1. Calcul de l'angle pour cette valeur de vitesse
            double prop = (double) v / vmax;
            double angDeg = 180 - (prop * 180);
            double angRad = Math.toRadians(angDeg);

            // 2. Position X et Y pour le texte
            int tx = (int) (centerX + rTexte * Math.cos(angRad));
            int ty = (int) (centerY - rTexte * Math.sin(angRad));

            // 3. Dessiner le texte (ajustement pour centrer le chiffre)
            String val = String.valueOf(v);
            FontMetrics fm = g2.getFontMetrics();
            int textX = tx - (fm.stringWidth(val) / 2);
            int textY = ty + (fm.getAscent() / 2);

            g2.setColor(Color.GRAY); // Couleur des chiffres
            g2.drawString(val, textX, textY);

            // Optionnel : dessiner un petit trait (tic) sur l'arc
            int xTicDepart = (int) (centerX + (r - 5) * Math.cos(angRad));
            int yTicDepart = (int) (centerY - (r - 5) * Math.sin(angRad));
            int xTicFin = (int) (centerX + r * Math.cos(angRad));
            int yTicFin = (int) (centerY - r * Math.sin(angRad));

            g2.setColor(Color.WHITE);
            g2.drawLine(xTicDepart, yTicDepart, xTicFin, yTicFin);
        }
    }
}
