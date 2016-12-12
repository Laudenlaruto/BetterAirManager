package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelAdmin extends JPanel{
    private JButton créerUnVolButton;
    private JButton supprimerUnVolButton;
    private JButton créerTypeAvionButton;
    private JButton créerUnVolButton1;
    private JButton qualifierUnMembreDButton;
    private JButton ajouterUnMembreDButton;
    private JButton supprimerUnMembreEquipageButton;
    private JButton supprimerUnTypeAvionButton;
    private JButton créerUnAvionButton;
    private JButton supprimerAvionButton;
    private JPanel panelAdmin;
    private JPanel panelBoutonUp;
    private JPanel panelBoutonDown;
    private JPanel panelMain;

    public PanelAdmin() {
        CardLayout card =(CardLayout)panelMain.getLayout();
        créerTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelMain,"CreationTypeAvion");
            }
        });
    }
}
