package Modèle;

import DataBase.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ben_s on 29/11/2016.
 */
public class TableauVols {
    private ArrayList<Vol> tableauDeVols;
    private ArrayList<Avion> tableauAvion;
    private ArrayList<TypeAvion> tablaeuTypeAvion;
    private ArrayList<MembreEquipage> tableauMembreEquipage;
    private ArrayList<Equipage> tableauEquipage;
    private String Name;
    private DbVol dbVol;
    private DBTypeAvion dbTypeAvion;
    private DBAvion dbAvion;
    private DBMembreEquipage dbMembreEquipage;
    private DBEquipage dbEquipage;
    public TableauVols(String name) {
        Name = name;
        dbVol = new DbVol();
        dbTypeAvion = new DBTypeAvion();
        dbAvion = new DBAvion();
        dbMembreEquipage = new DBMembreEquipage();
        dbEquipage = new DBEquipage();
        tableauDeVols = dbVol.loadVol();
        tablaeuTypeAvion = dbTypeAvion.loadTypeAvion();
        tableauAvion = dbAvion.loadAvion();
        //dbAvion.addAvion(tablaeuTypeAvion.get(0),"FR15");
        //MembreEquipage.addMembreEquipage();
        System.out.println(tableauAvion.get(0).toString());
        tableauMembreEquipage = dbMembreEquipage.loadMembreEquipages();
        System.out.println(tableauMembreEquipage.get(0).toString());
        tableauEquipage = dbEquipage.loadEquipages();
    }
    public void addVol(String num, String site, String destination, Avion avion, Date date){
        Vol vol = new Vol("FR01","Paris","London",new Date(),avion);
        tableauDeVols.add(vol);
    }

}
