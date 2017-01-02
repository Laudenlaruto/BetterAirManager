package Vue.FormulaireManager;

import DataBase.TypeMembreEquipage;
import Modèle.EquipageException;
import Modèle.MembreEquipage;
import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DeleteMembre extends JPanel {
    private JComboBox comboBoxVol;
    private JComboBox comboBoxPNC;
    private JButton supprimerButton;
    private JPanel panelSupMem;
    private TableauVols tableauVols;
    public DeleteMembre() {

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembreEquipage membreEquipage = (MembreEquipage)comboBoxPNC.getSelectedItem();
                Vol vol = (Vol)comboBoxVol.getSelectedItem();
                tableauVols.deleteMembreEquipageAEquipage(membreEquipage,vol);
                comboBoxPNC.removeItem(membreEquipage);
            }
        });
        comboBoxVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel<MembreEquipage> defPNC = new DefaultComboBoxModel<MembreEquipage>();
                ArrayList<MembreEquipage> pncs = tableauVols.getTableauMembreEquipage();
                for (int i= 0;i<pncs.size();i++){
                    Vol vol = (Vol)comboBoxVol.getSelectedItem();
                    MembreEquipage membreEquipage = pncs.get(i);
                    try {
                        if(pncs.get(i).getMetier().equals(TypeMembreEquipage.PNC) && pncs.get(i).isQualified((Vol)comboBoxVol.getSelectedItem())&& vol.membreEquipageInVol(membreEquipage) ){
                            defPNC.addElement(pncs.get(i));
                        }
                    } catch (EquipageException e1) {
                        e1.printStackTrace();
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
            try {
                if(pncs.get(i).getMetier().equals(TypeMembreEquipage.PNC) && pncs.get(i).isQualified((Vol)comboBoxVol.getSelectedItem())&& vol.membreEquipageInVol(membreEquipage) ){
                    defPNC.addElement(pncs.get(i));
                }
            } catch (EquipageException e) {
                e.printStackTrace();
            }
        }
        comboBoxPNC.setModel(defPNC);
    }
}
