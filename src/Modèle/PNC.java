package Modèle;

import DataBase.TypeMembreEquipage;

/**
 * Created by ben_s on 29/11/2016.
 */
public class PNC extends MembreEquipage{
    public PNC(String nom, String prenom) throws InvariantBroken {
        super(nom, prenom, TypeMembreEquipage.PNC);
        if(nom==null){
            throw new InvariantBroken();
        }
    }

}
