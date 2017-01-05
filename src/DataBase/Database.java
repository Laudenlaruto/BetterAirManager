package DataBase;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

import static DataBase.DBConfig.*;

/**
 * Created by Titan on 10/12/2016.
 */
public class Database {
    public static Connection con;
    public Database(){
        try {
            con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            stt.execute("use betterairmanager");//Script SQL betterairmanager.sql


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
