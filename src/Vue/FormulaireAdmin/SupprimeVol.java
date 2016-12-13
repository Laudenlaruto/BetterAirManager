package Vue.FormulaireAdmin;

import Modèle.TableauVols;
import Modèle.Vol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Titan on 13/12/2016.
 */
public class SupprimeVol extends JPanel{
    private JComboBox comboBoxSupVol;
    private JButton supprimerVolButton;
    private JPanel panelSupVol;
    private TableauVols tableauVols;
    public SupprimeVol() {
        tableauVols = new TableauVols("Sup Vol");
        ArrayList<Vol> vols = tableauVols.getTableauDeVols();
        DefaultComboBoxModel<Vol> defVol = new DefaultComboBoxModel();
        for(int i = 0;i<vols.size();i++){
            defVol.addElement(vols.get(i));
            comboBoxSupVol.setModel(defVol);
        }
        supprimerVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableauVols.deleteVol((Vol)comboBoxSupVol.getSelectedItem());
                comboBoxSupVol.removeItem((Vol)comboBoxSupVol.getSelectedItem());
            }
        });
    }

    public void update() {
        tableauVols = new TableauVols("Sup Vol");
    }
}
