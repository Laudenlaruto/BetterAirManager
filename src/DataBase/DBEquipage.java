package DataBase;

import Modèle.Equipage;
import Modèle.Vol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBEquipage extends Database {
    public DBEquipage() {
        super();
    }

    public ArrayList<Equipage> loadEquipages() {
        ArrayList<Equipage> equipages = new ArrayList<Equipage>();
        Statement stt = null;
        try {
            stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM equipage");
            while (res.next()) {
                Equipage equipage = new Equipage(DBMembreEquipage.findMembreEquipagePilote(res.getString("Pilote")),
                        DBMembreEquipage.findMembreEquipageCoPilot(res.getString("Copilot")),
                        DBMembreEquipage.findMembreEquipageNPC(res.getString("volRefNpc")),
                        DbVol.findVol(res.getString("volRefNpc")));
            }
            return equipages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipages;
    }
    public static Equipage findEquipage(Vol vol){
        Equipage equipage;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM equipage WHERE volRefNpc ='"+vol.getNumeroDeVol()+"'");
            res.next();

            equipage = new Equipage(DBMembreEquipage.findMembreEquipagePilote(res.getString("pilote")),
                    DBMembreEquipage.findMembreEquipageCoPilot(res.getString("Copilot")),
                    DBMembreEquipage.findMembreEquipageNPC(vol.getNumeroDeVol())
                    ,vol);
            return equipage;

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }
}
