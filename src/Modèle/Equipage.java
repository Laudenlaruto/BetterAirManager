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

    public Equipage(Pilote pilote, CoPilote coPilote, ArrayList<Modèle.PNC> PNC, Vol vol) {
        this.pilote = pilote;
        this.coPilote = coPilote;
        this.PNC = PNC;
        this.vol = vol;
    }

    public Equipage(Vol vol){

            this.vol =vol;
            this.PNC = new ArrayList<PNC>();
        }
        public boolean pilotIsSet(){
            return(this.getPilote() == null);
        }
        public boolean coPilotIsSet(){
            return(this.getCoPilote() == null);
        }
        public void pncToString(){
            if(PNC!=null){
                for (PNC pnc : PNC){
                    System.out.println(pnc);
                }
            }else {
                System.out.println("Pas de PNC sur ce vol");
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

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public void pilotToString() {
            if(!pilotIsSet()){
                System.out.println(this.getPilote());
            }else{
                System.out.println("Pas de pilot sur ce vol");
            }

    }

    public void coPilotToString() {
            if (!coPilotIsSet()){
                System.out.println(this.getCoPilote());
            }else{
                System.out.println("Pas de CoPilot sur ce vol");
            }

    }
}
