package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben_s on 14/12/2016.
 */
public class PanelLogin extends JFrame {
    private JPanel panelLogin;
    private JButton buttonShowTab;
    private JButton adminButton;
    private JButton managerButton;
    private JButton equipageButton;
    private JPanel panelTab;
    private JPanel panelBouton;
    private JLabel Login;

    public PanelLogin() {
        setSize(new Dimension(900,500));
        setContentPane(panelLogin);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FrameLogin("Admin").setVisible(true);
            }
        });
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FrameLogin("Manager").setVisible(true);
            }
        });
        buttonShowTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PanelTableau().setVisible(true);
            }
        });
        equipageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FrameLogin("Equipage").setVisible(true);
            }
        });
    }
    public static void main(String args[]){
        PanelLogin p = new PanelLogin();

    }


}
