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
    private JLabel labelTtitre;
    private JPanel panelMain;
    private JScrollPane scrollPane;
    private JButton adminButton;
    private JButton managerButton;
    private JButton afficherTableauButton;
    private JButton membreEquipageButton;
    private JPanel interfaceBouton;
    private JPanel TitleName;
    private JPanel panelInterface;
    private CardLayout diapoInterface = new CardLayout();
    private PanelTableau panelTableau;
    private static TableauVols tableauVols;
    public PanelLogin(){
        setSize(new Dimension(700,700));
        setContentPane(panelMain);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableauVols = new TableauVols("Tableau De Vols");
        panelInterface.setLayout(diapoInterface);
        panelTableau = new PanelTableau(tableauVols);
        diapoInterface.addLayoutComponent(panelTableau,"TableauVols");
        panelInterface.setVisible(true);
        diapoInterface.show(panelInterface,"TableauVols");
        //TODO Faire cardLayout

        afficherTableauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                diapoInterface.show(panelInterface,"TableauVols");
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }



    public static void main(String args[]){
        PanelLogin p = new PanelLogin();

    }
}
