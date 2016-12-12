package Modèle;

import DataBase.*;

import java.util.ArrayList;
import java.util.Calendar;
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
        this.Name = name;
        dbVol = new DbVol();
        dbTypeAvion = new DBTypeAvion();
        dbAvion = new DBAvion();
        dbMembreEquipage = new DBMembreEquipage();
        dbEquipage = new DBEquipage();

        tableauAvion = dbAvion.loadAvion();
        tableauDeVols = dbVol.loadVol();
        tablaeuTypeAvion = dbTypeAvion.loadTypeAvion();
        tableauMembreEquipage = dbMembreEquipage.loadMembreEquipages();
        tableauEquipage = dbEquipage.loadEquipages();



    }
    public void addVol(Vol vol){
        dbVol.addVol(vol);
    }
    public void deleteVol(Vol vol){
        dbVol.deleteVol(vol);
    }
    public void addAvion(Avion avion){
        dbAvion.addAvion(avion);
    }
    public void deleteAvion(Avion avion){
        dbAvion.deleteAvion(avion);
    }
    public void addTypeAvion(TypeAvion typeAvion){
        dbTypeAvion.addTypeAvion(typeAvion);
    }
    public void deleteTypeAvion(TypeAvion typeAvion){
        dbTypeAvion.deleteTypeAvion(typeAvion);
    }
    public void addEquipage(Equipage equipage){
        dbEquipage.addEquipage(equipage);
    }
    public void addMembreEquipage(MembreEquipage membreEquipage){
        dbMembreEquipage.addMembreEquipage(membreEquipage);
    }
    public void addMembreEquipageAEquipage(MembreEquipage membreEquipage,Equipage equipage){
        dbEquipage.addMembreEquiageAEquipage(membreEquipage, equipage);
    }
    public void deleteMembreEquipageAEquipage(MembreEquipage membreEquipage,Equipage equipage){

        dbEquipage.deleteMembreEquipageAEquipage(membreEquipage, equipage);
    }
    public void addQualification(TypeAvion typeAvion, MembreEquipage membreEquipage){
        try {
            membreEquipage.addQualification(typeAvion);
            dbMembreEquipage.addQualification(typeAvion, membreEquipage);
        } catch (EquipageException e) {
            e.printStackTrace();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.printStackTrace();
        }

    }

    public ArrayList<Avion> getTableauAvion() {
        return tableauAvion;
    }

    public void setTableauAvion(ArrayList<Avion> tableauAvion) {
        this.tableauAvion = tableauAvion;
    }

    public ArrayList<TypeAvion> getTablaeuTypeAvion() {
        return tablaeuTypeAvion;
    }

    public void setTablaeuTypeAvion(ArrayList<TypeAvion> tablaeuTypeAvion) {
        this.tablaeuTypeAvion = tablaeuTypeAvion;
    }

    public ArrayList<MembreEquipage> getTableauMembreEquipage() {
        return tableauMembreEquipage;
    }

    public void setTableauMembreEquipage(ArrayList<MembreEquipage> tableauMembreEquipage) {
        this.tableauMembreEquipage = tableauMembreEquipage;
    }

    public ArrayList<Equipage> getTableauEquipage() {
        return tableauEquipage;
    }

    public void setTableauEquipage(ArrayList<Equipage> tableauEquipage) {
        this.tableauEquipage = tableauEquipage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Vol> getTableauDeVols() {
        return tableauDeVols;
    }

    public void setTableauDeVols(ArrayList<Vol> tableauDeVols) {
        this.tableauDeVols = tableauDeVols;
    }
}
