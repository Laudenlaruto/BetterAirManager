package Modèle;

import DataBase.TypeMembreEquipage;

import java.util.ArrayList;

/**
 * Created by ben_s on 29/11/2016.
 */
public abstract class MembreEquipage {
    private String nom;
    private String prenom;
    private TypeMembreEquipage metier;
    private ArrayList<TypeAvion> qualification;

    public MembreEquipage(String nom, String prenom, TypeMembreEquipage metier) {
        this.nom = nom;
        this.prenom = prenom;
        this.metier = metier;
        qualification = new ArrayList<TypeAvion>();
    }
    public String toString(){
        return (this.getNom()+" "+this.getPrenom()+" "+this.getMetier());
    }
    //Vérifcation si un membre d'équipage est qualifié sur un vol
    public boolean  peutVoler(TypeAvion typeAvion){
        return (qualification.contains(typeAvion));

    }
    public boolean addQualification(TypeAvion typeAvion) throws EquipageException, InvariantBroken{
        if(qualification.size()>2){
            throw new EquipageException(1);
        }else{
            qualification.add(typeAvion);
            return true;
        }
    }
    public boolean isQualified(TypeAvion typeAvion) throws EquipageException {

        if (qualification.size()==0){
            return false;
        }
        if (qualification.size()==1){
            return (qualification.get(0).getNom().equals(typeAvion.getNom()));
        }
        if (qualification.size()==2){

            return (qualification.get(0).getNom().equals(typeAvion.getNom()) || qualification.get(1).getNom().equals(typeAvion.getNom()));
        }
        if (qualification.size()>2){
            throw new EquipageException(1);
        }
        return false;
    }
    public boolean isQualified(Avion avion) throws EquipageException {
        if (qualification.size()==0){
            return false;
        }
        if (qualification.size()==1){
            return (qualification.get(0).getNom().equals(avion.getTypeAvion().getNom()));
        }
        if (qualification.size()==2){
            return (qualification.get(0).getNom().equals(avion.getTypeAvion().getNom()) || qualification.get(1).getNom().equals(avion.getTypeAvion().getNom()));
        }
        if (qualification.size()>2){
            throw new EquipageException(1);
        }
        return false;
    }
    public String getNom() {return nom;}
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeMembreEquipage getMetier() {
        return metier;
    }

    public void setMetier(TypeMembreEquipage metier) {
        this.metier = metier;
    }

    public ArrayList<TypeAvion> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<TypeAvion> qualification) {
        this.qualification = qualification;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public boolean isQualified(Vol vol) throws EquipageException {
        if (qualification.size()==0){
            return false;
        }
        if (qualification.size()==1){
            return (qualification.get(0).getNom().equals(vol.getAvion().getTypeAvion().getNom()));
        }
        if (qualification.size()==2){
            return (qualification.get(0).getNom().equals(vol.getAvion().getTypeAvion().getNom()) || qualification.get(1).getNom().equals(vol.getAvion().getTypeAvion().getNom()));
        }
        if (qualification.size()>2){
            throw new EquipageException(1);
        }
        return false;
    }

    public boolean qualifierSurUnVol(TypeAvion typeAvion) {
        TableauVols tableauVols = new TableauVols("VerifQualifSurUnVol");
        for (int i=0;i<tableauVols.getTableauDeVols().size();i++){
            try {
                if(tableauVols.getTableauDeVols().get(i).getEquipage().getPilote().getNom().equals(this.getNom()) && //Si le membre equipage est le pilote
                        tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom().equals(typeAvion.getNom())&& //Si le vol est bien du type de la qualification recherché
                        tableauVols.getTableauDeVols().get(i).getEquipage().getPilote().isQualified(typeAvion) ){//Si le membre equipage est qualifié
                    return true;
                }
            } catch (EquipageException e) {
                e.printStackTrace();
            }
            try {
                if(tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().getNom().equals(this.getNom()) && //Si le membre equipage est le pilote
                        tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom().equals(typeAvion.getNom())&& //Si le vol est bien du type de la qualification recherché
                        tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().isQualified(typeAvion) ){//Si le membre equipage est qualifié
                    return true;
                }
            } catch (EquipageException e) {
                e.printStackTrace();
            }
            for (int j=0;j<tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().size();j++){
                try {
                    if(tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().get(j).getNom().equals(this.getNom()) && //Si le membre equipage est le pilote
                            tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom().equals(typeAvion.getNom())&& //Si le vol est bien du type de la qualification recherché
                            tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().isQualified(typeAvion) ){//Si le membre equipage est qualifié
                        return true;
                    }
                } catch (EquipageException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}