package Vue;

import Modèle.TableauVols;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelTableau extends JPanel{
    private JPanel panelTableau;
    private JTable table1;
    private JScrollPane scrollPane;
    private TableauVols tableauVols;

    public PanelTableau(){

    }

    public void update() {
        tableauVols = new TableauVols("Panel Tableau");
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("NumVol");
        defaultTableModel.addColumn("Site");
        defaultTableModel.addColumn("Destiniation");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Ref Avion");
        defaultTableModel.addColumn("Type Avion");
        defaultTableModel.addColumn("Nom");
        defaultTableModel.addColumn("Prenom");
        defaultTableModel.addColumn("Metier");

        for(int i =0 ; i<tableauVols.getTableauDeVols().size();i++){

            int nbDePersonneDansEquipage=0;

            if(!tableauVols.getTableauDeVols().get(i).equipageIsSet()) {
                if (!tableauVols.getTableauDeVols().get(i).getEquipage().PNCIsSet()) {
                    nbDePersonneDansEquipage += tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().size();
                }
                if (!tableauVols.getTableauDeVols().get(i).getEquipage().pilotIsSet()) {
                    nbDePersonneDansEquipage += 1;
                }
                if (!tableauVols.getTableauDeVols().get(i).getEquipage().coPilotIsSet()) {
                    nbDePersonneDansEquipage += 1;
                }

                for (int j = 0; j < nbDePersonneDansEquipage; j++) {
                    if (j == nbDePersonneDansEquipage-1) {

                        Object[] objs = {
                                tableauVols.getTableauDeVols().get(i).getNumeroDeVol(),
                                tableauVols.getTableauDeVols().get(i).getSite(),
                                tableauVols.getTableauDeVols().get(i).getDestination(),
                                tableauVols.getTableauDeVols().get(i).getDate(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getRef(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPilote().getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPilote().getPrenom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPilote().getMetier()
                        };
                        defaultTableModel.addRow(objs);

                    } else if (j == nbDePersonneDansEquipage-2) {

                        Object[] objs = {
                                tableauVols.getTableauDeVols().get(i).getNumeroDeVol(),
                                tableauVols.getTableauDeVols().get(i).getSite(),
                                tableauVols.getTableauDeVols().get(i).getDestination(),
                                tableauVols.getTableauDeVols().get(i).getDate(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getRef(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().getPrenom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getCoPilote().getMetier()
                        };
                        defaultTableModel.addRow(objs);
                    } else {

                        Object[] objs = {
                                tableauVols.getTableauDeVols().get(i).getNumeroDeVol(),
                                tableauVols.getTableauDeVols().get(i).getSite(),
                                tableauVols.getTableauDeVols().get(i).getDestination(),
                                tableauVols.getTableauDeVols().get(i).getDate(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getRef(),
                                tableauVols.getTableauDeVols().get(i).getAvion().getTypeAvion().getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().get(j).getNom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().get(j).getPrenom(),
                                tableauVols.getTableauDeVols().get(i).getEquipage().getPNC().get(j).getMetier()};
                        defaultTableModel.addRow(objs);

                    }

                }
            }

        }
        table1 = new JTable(defaultTableModel);
        this.scrollPane.getViewport().add(table1);
    }
}
