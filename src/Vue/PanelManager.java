package Vue;

import Vue.FormulaireManager.AfficherVol;
import Vue.FormulaireManager.AjouterAEquipage;
import Vue.FormulaireManager.DeleteMembre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelManager extends JFrame{
    private JButton ajouterMembreDÉquipageButton;
    private JButton retirerUnMembreDButton;
    private JButton afficherVolButton;
    private JPanel panelManager;
    private JPanel panelGestionManager;
    private JPanel panelCardManager;
    private AjouterAEquipage panelAjoutEquipage;
    private DeleteMembre panelSupMem;
    private AfficherVol panelVol;
    private JButton buttonDeconnexion;

    public PanelManager() {
        setSize(new Dimension(1200,600));
        setContentPane(panelManager);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout card =(CardLayout)panelCardManager.getLayout();
        ajouterMembreDÉquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAjoutEquipage.update();
                card.show(panelCardManager,"AjoutEquipage");
            }
        });
        retirerUnMembreDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSupMem.update();
                card.show(panelCardManager,"SupMem");
            }
        });
        afficherVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelVol.update();
                card.show(panelCardManager,"AffVol");
            }
        });
        buttonDeconnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PanelLogin().setVisible(true);
            }
        });
    }
}
