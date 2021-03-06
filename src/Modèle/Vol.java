package Modèle;


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

    public boolean equipageIsSet(){
        return (this.getEquipage()==null);
    }
    public Vol(String numeroDeVol, String site, String destination, java.sql.Date date, Avion avion) {
        this.numeroDeVol = numeroDeVol;
        this.site = site;
        this.destination = destination;
        this.date = date;
        this.avion = avion;
    }
    public boolean membreEquipageInVol(MembreEquipage membreEquipage){
        if(this.getEquipage().getPilote().getNom().equals(membreEquipage.getNom())){
            return true;
        }
        if(this.getEquipage().getCoPilote().getNom().equals(membreEquipage.getNom())){
            return true;
        }
        if(!getEquipage().PNCIsSet()){
            for(int i =0;i < getEquipage().getPNC().size();i++){
                if(getEquipage().getPNC().get(i).getNom().equals(membreEquipage.getNom())){
                    return true;
                }
            }
        }

        return false;
    }
    public Vol(String num, java.sql.Date dep){
        this.numeroDeVol = num;
        this.date = dep;
    }
    public String toString(){
        return numeroDeVol;
    }

    public boolean equipagaAuComplet(){
        if (!equipage.PNCIsSet()) {
            return (!equipage.pilotIsSet() && !equipage.coPilotIsSet() && equipage.getPNC().size() >= avion.getTypeAvion().getNbPNCmin() && equipage.getPNC().size() <= avion.getTypeAvion().getNbPNCmax());
        }else{
            return false;
        }
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
