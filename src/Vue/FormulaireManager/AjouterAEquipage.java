package Vue.FormulaireManager;

import DataBase.TypeMembreEquipage;
import Modèle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AjouterAEquipage extends JPanel{
    private JComboBox comboBoxVol;
    private JComboBox comboBoxPNC;
    private JButton button1;
    private JPanel panelAjoutEquipage;
    private JLabel labelError;
    private TableauVols tableauVols;
    public AjouterAEquipage() {
        update();
        tableauVols = new TableauVols("AjoutEquipage");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vol vol = (Vol)comboBoxVol.getSelectedItem();
                if(vol.getAvion().getTypeAvion().getNbPNCmax()>vol.getEquipage().getPNC().size()){
                    vol.getEquipage().addPnc((PNC)comboBoxPNC.getSelectedItem());
                    tableauVols.addMembreEquipageAEquipage((MembreEquipage)comboBoxPNC.getSelectedItem(),(Vol)comboBoxVol.getSelectedItem());
                    comboBoxPNC.removeItem(comboBoxPNC.getSelectedItem());
                }else {
                    labelError.setText("Vol Complet");
                }

            }
        });
        comboBoxVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
                ArrayList<MembreEquipage> pncs = tableauVols.getTableauMembreEquipage();
                DefaultComboBoxModel<MembreEquipage> defPNC = new DefaultComboBoxModel<MembreEquipage>();
                for (int i= 0;i<pncs.size();i++){
                    Vol vol = (Vol)comboBoxVol.getSelectedItem();
                    MembreEquipage membreEquipage = pncs.get(i);
                    if(pncs.get(i).getMetier().equals(TypeMembreEquipage.PNC) && pncs.get(i).isQualified((Vol)comboBoxVol.getSelectedItem())&& !vol.membreEquipageInVol(membreEquipage) ){
                        defPNC.addElement(pncs.get(i));
                    }
                }
                comboBoxPNC.setModel(defPNC);
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("AjoutEquipage");
        ArrayList<Vol> vols = tableauVols.getTableauDeVols();
        ArrayList<MembreEquipage> pncs = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel<Vol> defVol = new DefaultComboBoxModel<Vol>();
        for(int i = 0;i<vols.size();i++){
            defVol.addElement(vols.get(i));
        }
        comboBoxVol.setModel(defVol);
        DefaultComboBoxModel<MembreEquipage> defPNC = new DefaultComboBoxModel<MembreEquipage>();

        for (int i= 0;i<pncs.size();i++){
            Vol vol = (Vol)comboBoxVol.getSelectedItem();
            MembreEquipage membreEquipage = pncs.get(i);
            if(pncs.get(i).getMetier().equals(TypeMembreEquipage.PNC) && pncs.get(i).isQualified((Vol)comboBoxVol.getSelectedItem())&& !vol.membreEquipageInVol(membreEquipage) ){
                defPNC.addElement(pncs.get(i));
            }
        }
        comboBoxPNC.setModel(defPNC);
    }
}
