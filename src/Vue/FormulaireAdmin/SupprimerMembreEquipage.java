package Vue.FormulaireAdmin;

import Modèle.MembreEquipage;
import Modèle.TableauVols;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class SupprimerMembreEquipage extends JPanel {
    private JComboBox comboBoxSupMemEquip;
    private JButton supprimerMembreEquipageButton;
    private JLabel labelNom;
    private JPanel panelSupMemEquip;
    private TableauVols tableauVols;
    public SupprimerMembreEquipage() {
        supprimerMembreEquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembreEquipage membreEquipage = (MembreEquipage)comboBoxSupMemEquip.getSelectedItem();
                comboBoxSupMemEquip.removeItem(membreEquipage);
                tableauVols.deleteMembreEquipage(membreEquipage);
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("Supression membre d'équipage");
        ArrayList<MembreEquipage> membreEquipages = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < membreEquipages.size(); i++) {
            def.addElement(membreEquipages.get(i));
        }
        comboBoxSupMemEquip.setModel(def);
    }
}
