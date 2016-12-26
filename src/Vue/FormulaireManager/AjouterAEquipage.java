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
    private TableauVols tableauVols;
    public AjouterAEquipage() {
        update();
        tableauVols = new TableauVols("AjoutEquipage");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableauVols.addMembreEquipageAEquipage((MembreEquipage)comboBoxPNC.getSelectedItem(),(Vol)comboBoxVol.getSelectedItem());
                comboBoxPNC.removeItem(comboBoxPNC.getSelectedItem());
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
