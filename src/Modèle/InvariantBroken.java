package Modèle;

/**
 * Created by ben_s on 05/12/2016.
 */
public class InvariantBroken extends Exception {
    public InvariantBroken() {
        System.err.println("Variable non valide");
    }
}
