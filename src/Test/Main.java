package Test;

import Modèle.Avion;
import Modèle.TableauVols;
import Modèle.TypeAvion;
import Modèle.Vol;
import java.util.Date;

/**
 * Created by ben_s on 05/12/2016.
 */
public class Main {
    public void main(){
        TableauVols tab1 = new TableauVols("Betty");
        TypeAvion typ1 = new TypeAvion("A380",10,30);
        Avion avion1 = new Avion(typ1,"FR01");
        Vol volFR = new Vol("FR01","Paris","London",avion1,new Date());
        System.out.println(volFR.toString());
    }
}
