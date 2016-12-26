package DataBase;

import Modèle.*;

import java.sql.*;
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
            String query = "insert into membreequipage values (?, ?, ?, ?, ? )";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, membreEquipage.getNom());
            preparedStmt.setString (2,membreEquipage.getPrenom());
            preparedStmt.setString (3, membreEquipage.getMetier().toString());
            if(membreEquipage.getQualification().size()>=1) {
                preparedStmt.setString(4, membreEquipage.getQualification().get(0).getNom());
            }else {
                preparedStmt.setNull(4, Types.VARCHAR);
            }
            if(membreEquipage.getQualification().size()==2){
                preparedStmt.setString(5,membreEquipage.getQualification().get(1).getNom());
            }else {
                preparedStmt.setNull(5, Types.VARCHAR);
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
            if(res.next()) {
                pilote = new Pilote(res.getString("Nom"), res.getString("Prenom"));
                res.getString("qualif1");
                if (!res.wasNull()) {
                    pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif1")));
                }
                res.getString("qualif2");
                if (!res.wasNull()) {
                    pilote.addQualification(DBTypeAvion.findTypeAvion(res.getString("qualif2")));
                }


                return pilote;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EquipageException e) {
            e.printStackTrace();
        } catch (InvariantBroken invariantBroken) {
            invariantBroken.printStackTrace();
        }
        return null;

    }
    public static ArrayList<Vol> findVolByMembreEquipage(String nom){
        ArrayList<Vol> vols = new ArrayList<Vol>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM vol");
            while (res.next()){
                Statement stt2 = con.createStatement();
                ResultSet res2 = stt2.executeQuery("SELECT * FROM equipage " +
                        "WHERE volRefNpc='"+ res.getString("numvol")+"' AND Pilot ='"+nom+"'");
                if(res2.next()){
                    vols.add(DbVol.findVol(res.getString("numvol")));
                }
                ResultSet res3 = stt2.executeQuery("SELECT * FROM equipage " +
                        "WHERE volRefNpc='"+ res.getString("numvol")+"' AND Copilot ='"+nom+"'");
                if(res3.next()){
                    vols.add(DbVol.findVol(res.getString("numvol")));
                }
                ResultSet res4 = stt2.executeQuery("SELECT * FROM assocpncequipage " +
                        "WHERE refEquipage='"+ res.getString("numvol")+"' AND nompnc ='"+nom+"'");
                if(res4.next()){
                    vols.add(DbVol.findVol(res.getString("numvol")));
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vols;
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
    public static void deleteMembreEquipage(MembreEquipage membreEquipage){
        try {
            String query = "DELETE FROM membreequipage WHERE Nom = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, membreEquipage.getNom());
            preparedStmt.executeUpdate();

            String query2 = "DELETE FROM assocpncequipage WHERE nompnc = ? ";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
            preparedStmt2.setString (1, membreEquipage.getNom());
            preparedStmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public void addQualification(MembreEquipage membreEquipage) {
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM membreequipage WHERE Nom ='"+membreEquipage.getNom()+"'");
            res.next();
            if(membreEquipage.getQualification().size()>=1) {
                String querry = "UPDATE membreequipage SET qualif1 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt = con.prepareStatement(querry);
                preparedStmt.setString(1, membreEquipage.getQualification().get(0).getNom());
                preparedStmt.setString(2, membreEquipage.getNom());
                preparedStmt.executeUpdate();
            }
            if(membreEquipage.getQualification().size()==2) {
                String querry2 = "UPDATE membreequipage SET qualif2 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt2 = con.prepareStatement(querry2);
                preparedStmt2.setString(1, membreEquipage.getQualification().get(1).getNom());
                preparedStmt2.setString(2, membreEquipage.getNom());
                preparedStmt2.executeUpdate();
            }
            if(membreEquipage.getQualification().size()==0){
                String querry = "UPDATE membreequipage SET qualif1 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt = con.prepareStatement(querry);
                preparedStmt.setNull(1,Types.VARCHAR);
                preparedStmt.setString(2, membreEquipage.getNom());
                preparedStmt.executeUpdate();
                String querry2 = "UPDATE membreequipage SET qualif2 = ? WHERE Nom = ?";
                PreparedStatement preparedStmt2 = con.prepareStatement(querry2);
                preparedStmt2.setNull(1,Types.VARCHAR);
                preparedStmt2.setString(2, membreEquipage.getNom());
                preparedStmt2.executeUpdate();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
