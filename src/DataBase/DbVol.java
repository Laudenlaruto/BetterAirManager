package DataBase;

import Modèle.Avion;
import Modèle.Equipage;
import Modèle.Vol;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DbVol extends Database {

    public DbVol(){
        super();
    }
    public void addVol(Vol vol){
        try {
            Statement stt = con.createStatement();
            String query = "insert into vol values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, vol.getNumeroDeVol());
            preparedStmt.setString (2, vol.getSite());
            preparedStmt.setString (3, vol.getDestination());
            preparedStmt.setDate(4, vol.getDate());
            preparedStmt.setString(5,vol.getAvion().getRef());
            preparedStmt.execute();
            DBEquipage.addEquipage(vol.getEquipage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Vol>loadVol(){
        ArrayList<Vol> vols = new ArrayList<Vol>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM vol");
            while (res.next()) {

                Vol vol = new Vol(
                        res.getString("numvol"),
                        res.getString("site"),
                        res.getString("dest"),
                        res.getDate("date"),
                        DBAvion.findAvion(res.getString("avion")));
                        vol.setEquipage(DBEquipage.findEquipage(vol));

                vols.add(vol);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
    }
    public static Vol findVol(String equipage){
        Vol vol;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM vol WHERE numvol='"+equipage+"'");
            res.next();
            vol = new Vol(
                    res.getString("numvol"),
                    res.getString("site"),
                    res.getString("dest"),
                    res.getDate("date"),
                    DBAvion.findAvion(res.getString("avion")));
            vol.setEquipage(DBEquipage.findEquipage(vol));
            return vol;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteVol(Vol vol) {
        try {
            Statement stt = con.createStatement();
            String query = "DELETE FROM vol WHERE numvol = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, vol.getNumeroDeVol());
            preparedStmt.execute();
            DBEquipage.deleteEquipage(vol);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
