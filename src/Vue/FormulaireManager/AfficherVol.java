package Vue.FormulaireManager;

import Modèle.MembreEquipage;
import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AfficherVol extends JPanel{
    private JPanel panelAfficherVol;
    private JComboBox comboBoxVol;
    private JTable tableVol;
    private JScrollPane scrollVol;
    private TableauVols tableauVols;
    public AfficherVol() {
        tableauVols = new TableauVols("Panel Tableau");
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("NumVol");
        defaultTableModel.addColumn("Site");
        defaultTableModel.addColumn("Destiniation");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Ref Avion");
        defaultTableModel.addColumn("Type Avion");


        comboBoxVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vol vol = (Vol)comboBoxVol.getSelectedItem();
                Object[] objs = {
                        vol.getNumeroDeVol(),
                        vol.getSite(),
                        vol.getDestination(),
                        vol.getDate(),
                        vol.getAvion().getRef(),
                        vol.getAvion().getTypeAvion().getNom()
                };
                defaultTableModel.setRowCount(0);
                defaultTableModel.addRow(objs);
                tableVol = new JTable(defaultTableModel);
                scrollVol.getViewport().add(tableVol);
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("AjoutEquipage");
        ArrayList<Vol> vols = tableauVols.getTableauDeVols();
        ArrayList<MembreEquipage> pncs = tableauVols.getTableauMembreEquipage();
        DefaultComboBoxModel<Vol> defVol = new DefaultComboBoxModel<Vol>();
        for(int i = 0;i<vols.size();i++){
            defVol.addElement(vols.get(i));
        }
        comboBoxVol.setModel(defVol);}
}
