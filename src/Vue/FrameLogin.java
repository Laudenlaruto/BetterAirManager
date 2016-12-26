package Vue;

import DataBase.DBMembreEquipage;
import Modèle.MembreEquipage;
import Modèle.TableauVols;
import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by ben_s on 26/12/2016.
 */
public class FrameLogin extends JFrame{
    private JPanel panelLogin;
    private JTextField textFieldUser;
    private JLabel labelUser;
    private JTextField textFieldPassword;
    private JLabel titreLogin;
    private JButton connexionButton;
    private JLabel labelError;
    private JButton retourButton;

    public FrameLogin(String id){
        setSize(new Dimension(400,300));
        setContentPane(panelLogin);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.titreLogin.setText(id);
        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id.equals("Admin")){
                    if(textFieldUser.getText().equals("admin")&&textFieldPassword.getText().equals("admin")){
                        dispose();
                        new PanelAdmin().setVisible(true);
                    }
                    else {
                        labelError.setText("Username ou password erroné");
                    }
                }
                else if(id.equals("Manager")){
                    if(textFieldUser.getText().equals("manager")&&textFieldPassword.getText().equals("manager")){
                        dispose();
                        new PanelManager().setVisible(true);
                    }
                    else {
                        labelError.setText("Username ou password erroné");
                    }
                }
                else if(id.equals("Equipage")){
                    TableauVols tableauVols = new TableauVols("Equipage");
                    ArrayList<MembreEquipage> membreEquipages= tableauVols.getTableauMembreEquipage();
                    for (int i=0; i<membreEquipages.size();i++){
                        if(membreEquipages.get(i).getNom().equals(textFieldUser.getText())){
                            dispose();
                            new PanelMembreEquipage(textFieldUser.getText()).setVisible(true);
                        }
                        else {
                            labelError.setText("Username ou password erroné");
                        }
                    }
                }
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PanelLogin().setVisible(true);
            }
        });
    }
}
