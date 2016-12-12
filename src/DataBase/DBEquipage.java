package DataBase;

import Modèle.Equipage;
import Modèle.MembreEquipage;
import Modèle.Vol;

import java.sql.PreparedStatement;
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
    public void addEquipage(Equipage equipage){
        try {
            Statement stt = con.createStatement();
            String query = "insert into equipage values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, equipage.getPilote().getNom());
            preparedStmt.setString (2,equipage.getCoPilote().getNom());
            preparedStmt.setString (3, equipage.getRefVol());
            preparedStmt.execute();
            for (int i =0; i<equipage.getPNC().size();i++){
                query = "insert into assocpncequipage values (?, ?)";
                preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString (1, equipage.getRefVol());
                preparedStmt.setString (2, equipage.getPNC().get(i).getNom());
                preparedStmt.execute();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Equipage> loadEquipages() {
        ArrayList<Equipage> equipages = new ArrayList<Equipage>();
        Statement stt = null;
        try {
            stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM equipage");
            while (res.next()) {
                Equipage equipage = new Equipage(
                        DBMembreEquipage.findMembreEquipagePilote(res.getString("Pilot")),
                        DBMembreEquipage.findMembreEquipageCoPilot(res.getString("Copilot")),
                        DBMembreEquipage.findMembreEquipagePNC(res.getString("volRefNpc")),
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

            equipage = new Equipage(DBMembreEquipage.findMembreEquipagePilote(res.getString("Pilot")),
                    DBMembreEquipage.findMembreEquipageCoPilot(res.getString("Copilot")),
                    DBMembreEquipage.findMembreEquipagePNC(vol.getNumeroDeVol())
                    ,vol.getNumeroDeVol());
            return equipage;

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

    public void addMembreEquiageAEquipage(MembreEquipage membreEquipage, Equipage equipage) {
        try {
            if (membreEquipage.getMetier().equals(TypeMembreEquipage.PNC)){
                Statement stt = con.createStatement();
                String query = "insert into assocpncequipage values (?, ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString (1, equipage.getRefVol());
                preparedStmt.setString (2, membreEquipage.getNom());
                preparedStmt.execute();
            }else if (membreEquipage.getMetier().equals(TypeMembreEquipage.PILOTE)){
                Statement stt = con.createStatement();
                String query = "insert into equipage (Pilot) values (?)";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString (1, membreEquipage.getNom());
                preparedStmt.execute();
            }else {
                Statement stt = con.createStatement();
                String query = "insert into equipage (Copilot) values (?)";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString (1, membreEquipage.getNom());
                preparedStmt.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMembreEquipageAEquipage(MembreEquipage membreEquipage, Equipage equipage) {
        try {
            if (membreEquipage.getMetier().equals(TypeMembreEquipage.PNC)) {
                Statement stt = con.createStatement();
                String query = "DELETE assocpncequipage where refEquipage = ? AND nompnc = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString(1, equipage.getRefVol());
                preparedStmt.setString(2, membreEquipage.getNom());
                preparedStmt.execute();
            } else if (membreEquipage.getMetier().equals(TypeMembreEquipage.PILOTE)) {
                Statement stt = con.createStatement();
                String query = "DELETE equipage WHERE Pilot = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString(1, membreEquipage.getNom());
                preparedStmt.execute();
            } else {
                Statement stt = con.createStatement();
                String query = "DELETE equipage where Copilot = ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString(1, membreEquipage.getNom());
                preparedStmt.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEquipage(Vol vol) {
        try {
            Statement stt = con.createStatement();
            String query = "DELETE FROM equipage WHERE volRefNpc = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, vol.getNumeroDeVol());
            preparedStmt.execute();
            query = "DELETE FROM assocpncequipage WHERE refEquipage = ? ";
            preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, vol.getNumeroDeVol());
            preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
