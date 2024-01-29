package packageTP1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TestEmploye1 {

    private JPanel panel1;
    private JTextField champNom;
    private JTextField champNumero;
    private JTextField champSalaireHoraire;
    private JTextField champNbHeures;
    private JTextField champAnciennete;
    private JSpinner spinnerHeuresSup;
    private JPanel panelHaut;
    private JPanel panelBas;
    private JButton bouton;
    private JTextField champSalaireApresImpot;
    private JTextField champJoursVacances;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Salaire d'un employé");
        frame.setContentPane(new TestEmploye1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(520, 540);  // taille de la fenêtre
        frame.setLocationRelativeTo(null);  // la fenêtre est centrée par rapport à l'écran
        frame.setVisible(true);
    }

    public TestEmploye1()
    {
        SpinnerNumberModel snm = new SpinnerNumberModel(0,0,10,1);
        spinnerHeuresSup.setModel(snm);
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat df = new DecimalFormat ( "0.00");
                Employe unEmploye = new Employe ( champNom.getText(), champNumero.getText(), Double.parseDouble(champSalaireHoraire.getText()),
                        Double.parseDouble(champNbHeures.getText()), Integer.parseInt(champAnciennete.getText()));
              unEmploye.heuresSup((int)spinnerHeuresSup.getValue());
              champSalaireApresImpot.setText(df.format(unEmploye.salaireNetApresImpot()) + "$");
               champJoursVacances.setText(unEmploye.joursVacances() + " jours");
            }
        });
    }

}
