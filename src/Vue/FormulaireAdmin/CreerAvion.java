package Vue.FormulaireAdmin;

import Modèle.Avion;
import Modèle.TableauVols;
import Modèle.TypeAvion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class CreerAvion extends JPanel{
    private JComboBox comboBoxCreerAvion;
    private JTextField textFieldRef;
    private JPanel panelCreerAvion;
    private JLabel labelTypeAvion;
    private JLabel labelRef;
    private JButton buttonCreerAvion;
    private JLabel labelError;
    private TableauVols tableauVols;
    public CreerAvion() {

        buttonCreerAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textFieldRef.getText().equals("")){
                    TypeAvion typeAvion = (TypeAvion)comboBoxCreerAvion.getSelectedItem();
                    Avion avion = new Avion(typeAvion,textFieldRef.getText());
                    tableauVols.addAvion(avion);
                    textFieldRef.setText("");
                    labelError.setText("Avion créer");
                }else{
                    labelError.setText("Il y a des champs vide");
                }
            }
        });
    }

    public void updateBox() {
        labelError.setText("");
        tableauVols = new TableauVols("Suppresion Type Avion");
        ArrayList<TypeAvion> tabTypeAvion = tableauVols.getTablaeuTypeAvion();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def.addElement(tabTypeAvion.get(i));
        }
        comboBoxCreerAvion.setModel(def);
    }
}
