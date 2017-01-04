package Modèle;
import static java.lang.System.*;
/**
 * Created by ben_s on 05/12/2016.
 */
public class EquipageException extends Exception {

    public EquipageException(int i){
        switch (i){
            case 1://Erreur Déjà deux qualifications pour un membre d'équipage
                System.err.println("Ce membre d'équipage à déjà deux qualifications");
                break;
            case 2:
                System.err.println("Cette position est déjà affectée");
                break;
            case 3:
                System.err.println("Nombre max de PNC atteint");
                break;
            case 4:
                System.out.println("Membre d'équipage non qualifié");
                break;
        }
    }
}
