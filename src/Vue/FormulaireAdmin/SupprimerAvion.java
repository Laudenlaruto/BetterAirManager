package Vue.FormulaireAdmin;

import Modèle.Avion;
import Modèle.TableauVols;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class SupprimerAvion extends JPanel {

    private JComboBox comboBoxAvion;
    private JButton supprimerAvionButton;
    private JPanel panelSupAvion;
    private TableauVols tableauVols;
    public SupprimerAvion() {

        supprimerAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Avion avion = (Avion)comboBoxAvion.getSelectedItem();
                comboBoxAvion.removeItem(avion);
                tableauVols.deleteAvion(avion);
            }
        });
    }
    public void updateBox() {
        tableauVols = new TableauVols("Suppresion Type Avion");
        ArrayList<Avion> tabTypeAvion = tableauVols.getTableauAvion();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def.addElement(tabTypeAvion.get(i));
        }
        comboBoxAvion.setModel(def);

    }
}
