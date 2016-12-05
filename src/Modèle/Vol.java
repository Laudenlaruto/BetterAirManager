package Modèle;

import java.util.Date;

/**
 * Created by ben_s on 29/11/2016.
 */
public class Vol {
    private String numeroDeVol;
    private String site;
    private String destination;
    private Date date;
    private Avion avion;
    private Equipage equipage;

    public Vol(String num, String site, String dest, Avion avion, Date depart){
      this.numeroDeVol=num;
      this.site = site;
      this.destination = dest;
      this.date = depart;
      this.avion = avion;
    }
    public Vol(String num, Date dep){
        this.numeroDeVol = num;
        this.date = dep;
    }
    public void addPilote(Pilote pilote) throws EquipageException{
        if(!equipage.pilotIsSet()){
            equipage.setPilote(pilote);
        }else{
            throw new EquipageException(2);
        }
    }
    public void addCoPilote(CoPilote coPilote) throws EquipageException{
        if(!equipage.coPilotIsSet()){
            equipage.setCoPilote(coPilote);
        }else{
            throw new EquipageException(2);
        }
    }
    public void addPNC(PNC pnc) throws EquipageException{
        if(avion.getTypeAvion().getNbNPCmax()>equipage.getPNC().size()){
            equipage.getPNC().add(pnc);
        }else{
            throw new EquipageException(3);
        }

    }
    public boolean equipagaAuComplet(){
        if(equipage.pilotIsSet() && equipage.coPilotIsSet() && equipage.getPNC().size()>avion.getTypeAvion().getNbPNCmin()){
            return true;
        }else{
            return false;
        }
    }
}
