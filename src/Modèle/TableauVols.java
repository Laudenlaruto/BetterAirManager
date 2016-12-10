package Modèle;

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

    public TableauVols(String name) {
        Name = name;
        tableauDeVols = new ArrayList<Vol>();
        tablaeuTypeAvion = new ArrayList<TypeAvion>();
        tableauAvion = new ArrayList<Avion>();
        tableauMembreEquipage = new ArrayList<MembreEquipage>();
        tableauEquipage = new ArrayList<Equipage>();
    }
    public void addVol(String num, String site, String destination, Avion avion, Date date){
        Vol vol = new Vol("FR01","Paris","London",new Date(),avion);
        tableauDeVols.add(vol);
    }
}
