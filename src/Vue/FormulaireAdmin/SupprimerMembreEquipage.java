package Vue.FormulaireAdmin;

import DataBase.DBMembreEquipage;
import Modèle.MembreEquipage;
import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class  SupprimerMembreEquipage extends JPanel {
    private JComboBox comboBoxSupMemEquip;
    private JButton supprimerMembreEquipageButton;
    private JLabel labelNom;
    private JPanel panelSupMemEquip;
    private JLabel labelError;
    private TableauVols tableauVols;
    public SupprimerMembreEquipage() {
        supprimerMembreEquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean exist = false;//Vérification de l'intégrité de la base de données
                MembreEquipage membreEquipage = (MembreEquipage)comboBoxSupMemEquip.getSelectedItem();

                if(!DBMembreEquipage.membreEquipageActife(membreEquipage.getNom())){
                    comboBoxSupMemEquip.removeItem(membreEquipage);
                    tableauVols.deleteMembreEquipage(membreEquipage);
                    labelError.setText("Supprimer");

                }else {
                    labelError.setText("Membre equipage dans un Vol");
                }



            }
        });
        comboBoxSupMemEquip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
            }
        });
    }

    public void update() {
        labelError.setText("");
        tableauVols = new TableauVols("Supression membre d'équipage");
        ArrayList<MembreEquipage> membreEquipages = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < membreEquipages.size(); i++) {
            def.addElement(membreEquipages.get(i));
        }
        comboBoxSupMemEquip.setModel(def);
    }
}
