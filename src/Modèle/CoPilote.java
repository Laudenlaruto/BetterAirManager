package Modèle;

import DataBase.TypeMembreEquipage;

/**
 * Created by ben_s on 29/11/2016.
 */
public class CoPilote extends MembreEquipage{
    public CoPilote(String nom, String prenom) throws InvariantBroken {
        super(nom, prenom, TypeMembreEquipage.COPILOTE);
        if(nom==null){
            throw new InvariantBroken();
        }
    }
}
