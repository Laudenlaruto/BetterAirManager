package Test;

import Modèle.*;

import java.util.Date;

/**
 * Created by ben_s on 06/12/2016.
 */
public class Comet {

    public static void main(String[] args){
        System.out.print("Welcome to BetterAirManager BAM\n");
        new Comet();

    }
    private Comet(){
        TableauVols tab1 = new TableauVols("Betty");
        TypeAvion typ1 = new TypeAvion("A380",3,5);
        Avion avion1 = new Avion(typ1,"FR01");
        Vol volFR = new Vol("FR01","Paris","London",new Date(),avion1);
        Equipage equipage1 = new Equipage(volFR);
        volFR.setEquipage(equipage1);
        Pilote pilote1 = new Pilote("Jean","pilote");
        CoPilote coPilote1 = new CoPilote("Loic","Dupoont");
        PNC pnc1 = new PNC("TOTO","Francois");
        PNC pnc2 = new PNC("T","Francois");
        PNC pnc3 = new PNC("TOT","Francois");

        Aeroports listeAeroports = new Aeroports();
        listeAeroports.addAeroports("Paris");
        listeAeroports.lectureAeroports();
        System.out.println(listeAeroports);
        listeAeroports.resetAeroports();
        System.out.println(listeAeroports);


        /*try {
            pnc1.addQualification(typ1);
            pilote1.addQualification(typ1);
            coPilote1.addQualification(typ1);
            pnc2.addQualification(typ1);
            pnc3.addQualification(typ1);
            volFR.addPilote(pilote1);
            volFR.addCoPilote(coPilote1);
            volFR.addPNC(pnc1);
            volFR.addPNC(pnc2);
            volFR.addPNC(pnc3);
        } catch (EquipageException e) {
            e.toString();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.toString();
        }
        volFR.getEquipage().pilotToString();
        volFR.getEquipage().coPilotToString();
        volFR.getEquipage().pncToString();
        if(volFR.equipagaAuComplet()){
            System.out.println("Oui complet");
        }

        Pilote pilote2 = new Pilote("Pierre","lioi");
*/
    }
}

