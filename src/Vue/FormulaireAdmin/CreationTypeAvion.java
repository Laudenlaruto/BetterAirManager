package Vue.FormulaireAdmin;

import Modèle.TableauVols;
import Modèle.TypeAvion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben_s on 12/12/2016.
 */
public class CreationTypeAvion extends JPanel{
    private JTextField textFieldNom;
    private JTextField textFieldPNCmin;
    private JTextField textFieldPNCmax;
    private JLabel labelNom;
    private JLabel PNCmin;
    private JLabel PNCmax;
    private JPanel panelCreationTypeAvion;
    private JButton validerEtEnregistrerButton;
    private JLabel labelError;

    public CreationTypeAvion() {
        TableauVols tableauVols = new TableauVols("CreationTypeAvion");
        validerEtEnregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldPNCmax.getText().equals("")&&!textFieldPNCmin.getText().equals("")&&!textFieldNom.getText().equals("")){
                    tableauVols.addTypeAvion(new TypeAvion(
                            textFieldNom.getText(),
                            Integer.parseInt(textFieldPNCmin.getText()),
                            Integer.parseInt(textFieldPNCmax.getText())));
                    textFieldNom.setText("");
                    textFieldPNCmin.setText("");
                    textFieldPNCmax.setText("");
                }else{
                    labelError.setText("Il y a des champs vides");
                }
            }

        });
    }
}
