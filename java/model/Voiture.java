package model;

public class Voiture {
    private String nom;
    private Float vitesseMax;
    private Float acceleration;

    public Voiture() {
    }

    public Voiture(String nom, Float vitesseMax, Float acceleration) {
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

    public Float getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(Float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public Float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Float acceleration) {
        this.acceleration = acceleration;
    }
}