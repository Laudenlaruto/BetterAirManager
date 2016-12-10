package Modèle;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Titan on 10/12/2016.
 */
public class Aeroports implements Serializable {
    private File fichierAeroports = new File("src/Fichier/aeroports.txt");
    private ArrayList<String> nomAeroports;
    public Aeroports(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fichierAeroports));
            if (br.readLine() == null) {
                System.out.println("No errors, and file empty");
                nomAeroports = new ArrayList<String>();
            }else {
                lectureAeroports();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void resetAeroports(){
        nomAeroports = new ArrayList<String>();
        ObjectOutputStream flux = null;
        try{
            flux = new ObjectOutputStream(new FileOutputStream(fichierAeroports));
            flux.writeObject(nomAeroports);
            flux.flush();
            flux.close();
        }
        catch(IOException parExc){
            System.err.println("Probleme a l'ecriture "+parExc.toString());
            System.exit(1);

        }
    }
    public void lectureAeroports(){
        ObjectInputStream  flux;
        Object nomAeroportsLu = null;
        nomAeroports = new ArrayList<String>();

        try {
            flux = new ObjectInputStream(new FileInputStream(fichierAeroports));
            nomAeroportsLu = (Object)flux.readObject();
            flux.close();
        } catch (IOException e) {
            System.out.println("Erreur lecture fichier "+e.toString());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        nomAeroports = (ArrayList<String>)nomAeroportsLu;
    }
    public void addAeroports(String nom){
        if (nomAeroports.contains(nom)){
            System.err.println("Aeroports exist déjà");
        }else{
            nomAeroports.add(nom);
            ObjectOutputStream flux = null;
            try{
                flux = new ObjectOutputStream(new FileOutputStream(fichierAeroports));
                flux.writeObject(nomAeroports);
                flux.flush();
                flux.close();
            }
            catch(IOException parExc){
                System.err.println("Probleme a l'ecriture"+parExc.toString());
                System.exit(1);

            }
        }

    }
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < nomAeroports.size(); i++) {
            result += i+1 + "-" + nomAeroports.get(i) +"\n";
        }
        return result;
    }
    public ArrayList<String> getNomAeroports() {
        return nomAeroports;
    }

    public void setNomAeroports(ArrayList<String> nomAeroports) {
        this.nomAeroports = nomAeroports;
    }
}
