package Vue;

import Modèle.TableauVols;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Titan on 12/12/2016.
 */
public class PanelLogin extends JFrame{
    private JLabel labelTitre;
    private JPanel panelMain;
    private JButton adminButton;
    private JButton managerButton;
    private JButton afficherTableauButton;
    private JButton membreEquipageButton;
    private JPanel interfaceBouton;
    private JPanel TitleName;
    private JPanel panelInterface;
    private static TableauVols tableauVols;
    public PanelLogin(){
        setSize(new Dimension(700,700));
        setContentPane(panelMain);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout card =(CardLayout)panelInterface.getLayout();
        tableauVols = new TableauVols("Tableau De Vols");


        afficherTableauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                card.show(panelInterface,"PanelTab");
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelInterface,"PanelAdmin");
            }
        });
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelInterface,"PanelManager");
            }
        });
        membreEquipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelInterface,"PanelMembreEquipage");
            }
        });
    }



    public static void main(String args[]){
        PanelLogin p = new PanelLogin();

    }


}
