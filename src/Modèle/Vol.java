package Modèle;

import java.util.Date;

/**
 * Created by ben_s on 29/11/2016.
 */
public class Vol {
    private String numeroDeVol;
    private String site;
    private String destination;
    private java.sql.Date date;
    private Avion avion;
    private Equipage equipage;


    public Vol(String numeroDeVol, String site, String destination, java.sql.Date date, Avion avion) {
        this.numeroDeVol = numeroDeVol;
        this.site = site;
        this.destination = destination;
        this.date = date;
        this.avion = avion;
    }

    public Vol(String num, java.sql.Date dep){
        this.numeroDeVol = num;
        this.date = dep;
    }
    public void addPilote(Pilote pilote) throws EquipageException{
        if(pilote.peutVoler(avion.getTypeAvion())) {
            if (equipage.pilotIsSet()) {
                equipage.setPilote(pilote);
            } else {
                throw new EquipageException(2);
            }
        }else{
            throw new EquipageException(4);
        }
    }
    public void addCoPilote(CoPilote coPilote) throws EquipageException{
        if(equipage.coPilotIsSet() && coPilote.peutVoler(avion.getTypeAvion())){
            equipage.setCoPilote(coPilote);
        }else{
            throw new EquipageException(2);
        }
    }
    public void addPNC(PNC pnc) throws EquipageException{
        if(avion.getTypeAvion().getNbPNCmax()>
                equipage.getPNC().size() && pnc.peutVoler(avion.getTypeAvion())){
            equipage.getPNC().add(pnc);
        }else{
            throw new EquipageException(3);
        }

    }
    public boolean equipagaAuComplet(){
        return (!equipage.pilotIsSet() && !equipage.coPilotIsSet() && equipage.getPNC().size()>=avion.getTypeAvion().getNbPNCmin() && equipage.getPNC().size()<=avion.getTypeAvion().getNbPNCmax());
    }

    public String getNumeroDeVol() {
        return numeroDeVol;
    }

    public void setNumeroDeVol(String numeroDeVol) {
        this.numeroDeVol = numeroDeVol;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Equipage getEquipage() {
        return equipage;
    }

    public void setEquipage(Equipage equipage) {
        this.equipage = equipage;
    }
}
