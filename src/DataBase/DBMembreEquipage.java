package DataBase;

import Modèle.CoPilote;
import Modèle.MembreEquipage;
import Modèle.PNC;
import Modèle.Pilote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBMembreEquipage extends Database {
    public DBMembreEquipage() {
        super();
    }

    public static Pilote  findMembreEquipagePilote(String nom){
        Pilote pilote;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM equipage WHERE Nom ='"+nom+"' AND Metier ='"+ TypeMembreEquipage.PILOTE+"'");
            res.next();
            pilote = new Pilote(res.getString("Nom"), res.getString("Prenom"));
            return pilote;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    //TODO Recherche sur table d'association
    public static ArrayList<PNC> findMembreEquipageNPC(String numeroDeVol) {
        ArrayList<PNC> pnc = new ArrayList<PNC>();
        try {

            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM assocpncequipage WHERE refEquipage ='"+ numeroDeVol+"'");
            while (res.next()) {
                Statement stt2 = con.createStatement();
                ResultSet res2 = stt.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+ res.getString("nompnc")+"'");
                pnc.add((new PNC(res2.getString("Nom"),res2.getString("Prenom"))));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pnc;

    }


    public static CoPilote findMembreEquipageCoPilot(String nom) {
        CoPilote Copilote;
        try {

            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM equipage WHERE Nom ='"+nom+"' AND Metier ='"+ TypeMembreEquipage.COPILOTE+"'");
            res.next();
            Copilote = new CoPilote(res.getString("Nom"), res.getString("Prenom"));
            return Copilote;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
