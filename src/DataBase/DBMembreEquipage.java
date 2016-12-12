package DataBase;

import Modèle.*;

import java.sql.PreparedStatement;
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
    public void addMembreEquipage(MembreEquipage membreEquipage){
        try {
            Statement stt = con.createStatement();
            String query = "insert into membreequipage values (?, ?, ?, ?,? )";
            PreparedStatement preparedStmt = this.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, membreEquipage.getNom());
            preparedStmt.setString (2,membreEquipage.getPrenom());
            preparedStmt.setString (3, membreEquipage.getMetier().toString());
            if(membreEquipage.getQualification().size()==1){
                preparedStmt.setString(4,membreEquipage.getQualification().get(0).getNom());
                if(membreEquipage.getQualification().size()==2){
                    preparedStmt.setString(4,membreEquipage.getQualification().get(1).getNom());
                }
            }
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MembreEquipage> loadMembreEquipages(){
        ArrayList<MembreEquipage> membreEquipages = new ArrayList<MembreEquipage>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM membreequipage");
            while (res.next()) {
                try {
                    if (res.getString("Metier").equals(TypeMembreEquipage.PILOTE.toString())) {
                        Pilote pilote = new Pilote(res.getString("Nom"), res.getString("Prenom"));
                        res.getString("qualif1");
                        if(!res.wasNull()){
                            pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
                        }
                        res.getString("qualif2");
                        if(!res.wasNull()){
                            pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
                        }
                        membreEquipages.add(pilote);
                    } else if (res.getString("Metier").equals(TypeMembreEquipage.COPILOTE.toString())) {
                        CoPilote coPilote = new CoPilote(res.getString("Nom"), res.getString("Prenom"));
                        res.getString("qualif1");
                        if(!res.wasNull()){
                            coPilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
                        }
                        res.getString("qualif2");
                        if(!res.wasNull()){
                            coPilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
                        }
                        membreEquipages.add(coPilote);
                    } else {
                        PNC pnc = new PNC(res.getString("Nom"), res.getString("Prenom"));
                        res.getString("qualif1");
                        if(!res.wasNull()){
                            pnc.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
                        }
                        res.getString("qualif2");
                        if(!res.wasNull()){
                            pnc.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
                        }
                        membreEquipages.add(pnc);
                    }
                }
                catch (EquipageException e) {
                    e.printStackTrace();
                } catch (InvariantBroken invariantBroken) {
                    invariantBroken.printStackTrace();
                }

            }
            return membreEquipages;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static Pilote  findMembreEquipagePilote(String nom){
        Pilote pilote;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+nom+"' AND Metier ='"+ TypeMembreEquipage.PILOTE.toString()+"'");
            res.next();
            pilote = new Pilote(res.getString("Nom"), res.getString("Prenom"));
            res.getString("qualif1");
            if(!res.wasNull()){
                pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
            }
            res.getString("qualif2");
            if(!res.wasNull()){
                pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
            }

            return pilote;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EquipageException e) {
            e.printStackTrace();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.printStackTrace();
        }
        return null;

    }
    public static ArrayList<PNC> findMembreEquipagePNC(String numeroDeVol) {
        ArrayList<PNC> pncs = new ArrayList<PNC>();
        try {

            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM assocpncequipage WHERE refEquipage ='"+ numeroDeVol+"'");
            while (res.next()) {
                Statement stt2 = con.createStatement();
                ResultSet res2 = stt2.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+ res.getString("nompnc")+"'");
                res2.next();

                PNC pnc = new PNC(res2.getString("Nom"),res2.getString("Prenom"));
                res2.getString("qualif1");
                if(!res2.wasNull()){
                    pnc.addQualification(DBTypeAvion.findTypeAvion(res2.getString("qualif1")));
                }
                res2.getString("qualif2");
                if(!res2.wasNull()){
                    pnc.addQualification(DBTypeAvion.findTypeAvion(res2.getString("qualif2")));
                }
                pncs.add(pnc);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EquipageException e) {
            e.printStackTrace();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.printStackTrace();
        }
        return pncs;

    }


    public static CoPilote findMembreEquipageCoPilot(String nom) {
        CoPilote coPilote;
        try {

            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+nom+"' AND Metier ='"+ TypeMembreEquipage.COPILOTE+"'");
            res.next();
            coPilote = new CoPilote(res.getString("Nom"), res.getString("Prenom"));
            res.getString("qualif1");
            if(!res.wasNull()){
                coPilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
            }
            res.getString("qualif2");
            if(!res.wasNull()){
                coPilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
            }
            return coPilote;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EquipageException e) {
            e.printStackTrace();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.printStackTrace();
        }
        return null;

    }

    public void addQualification(TypeAvion typeAvion, MembreEquipage membreEquipage) {
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+membreEquipage.getNom()+"'");
            res.next();
            res.getString("qualif1");
            if(res.wasNull()){
                String querry = "UPDATE membreequipage SET qualif1 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt = this.con.prepareStatement(querry);
                preparedStmt.setString (1, typeAvion.getNom());
                preparedStmt.setString(2,membreEquipage.getNom());
                preparedStmt.executeUpdate();
            }else {
                String querry = "UPDATE membreequipage SET qualif2 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt = this.con.prepareStatement(querry);
                preparedStmt.setString (1, typeAvion.getNom());
                preparedStmt.setString(2,membreEquipage.getNom());
                preparedStmt.executeUpdate();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
