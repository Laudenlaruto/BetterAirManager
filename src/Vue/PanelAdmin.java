package Vue;

import Modèle.EquipageException;
import Vue.FormulaireAdmin.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben_s on 12/12/2016.
 */
public class PanelAdmin extends JFrame{
    private JButton créerUnVolButton;
    private JButton supprimerUnVolButton;
    private JButton créerTypeAvionButton;
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
    private SupprimerTypeAvion panelSupTypeAvion;
    private CreerAvion panelCreerAvion;
    private SupprimerAvion panelSupAvion;
    private AddMembreEquipage panelAddMembreEquipage;
    private SupprimerMembreEquipage panelSupMemEquip;
    private QualificationMembreEquipage panelQualification;
    private CreerVol panelCreerVol;
    private SupprimeVol panelSupVol;
    private CreationTypeAvion panelCreationAvion;
    private JButton deconnexionButton;

    public PanelAdmin() {
        setSize(new Dimension(1200,600));
        setContentPane(panelAdmin);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout card =(CardLayout)panelMain.getLayout();
        créerTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelMain,"CreationTypeAvion");
            }
        });
        supprimerUnTypeAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSupTypeAvion.update();
                card.show(panelMain,"SupprimerTypeAvion");
            }
        });
        créerUnAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCreerAvion.updateBox();
                card.show(panelMain,"CreerAvion");
            }
        });
        supprimerAvionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSupAvion.updateBox();
                card.show(panelMain,"SuppresionAvion");
            }
        });
        ajouterUnMembreDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAddMembreEquipage.update();
                card.show(panelMain,"AddMembreEquipage");
            }
        });
        supprimerUnMembreEquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSupMemEquip.update();
                card.show(panelMain,"SupMemEquip");
            }
        });
        qualifierUnMembreDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelQualification.update();
                card.show(panelMain,"Qualif");
            }
        });
        créerUnVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panelCreerVol.update();
                } catch (EquipageException e1) {
                    e1.printStackTrace();
                }
                card.show(panelMain,"CreerVol");
            }
        });
        supprimerUnVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSupVol.update();
                card.show(panelMain,"SupVol");
            }
        });
        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PanelLogin().setVisible(true);
            }
        });
    }
}
