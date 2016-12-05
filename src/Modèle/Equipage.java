package Modèle;

import java.util.ArrayList;

/**
 * Created by ben_s on 29/11/2016.
 */
public class Equipage {
    private boolean auMin;
    private boolean auMax;
    private Pilote pilote;
    private CoPilote coPilote;
    private ArrayList<PNC> PNC;
    private Vol vol;

    public Equipage(Vol vol){
        this.vol =vol;
    }
    public boolean pilotIsSet(){
        if(this.getPilote() == null){
            return false;
        }else{
            return true;
        }
    }
    public boolean coPilotIsSet(){
        if(this.getCoPilote() == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean isAuMin() {
        return auMin;
    }

    public void setAuMin(boolean auMin) {
        this.auMin = auMin;
    }

    public boolean isAuMax() {
        return auMax;
    }

    public void setAuMax(boolean auMax) {
        this.auMax = auMax;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public CoPilote getCoPilote() {
        return coPilote;
    }

    public void setCoPilote(CoPilote coPilote) {
        this.coPilote = coPilote;
    }

    public ArrayList<Modèle.PNC> getPNC() {
        return PNC;
    }

    public void setPNC(ArrayList<Modèle.PNC> PNC) {
        this.PNC = PNC;
    }
}
