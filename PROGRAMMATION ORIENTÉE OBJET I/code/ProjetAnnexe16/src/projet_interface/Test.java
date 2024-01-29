package projet_interface;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.JButton;
public class Test extends JFrame 
{
  JLabel jLabel1 = new JLabel();
    JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JRadioButton boutonAutomobile = new JRadioButton();
  JRadioButton boutonMotoneige = new JRadioButton();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField champValeur = new JTextField();
    JTextField champVille = new JTextField();
  JTextField champDate = new JTextField();
  JTextField champModele = new JTextField();
  JTextField champNumero = new JTextField();
  JTextField champCylindree = new JTextField();
  JTextField champReponse = new JTextField();
    ButtonGroup bg = new ButtonGroup ();
  private JButton boutonVider = new JButton();
    private JButton boutonAssurable = new JButton();
    private JTextField champAssurable = new JTextField();
  DecimalFormat df = new DecimalFormat ( "0.00$");

    public Test()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(408, 472));
    jLabel1.setText("Assurances Sélectives Inc");
    jLabel1.setBounds(new Rectangle(5, 10, 380, 35));
    jLabel1.setFont(new Font("Dialog", 0, 14));
    jLabel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel1.setBounds(new Rectangle(5, 55, 380, 90));
    jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    jPanel1.setLayout(null);
    jPanel2.setBounds(new Rectangle(205, 10, 10, 10));
    jPanel3.setBounds(new Rectangle(5, 155, 380, 150));
    jPanel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    jPanel3.setLayout(null);
    jPanel4.setBounds(new Rectangle(5, 320, 380, 110));
    jPanel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    jPanel4.setLayout(null);
    jLabel2.setText("PROPRIETAIRE");
    jLabel2.setBounds(new Rectangle(15, 5, 90, 20));
    jLabel4.setText("ville d\'origine");
    jLabel4.setBounds(new Rectangle(25, 35, 135, 20));
    jLabel5.setText("date de naissance ( JJ/MM/AAAA)");
    jLabel5.setBounds(new Rectangle(25, 60, 260, 25));
    jLabel6.setText("VEHICULE");
    jLabel6.setBounds(new Rectangle(15, 5, 70, 20));
    boutonAutomobile.setText("Automobile");
    boutonAutomobile.setBounds(new Rectangle(90, 5, 140, 20));
    boutonMotoneige.setText("Motoneige");
    boutonMotoneige.setBounds(new Rectangle(240, 5, 115, 20));
    jLabel7.setText("valeur du véhicule");
    jLabel7.setBounds(new Rectangle(90, 30, 120, 25));
    jLabel8.setText("année-modèle");
    jLabel8.setBounds(new Rectangle(90, 60, 130, 25));
    jLabel9.setText("numero de plaque");
    jLabel9.setBounds(new Rectangle(90, 85, 120, 30));
    jLabel10.setText("cylindrée");
    jLabel10.setBounds(new Rectangle(90, 115, 125, 25));
    champValeur.setBounds(new Rectangle(220, 30, 135, 25));
        champVille.setBounds(new Rectangle(260, 30, 95, 25));
    champDate.setBounds(new Rectangle(260, 60, 95, 25));
    champModele.setBounds(new Rectangle(220, 60, 135, 25));
    champNumero.setBounds(new Rectangle(220, 90, 135, 25));
    champCylindree.setBounds(new Rectangle(220, 120, 135, 25));
    champReponse.setBounds(new Rectangle(255, 40, 120, 25));
        champReponse.setEditable(false);
        boutonVider.setText("Vider");
    boutonVider.setBounds(new Rectangle(140, 70, 95, 30));
        jPanel1.add(champDate, null);
    jPanel1.add(champVille, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jPanel2, null);
    jPanel3.add(champCylindree, null);
    jPanel3.add(champNumero, null);
    jPanel3.add(champModele, null);
    jPanel3.add(champValeur, null);
    jPanel3.add(jLabel10, null);
    jPanel3.add(jLabel9, null);
    jPanel3.add(jLabel8, null);
    jPanel3.add(jLabel7, null);
    jPanel3.add(boutonMotoneige, null);
    jPanel3.add(boutonAutomobile, null);
    jPanel3.add(jLabel6, null);
        jPanel4.add(champAssurable, null);
        jPanel4.add(boutonAssurable, null);
        jPanel4.add(boutonVider, null);
        jPanel4.add(champReponse, null);
        this.getContentPane().add(jPanel4, null);
    this.getContentPane().add(jPanel3, null);
    this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jLabel1, null);
        boutonAssurable.setText("est-ce assurable ?");
        boutonAssurable.setBounds(new Rectangle(10, 10, 235, 25));
        champAssurable.setBounds(new Rectangle(255, 10, 120, 25));
        champAssurable.setEditable(false);
        bg.add ( boutonAutomobile);
      bg.add( boutonMotoneige );
     
    // création de l'écouteur
    GestionnaireEvenement ge = new GestionnaireEvenement();
    // ajouter l'écouteur au boutonReponse
        boutonVider.addActionListener(ge);
    boutonAssurable.addActionListener(ge);
    boutonAutomobile.addActionListener(ge);
    boutonMotoneige.addActionListener(ge);
    


    }



  private class GestionnaireEvenement implements ActionListener
  {

  public void actionPerformed(ActionEvent e)
  {
  // source est le bouton vider
  if ( e.getSource() == boutonVider )
  {
    champCylindree.setText("");
    champDate.setText ( "");
    champModele.setText("");
    champNumero.setText("");
    champReponse.setText("");
    champValeur.setText("");
    champVille.setText("");
    champAssurable.setText("");
   
  }
  
  else if ( e.getSource() == boutonAssurable) {
      
      // récupérer les sous-chaines
      String dateAnn = champDate.getText();
      String jj = dateAnn.substring(0,2);
      String mm = dateAnn.substring(3,5);
      String aaaa = dateAnn.substring(6);
      
      // transtyper en int
      
      int j = Integer.parseInt(jj);
      int m = Integer.parseInt(mm);
      int a = Integer.parseInt(aaaa);
      
      // créer l'objet GregorianCalendar
      GregorianCalendar anniv = new GregorianCalendar ( a,m-1,j);
      
      // créer le propriétaire
      
      Proprietaire p = new Proprietaire ( champVille.getText(), anniv );
      
      if ( boutonAutomobile.isSelected())
        {
        champCylindree.setEditable(false);
        Automobile auto = new Automobile ( Double.parseDouble(champValeur.getText()), Integer.parseInt ( champModele.getText()), p, champNumero.getText());
        if ( auto.estAssurable())
          {
           champReponse.setText(df.format(auto.coutAssurance()) );
           champAssurable.setText("oui");
          }
        else 
            {
            champAssurable.setText("non");
            }
        }
      
      else
        {
        // if motoneige
        champCylindree.setEditable(true);
        Motoneige moto = new Motoneige ( Double.parseDouble(champValeur.getText()), Integer.parseInt ( champModele.getText()), p, champNumero.getText(), Integer.parseInt(champCylindree.getText()));
            if ( moto.estAssurable())
              {
               champReponse.setText(df.format(moto.coutAssurance() ));
               champAssurable.setText("oui");
              }
            else 
                {
                champAssurable.setText("non");
                }
        }
      }
  else if ( e.getSource() == boutonAutomobile) {
      champCylindree.setEditable(false);
  }
  
  else if ( e.getSource() == boutonMotoneige) {
      champCylindree.setEditable(true);
  }
      
      
  }

  
}
  
    public static void main ( String [] args )
    {
    Test un = new Test ();
    un.setVisible ( true );
    un.setDefaultCloseOperation ( EXIT_ON_CLOSE );
    }

}