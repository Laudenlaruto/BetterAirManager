package Modèle;

/**
 * Created by ben_s on 29/11/2016.
 */
public class TypeAvion {
    private String nom;
    private int nbPNCmin;
    private int nbPNCmax;

    public TypeAvion(String nom, int nbPNCmin, int nbPNCmax) {
        this.nom = nom;
        this.nbPNCmin = nbPNCmin;
        this.nbPNCmax = nbPNCmax;
    }

    public TypeAvion(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbPNCmin() {
        return nbPNCmin;
    }

    public void setNbPNCmin(int nbPNCmin) {
        this.nbPNCmin = nbPNCmin;
    }

    public int getNbPNCmax() {
        return nbPNCmax;
    }

    public void setNbPNCmax(int nbPNCmax) {
        this.nbPNCmax = nbPNCmax;
    }
}
