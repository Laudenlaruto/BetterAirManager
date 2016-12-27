package Vue.FormulaireAdmin;

import Modèle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 12/12/2016.
 */
public class QualificationMembreEquipage extends JPanel {

    private JComboBox comboBoxMemEqup;
    private JPanel panelQualif;
    private JCheckBox pasDeQualif1CheckBox;
    private JComboBox comboBoxQualif1;
    private JButton qualifierButton;
    private JComboBox comboBoxQualif2;
    private JCheckBox pasDeQualif2CheckBox;
    private JLabel labelError;
    private TableauVols tableauVols;
    public QualificationMembreEquipage() {



        qualifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembreEquipage membreEquipage = (MembreEquipage) comboBoxMemEqup.getSelectedItem();
                ArrayList<TypeAvion> typeAvions = new ArrayList<TypeAvion>();

                if (!pasDeQualif1CheckBox.isSelected()) {
                    if(!membreEquipage.qualifierSurUnVol((TypeAvion)comboBoxQualif1.getSelectedItem())){
                        typeAvions.add((TypeAvion) comboBoxQualif1.getModel().getSelectedItem());
                        comboBoxQualif1.getModel().setSelectedItem(comboBoxQualif1.getModel().getSelectedItem());
                    }else {
                        labelError.setText("Qualif 1 Membre equipage qualifier sur un un vol de ce type");
                    }

                }else {
                    comboBoxQualif1.getModel().setSelectedItem(null);
                }
                if (!pasDeQualif2CheckBox.isSelected()) {
                    if(!membreEquipage.qualifierSurUnVol((TypeAvion)comboBoxQualif2.getSelectedItem())) {
                        typeAvions.add((TypeAvion) comboBoxQualif2.getModel().getSelectedItem());
                        comboBoxQualif2.getModel().setSelectedItem(comboBoxQualif2.getModel().getSelectedItem());
                    }
                    else {
                        labelError.setText("Qualif 2 Membre equipage qualifier sur un un vol de ce type");
                    }
                }else {
                    comboBoxQualif2.getModel().setSelectedItem(null);
                }
                membreEquipage.setQualification(typeAvions);
                tableauVols.addQualification(membreEquipage);

            }
        });
        comboBoxMemEqup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembreEquipage membreEquipage = (MembreEquipage)comboBoxMemEqup.getSelectedItem();
                if(membreEquipage.getQualification().size()==0){
                    comboBoxQualif1.getModel().setSelectedItem(null);
                    comboBoxQualif2.getModel().setSelectedItem(null);
                    pasDeQualif1CheckBox.getModel().setSelected(true);
                    pasDeQualif2CheckBox.setSelected(true);
                }
                else if(membreEquipage.getQualification().size()==1) {
                    comboBoxQualif1.getModel().setSelectedItem(membreEquipage.getQualification().get(0));
                    comboBoxQualif2.getModel().setSelectedItem(null);
                    pasDeQualif1CheckBox.setSelected(false);
                    pasDeQualif2CheckBox.setSelected(true);
                }
                else if(membreEquipage.getQualification().size()==2) {
                    comboBoxQualif1.getModel().setSelectedItem(membreEquipage.getQualification().get(0));
                    pasDeQualif1CheckBox.setSelected(false);
                    comboBoxQualif2.getModel().setSelectedItem(membreEquipage.getQualification().get(1));
                    pasDeQualif2CheckBox.setSelected(false);
                }
            }
        });
        comboBoxQualif1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
            }
        });
        comboBoxQualif2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("Qualification");
        //Qualification 1
        ArrayList<TypeAvion> tabTypeAvion = tableauVols.getTablaeuTypeAvion();
        DefaultComboBoxModel<TypeAvion> def2 = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def2.addElement(tabTypeAvion.get(i));
        }
        def2.addElement(null);
        comboBoxQualif1.setModel(def2);

        //Qualification 2
        DefaultComboBoxModel def3 = new DefaultComboBoxModel();
        for (int i = 0; i < tabTypeAvion.size(); i++) {
            def3.addElement(tabTypeAvion.get(i));
        }
        def3.addElement(null);
        comboBoxQualif2.setModel(def3);

        ArrayList<MembreEquipage> membreEquipages = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel def = new DefaultComboBoxModel();
        for (int i = 0; i < membreEquipages.size(); i++) {
            def.addElement(membreEquipages.get(i));
        }
        comboBoxMemEqup.setModel(def);

        if(membreEquipages.get(0).getQualification().size()==0){
            comboBoxQualif1.setSelectedItem(null);
            pasDeQualif1CheckBox.setSelected(true);
            comboBoxQualif2.setSelectedItem(null);
            pasDeQualif2CheckBox.setSelected(true);
        }
        else if(membreEquipages.get(0).getQualification().size()==1) {
            comboBoxQualif1.getModel().setSelectedItem(membreEquipages.get(0).getQualification().get(0));
            pasDeQualif1CheckBox.setSelected(false);
            comboBoxQualif2.setSelectedItem(null);
            pasDeQualif2CheckBox.setSelected(true);
        }
        else if(membreEquipages.get(0).getQualification().size()==2) {
            comboBoxQualif1.getModel().setSelectedItem(membreEquipages.get(0).getQualification().get(0));
            comboBoxQualif2.getModel().setSelectedItem(membreEquipages.get(0).getQualification().get(1));
            pasDeQualif1CheckBox.setSelected(false);
            pasDeQualif2CheckBox.setSelected(false);
        }

    }
}
