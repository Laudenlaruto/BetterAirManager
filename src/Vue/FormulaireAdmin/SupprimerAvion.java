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
    private JLabel labelError;
    private TableauVols tableauVols;
    public SupprimerAvion() {

        supprimerAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Avion avion = (Avion)comboBoxAvion.getSelectedItem();
                boolean exist = false;//Vérification de l'intégrité de la base de données
                for (int i =0; i< tableauVols.getTableauDeVols().size();i++){
                    if(tableauVols.getTableauDeVols().get(i).getAvion().getRef().equals(avion.getRef())){
                        exist = true;
                    }
                }
                if(!exist){
                    comboBoxAvion.removeItem(avion);
                    tableauVols.deleteAvion(avion);
                    labelError.setText("Supprimer");
                }else {
                    labelError.setText("Avion utiliser dans un vol");
                }

            }
        });
        comboBoxAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
            }
        });
    }
    public void updateBox() {
        labelError.setText("");
        tableauVols = new TableauVols("Suppresion Type Avion");
        ArrayList<Avion> tabTypeAvion = tableauVols.getTableauAvion();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def.addElement(tabTypeAvion.get(i));
        }
        comboBoxAvion.setModel(def);

    }
}
