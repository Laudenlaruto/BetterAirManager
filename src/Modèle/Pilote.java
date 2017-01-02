package Modèle;

import DataBase.TypeMembreEquipage;

/**
 * Created by ben_s on 29/11/2016.
 */
public class Pilote extends MembreEquipage {

    public Pilote(String nom, String prenom) throws InvariantBroken {
        super(nom,prenom, TypeMembreEquipage.PILOTE);
        if(nom==null){
            throw new InvariantBroken();
        }

    }


}
