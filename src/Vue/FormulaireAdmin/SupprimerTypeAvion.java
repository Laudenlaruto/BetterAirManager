package Vue.FormulaireAdmin;

import Modèle.EquipageException;
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
    private JLabel labelError;
    private TableauVols tableauVols;
    public SupprimerTypeAvion() {
        supprimerTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxTypeAvion.getSelectedItem() !=null){
                    TypeAvion typeAvion = (TypeAvion) comboBoxTypeAvion.getSelectedItem();
                    boolean exist = false;//Vérification de l'intégrité de la base de données
                    for(int i =0 ; i<tableauVols.getTableauAvion().size();i++){
                        if(tableauVols.getTableauAvion().get(i).getTypeAvion().getNom().equals(typeAvion.getNom())){
                            exist = true;
                        }
                    }
                    for(int j=0;j<tableauVols.getTableauMembreEquipage().size();j++){
                        try {
                            if(tableauVols.getTableauMembreEquipage().get(j).isQualified(typeAvion)){
                                System.out.println("Qualified  ->" +tableauVols.getTableauMembreEquipage().get(j).getNom());
                                exist = true;
                            }
                        } catch (EquipageException e1) {
                            e1.printStackTrace();
                        }
                    }
                    if(!exist){
                        comboBoxTypeAvion.removeItem(typeAvion);
                        tableauVols.deleteTypeAvion(typeAvion);
                        labelError.setText("Supprimer");
                    }else{
                        labelError.setText("Type Avion associé à un avion ou un membre d'équipage est qualifier sur cet avion");//Supprimer avion pour supprimer type avion
                    }
                }
            }
        });


        supprimerTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
            }
        });
    }

    public void update() {
        labelError.setText("");
        tableauVols = new TableauVols("Suppresion Type Avion");
        ArrayList<TypeAvion> tabTypeAvion = tableauVols.getTablaeuTypeAvion();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def.addElement(tabTypeAvion.get(i));
        }
        comboBoxTypeAvion.setModel(def);

    }
}
