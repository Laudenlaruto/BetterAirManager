package Modèle;

import java.util.ArrayList;

/**
 * Created by ben_s on 29/11/2016.
 */
public abstract class MembreEquipage {
    private String nom;
    private String prenom;
    private String metier;
    private ArrayList<TypeAvion> qualification;

    public MembreEquipage(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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
    public boolean delQualification(TypeAvion typeAvion, boolean fromType){
        if(fromType){
            qualification.remove(typeAvion);
            return true;
        }else {
            return false;
        }
    }

    public String getNom() {return nom;}
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }
}