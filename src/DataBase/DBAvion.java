package DataBase;

import Modèle.Avion;
import Modèle.TypeAvion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBAvion extends Database {
    public DBAvion(){
        super();
    }

    public void addAvion(TypeAvion typeAvion, String ref){
        try {
            Statement stt = con.createStatement();
            String querry = "INSERT into avion VALUES (?, ?)";
            PreparedStatement preparedStmt = this.con.prepareStatement(querry);
            preparedStmt.setString (1, typeAvion.getNom());
            preparedStmt.setString    (2, ref);
            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Avion> loadAvion(){
        ArrayList<Avion> avions = new ArrayList<Avion>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM avion");
            while (res.next()) {
                Avion avion = new Avion(DBTypeAvion.findTypeAvion(res.getString("TypeAvion")),res.getString("Ref"));
                avions.add(avion);
            }
            return avions;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Avion findAvion(String ref){
        Avion avion;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM avion WHERE nom ='"+ref+"'");
            res.next();
            avion = new Avion(DBTypeAvion.findTypeAvion(res.getString("TypeAvion")),res.getString("ref"));
            return avion;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
