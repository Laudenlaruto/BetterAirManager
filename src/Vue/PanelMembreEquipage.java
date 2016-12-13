package Vue;

import Modèle.MembreEquipage;
import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelMembreEquipage extends JPanel {
    private JTextField textFieldNom;
    private JPanel panelMembreEquipage;
    private JPanel panelMembreEquipageUp;
    private JLabel Nom;
    private JButton chercherButton;
    private JScrollPane membreEquipeScroll;
    private JTable tableMembreEquipage;
    private TableauVols tableauVols;
    public PanelMembreEquipage() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("NumVol");
        defaultTableModel.addColumn("Site");
        defaultTableModel.addColumn("Destiniation");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Ref Avion");
        defaultTableModel.addColumn("Type Avion");


        chercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultTableModel.setRowCount(0);
                ArrayList<Vol> vols = tableauVols.findVolByMembreEquipage(textFieldNom.getText());
                for (int i =0; i<vols.size();i++){
                    Object objs[] = {
                            vols.get(i).getNumeroDeVol(),
                            vols.get(i).getSite(),
                            vols.get(i).getDestination(),
                            vols.get(i).getDate(),
                            vols.get(i).getAvion().getRef(),
                            vols.get(i).getAvion().getTypeAvion().getNom()};
                    defaultTableModel.addRow(objs);
                    }
                    tableMembreEquipage = new JTable(defaultTableModel);
                    membreEquipeScroll.getViewport().add(tableMembreEquipage);
                }


        });
    }

    public void update() {tableauVols = new TableauVols("PanelMembreEquipage");
    }
}
