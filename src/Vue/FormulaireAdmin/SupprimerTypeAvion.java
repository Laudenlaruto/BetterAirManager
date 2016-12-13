package Vue.FormulaireAdmin;

import Modèle.TableauVols;
import Modèle.TypeAvion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben_s on 12/12/2016.
 */
public class SupprimerTypeAvion extends JPanel {
    private JComboBox comboBoxTypeAvion;
    private JButton supprimerTypeAvionButton;
    private JPanel panelSuppresionTypeAvion;
    private TableauVols tableauVols;
    public SupprimerTypeAvion() {
        supprimerTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TypeAvion typeAvion = (TypeAvion) comboBoxTypeAvion.getSelectedItem();
                comboBoxTypeAvion.removeItem(typeAvion);
                tableauVols.deleteTypeAvion(typeAvion);

            }
        });


    }

    public void updateBox() {
        tableauVols = new TableauVols("Suppresion Type Avion");
        ArrayList<TypeAvion> tabTypeAvion = tableauVols.getTablaeuTypeAvion();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def.addElement(tabTypeAvion.get(i));
        }
        comboBoxTypeAvion.setModel(def);

    }
}
