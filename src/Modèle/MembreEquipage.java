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
}