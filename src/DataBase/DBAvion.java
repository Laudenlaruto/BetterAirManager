package DataBase;

import Modèle.Avion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBAvion extends Database {
    public DBAvion(){
        super();
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
