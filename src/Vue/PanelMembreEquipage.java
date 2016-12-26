package Vue;

import Modèle.MembreEquipage;
import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelMembreEquipage extends JFrame {
    private JPanel panelMembreEquipage;
    private JScrollPane membreEquipeScroll;
    private JTable tableMembreEquipage;
    private JButton deconnexionButton;
    private TableauVols tableauVols;
    public PanelMembreEquipage(String nom) {
        update();
        setSize(new Dimension(1200,600));
        setContentPane(panelMembreEquipage);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("NumVol");
        defaultTableModel.addColumn("Site");
        defaultTableModel.addColumn("Destiniation");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Ref Avion");
        defaultTableModel.addColumn("Type Avion");
        defaultTableModel.setRowCount(0);
        ArrayList<Vol> vols = tableauVols.findVolByMembreEquipage(nom);
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
        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PanelLogin().setVisible(true);
            }
        });
    }



    public void update() {tableauVols = new TableauVols("PanelMembreEquipage");
    }
}
