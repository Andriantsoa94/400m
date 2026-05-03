package model;

public class Voiture {
    private String nom;
    private double vitesseMax;
    private double acceleration;

    public Voiture() {
    }

    public Voiture(String nom, double vitesseMax, double acceleration) {
        this.nom = nom;
        this.vitesseMax = vitesseMax;
        this.acceleration = acceleration;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(double vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
}