package Vue.FormulaireAdmin;

import DataBase.TypeMembreEquipage;
import Modèle.*;
import Vue.PanelAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class AddMembreEquipage extends JPanel {
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JComboBox comboBoxMetier;
    private JPanel panelAddMemebreEquipage;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelMetier;
    private JButton addMembreDEquipageButton;
    private JComboBox comboBoxQualif1;
    private JComboBox comboBoxQualif2;
    private JLabel labelQualif1;
    private JLabel labelQualif2;
    private JCheckBox pasDeQualif1CheckBox;
    private JCheckBox pasDeQualif2CheckBox;
    private TableauVols tableauVols;
    public AddMembreEquipage() {

        DefaultComboBoxModel def = new DefaultComboBoxModel();
        def.addElement(TypeMembreEquipage.PILOTE);
        def.addElement(TypeMembreEquipage.COPILOTE);
        def.addElement(TypeMembreEquipage.PNC);
        comboBoxMetier.setModel(def);


        addMembreDEquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if(comboBoxMetier.getSelectedItem().equals(TypeMembreEquipage.PILOTE)){
                    Pilote pilote = new Pilote(textFieldNom.getText(),textFieldPrenom.getText());
                    if(!pasDeQualif1CheckBox.isSelected()){
                        pilote.addQualification((TypeAvion)comboBoxQualif1.getSelectedItem());
                    }
                    if(!pasDeQualif2CheckBox.isSelected()){
                        pilote.addQualification((TypeAvion)comboBoxQualif2.getSelectedItem());
                    }
                    tableauVols.addMembreEquipage(pilote);
                }else if(comboBoxMetier.getSelectedItem().equals(TypeMembreEquipage.COPILOTE)){
                    CoPilote copilote = new CoPilote(textFieldNom.getText(),textFieldPrenom.getText());
                    if(!pasDeQualif1CheckBox.isSelected()){
                        copilote.addQualification((TypeAvion)comboBoxQualif1.getSelectedItem());
                    }
                    if(!pasDeQualif2CheckBox.isSelected()){
                        copilote.addQualification((TypeAvion)comboBoxQualif2.getSelectedItem());
                    }
                    tableauVols.addMembreEquipage(copilote);
                }else{
                    PNC pnc = new PNC(textFieldNom.getText(),textFieldPrenom.getText());
                    if(!pasDeQualif1CheckBox.isSelected()){

                        pnc.addQualification((TypeAvion)comboBoxQualif1.getSelectedItem());
                    }
                    if(!pasDeQualif2CheckBox.isSelected()){
                        pnc.addQualification((TypeAvion)comboBoxQualif2.getSelectedItem());
                    }

                    tableauVols.addMembreEquipage(pnc);
                }
                } catch (EquipageException e1) {
                    e1.printStackTrace();
                } catch (InvariantBroken invariantBroken) {
                    invariantBroken.printStackTrace();
                }
                textFieldNom.setText("");
                textFieldPrenom.setText("");
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("AddMembreEquipage");
        //Qualification 1
        ArrayList<TypeAvion> tabTypeAvion = tableauVols.getTablaeuTypeAvion();
        DefaultComboBoxModel def2 = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def2.addElement(tabTypeAvion.get(i));
        }
        comboBoxQualif1.setModel(def2);
        //Qualification 12
        DefaultComboBoxModel def3 = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def3.addElement(tabTypeAvion.get(i));
        }
        comboBoxQualif2.setModel(def3);
    }
}
