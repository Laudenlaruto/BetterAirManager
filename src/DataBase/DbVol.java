package DataBase;

import Modèle.Avion;
import Modèle.Equipage;
import Modèle.Vol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DbVol extends Database {

    public DbVol(){
        super();
    }
    public ArrayList<Vol>loadVol(){
        ArrayList<Vol> vols = new ArrayList<Vol>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM vol");
            while (res.next()) {

                Vol vol = new Vol(res.getString("numvol"),res.getString("site"),res.getString("dest"),res.getDate("date"),
                        DBAvion.findAvion(res.getString("avion")));

                        vol.setEquipage(DBEquipage.findEquipage(vol));

                vols.add(vol);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
    }

}
