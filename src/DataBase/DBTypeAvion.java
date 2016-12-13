package DataBase;


import Modèle.TypeAvion;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Titan on 10/12/2016.
 */
public class DBTypeAvion extends Database {
    public DBTypeAvion(){
        super();
    }
    public ArrayList<TypeAvion>loadTypeAvion(){
        ArrayList<TypeAvion> typeAvions = new ArrayList<TypeAvion>();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM typeavion");
            while (res.next()) {
                TypeAvion typeAvion = new TypeAvion(res.getString("Nom"),res.getInt("nbPNCmin"),res.getInt("nbPNCmax"));
                typeAvions.add(typeAvion);
            }
            System.out.println("");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeAvions;
    }
    public static TypeAvion findTypeAvion(String nom){
        TypeAvion typeAvion;
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM typeavion WHERE nom ='"+nom+"'");
            res.next();
            typeAvion = new TypeAvion(res.getString("Nom"),res.getInt("nbPNCmin"),res.getInt("nbPNCmax"));
            return typeAvion;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addTypeAvion(TypeAvion typeAvion){
        try {
            Statement stt = con.createStatement();
           String querry = "INSERT into typeavion VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = this.con.prepareStatement(querry);
            preparedStmt.setString (1, typeAvion.getNom());
            preparedStmt.setInt    (2, typeAvion.getNbPNCmin());
            preparedStmt.setInt    (3, typeAvion.getNbPNCmax());
            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        String statement = new String();
        try {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM typeavion");
            while (res.next()) {
                statement += res.getString("Nom") + " " + res.getString("nbPNCmin") +"\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void deleteTypeAvion(TypeAvion typeAvion) {
        try {
            Statement stt = con.createStatement();
            String query = "DELETE FROM typeavion WHERE nom = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, typeAvion.getNom());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
