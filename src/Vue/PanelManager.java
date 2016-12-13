package Vue;

import Vue.FormulaireManager.AjouterAEquipage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelManager extends JPanel{
    private JButton ajouterMembreDÉquipageButton;
    private JButton retirerUnMembreDButton;
    private JButton afficherVolButton;
    private JPanel panelManager;
    private JPanel panelGestionManager;
    private JPanel panelCardManager;
    private AjouterAEquipage panelAjoutEquipage;

    public PanelManager() {
        CardLayout card =(CardLayout)panelCardManager.getLayout();
        ajouterMembreDÉquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAjoutEquipage.update();
                card.show(panelCardManager,"AjoutEquipage");
            }
        });
    }
}
