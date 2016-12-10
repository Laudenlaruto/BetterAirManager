package DataBase;

import Modèle.Equipage;
import Modèle.Vol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBEquipage extends Database {
    public DBEquipage() {
        super();
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
