package Vue.FormulaireAdmin;

import DataBase.TypeMembreEquipage;
import Modèle.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Titan on 13/12/2016.
 */
public class CreerVol extends JPanel {
    private JPanel panelCreerVol;
    private JLabel labelNumeroDeVol;
    private JTextField textFieldNumeroDeVol;
    private JComboBox comboBoxSite;
    private JComboBox comboBoxDest;
    private JComboBox comboBoxAnnee;
    private JComboBox comboBoxMois;
    private JComboBox comboBoxJour;
    private JComboBox comboBoxAvion;
    private JComboBox comboBoxPilot;
    private JComboBox comboBoxCopilot;
    private JButton creerVolButton;
    private JComboBox comboBoxPNC;
    private JTable tablePNC;
    private JButton addPNCButton;
    private JScrollPane scrollPNC;
    private JLabel labelError;
    private JLabel labelPNCmin;
    private JLabel labelPNCmax;
    private TableauVols tableauVols;
    Aeroports aeroport;
    private int Annee = 2017;
    private int[] Mois = {1,2,3,4,5,6,7,8,9,10,11,12};
    private int[] Jour ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    private ArrayList<PNC> pncs;
    DefaultTableModel defaultTableModel;
    public CreerVol() {
        aeroport = new Aeroports();
        ArrayList<String> aeroports = aeroport.getNomAeroports();
        DefaultComboBoxModel<String> defSite = new DefaultComboBoxModel();
        DefaultComboBoxModel<String> defDest = new DefaultComboBoxModel();
        for (int i=0; i<aeroports.size();i++){
            defSite.addElement(aeroports.get(i));
            defDest.addElement(aeroports.get(i));
        }
        comboBoxSite.setModel(defSite);
        comboBoxDest.setModel(defDest);
        DefaultComboBoxModel defAnnee = new DefaultComboBoxModel();
        defAnnee.addElement(Annee);
        comboBoxAnnee.setModel(defAnnee);
        DefaultComboBoxModel defMois = new DefaultComboBoxModel();
        for (int i = 0;i<12;i++){
            defMois.addElement(Mois[i]);
        }
        comboBoxMois.setModel(defMois);
        DefaultComboBoxModel defJour = new DefaultComboBoxModel();
        for (int i =0;i<31;i++){
            defJour.addElement(Jour[i]);
        }
        comboBoxJour.setModel(defJour);


        creerVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!textFieldNumeroDeVol.getText().equals("") && pncs.size()!=0){
                    String date ="";
                    date+=comboBoxAnnee.getSelectedItem();
                    if((int)comboBoxMois.getSelectedItem()<10){
                        date+="0";
                    }
                    date+=comboBoxMois.getSelectedItem();
                    if((int)comboBoxJour.getSelectedItem()<10){
                        date+="0";
                    }
                    date+=comboBoxJour.getSelectedItem();
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    Date parsed = null;
                    try {
                        parsed = format.parse(date);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    java.sql.Date sql = new java.sql.Date(parsed.getTime());

                    Vol vol = new Vol(textFieldNumeroDeVol.getText(),(String)comboBoxSite.getSelectedItem(),(String)comboBoxDest.getSelectedItem(),sql,(Avion)comboBoxAvion.getSelectedItem());
                    Equipage equipage = new Equipage((Pilote)comboBoxPilot.getSelectedItem(),(CoPilote)comboBoxCopilot.getSelectedItem(),pncs,vol);
                    vol.setEquipage(equipage);
                    tableauVols.addVol(vol);
                    update();
                    labelError.setText("Vol créer");
                }else {
                    System.out.println("Erreur dans la création de vol");
                }
            }
        });
        comboBoxAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
                ArrayList<MembreEquipage> membreEquipages = tableauVols.getTableauMembreEquipage();
                DefaultComboBoxModel<MembreEquipage> defPilot = new DefaultComboBoxModel<>();
                DefaultComboBoxModel<MembreEquipage> defCoPilot = new DefaultComboBoxModel<>();
                DefaultComboBoxModel<MembreEquipage> defPNC = new DefaultComboBoxModel<>();
                for(int i = 0;i<membreEquipages.size();i++){

                    if (membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.PILOTE)&& membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                        defPilot.addElement(membreEquipages.get(i));

                    }else if(membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.COPILOTE) && membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                        defCoPilot.addElement(membreEquipages.get(i));
                    }
                    else if(membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.PNC) && membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                            defPNC.addElement(membreEquipages.get(i));

                    }
                }
                defaultTableModel.setRowCount(0);
                pncs = new ArrayList<PNC>();
                comboBoxPNC.setModel(defPNC);
                comboBoxPilot.setModel(defPilot);
                comboBoxCopilot.setModel(defCoPilot);
                Avion avionSelected = (Avion)comboBoxAvion.getSelectedItem();
                labelPNCmin.setText(avionSelected.getTypeAvion().getNbPNCmin()+"");
                labelPNCmax.setText(avionSelected.getTypeAvion().getNbPNCmax()+"");

            }
        });
        addPNCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Avion avion =(Avion)comboBoxAvion.getSelectedItem();
                TypeAvion typeAvion = avion.getTypeAvion();
                if(comboBoxPNC.getSelectedItem() !=null){
                    if (pncs.size()<typeAvion.getNbPNCmax()){
                        pncs.add((PNC)comboBoxPNC.getSelectedItem());
                        Object[] objs ={
                                pncs.get(pncs.size()-1).getNom(),
                                pncs.get(pncs.size()-1).getPrenom(),
                        };
                        defaultTableModel.addRow(objs);
                        comboBoxPNC.removeItem(pncs.get(pncs.size()-1));
                    }else{
                        labelError.setText("Vol Complet");
                    }
                }else{
                    labelError.setText("Plus de personne qualifier pour ce vol");
                }


            }
        });
    }

    public void update() {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nom");
        defaultTableModel.addColumn("Prenom");
        tablePNC = new JTable(defaultTableModel);
        this.scrollPNC.getViewport().add(tablePNC);
        tableauVols = new TableauVols("Creer Vol");
        pncs = new ArrayList<PNC>();
        ArrayList<Avion> avions = tableauVols.getTableauAvion();
        DefaultComboBoxModel<Avion> defAvion = new DefaultComboBoxModel<>();
        for(int i =0;i<avions.size();i++){
            defAvion.addElement(avions.get(i));
        }
        comboBoxAvion.setModel(defAvion);

        ArrayList<MembreEquipage> membreEquipages = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel<MembreEquipage> defPilot = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<MembreEquipage> defCoPilot = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<MembreEquipage> defPNC = new DefaultComboBoxModel<>();
        for(int i = 0;i<membreEquipages.size();i++){

            if (membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.PILOTE)&& membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                    defPilot.addElement(membreEquipages.get(i));

            }else if(membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.COPILOTE) && membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                    defCoPilot.addElement(membreEquipages.get(i));
            }
            else if(membreEquipages.get(i).getMetier().equals(TypeMembreEquipage.PNC) && membreEquipages.get(i).isQualified((Avion)comboBoxAvion.getSelectedItem())){
                defPNC.addElement(membreEquipages.get(i));
            }
        }
        comboBoxPNC.setModel(defPNC);
        comboBoxPilot.setModel(defPilot);
        comboBoxCopilot.setModel(defCoPilot);
        Avion avionSelected = (Avion)comboBoxAvion.getSelectedItem();
        labelPNCmin.setText(avionSelected.getTypeAvion().getNbPNCmin()+"");
        labelPNCmax.setText(avionSelected.getTypeAvion().getNbPNCmax()+"");




    }
}
