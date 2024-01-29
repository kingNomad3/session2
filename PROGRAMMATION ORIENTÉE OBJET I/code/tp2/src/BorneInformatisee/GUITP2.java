package BorneInformatisee;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class GUITP2 {
    private JPanel panel1;
    private JLabel labelLogo;
    private JPanel panelNumeros;
    private JPanel panelDroite;
    private JPanel panelComptant;
    private JLabel champMessage;
    private JButton bouton25;
    private JButton bouton100;
    private JButton bouton200;
    private JPanel panelCredit;

    private JButton bouton25Credit;
    private JButton boutonMaxCredit;
    private JButton boutonOk;
    private JTextArea zoneRecu;
    private JButton boutonRapport;
    private JFormattedTextField champNumeroCarte;
    private JFormattedTextField champDateExp;
    private JButton boutonValiderDateExp;


    private EcouteurNumero ecouteurNumero;
    private EcouteurCarteCredit ecouteurCarteCredit;
    private EcouteurMonnaie ecouteurMonnaie;
    private EcouteurControles ecouteurControles;
    private EcouteurEntree ecouteurEntree;

    // variables utiles pour vous

    String place =""; //place de stationnement choisie
    Borne borne; // borne à créer dans le constructeur
    //pt une carte de credit
    Piece piece;
    CarteCredit carte;
    Transaction Trans;
    double valeurCourante;
    double MontantAPayer;
    double piece25;
    double piece1;
    double piece2;
    String numeroCarte ;
    String expirationCC ;
    double soldeCC;
    double nValeurCourant;
    double montantBorne;
    double montantMaximum;


    public GUITP2() throws ParseException {


        labelLogo.setIcon(new ImageIcon("logo.png"));
        boutonValiderDateExp.setMargin(new Insets(10,0, 10, 0));
        //Création des écouteurs
        ecouteurNumero = new EcouteurNumero();
        ecouteurCarteCredit = new EcouteurCarteCredit();
        ecouteurMonnaie = new EcouteurMonnaie();
        ecouteurControles = new EcouteurControles();
        ecouteurEntree = new EcouteurEntree();


        // panelNumeros avec la grille
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();


        panelNumeros.setLayout(gl);
        c.fill = GridBagConstraints.BOTH;
        c.weightx =1;
        c.weighty=1;
        for ( int i = 0; i <15 ; i++)
        {
            JButton temp = new JButton();
            temp.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
            temp.setForeground(new Color(0,174,239));
            temp.addActionListener(ecouteurNumero);
            if  ( i ==0 )
                temp.setText("A");

            else if ( i ==1 )
                temp.setText("B");
            else if ( i==2 )
               temp.setText("C");

            else if ( i == 3 ) {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText("D");
            }

            else if ( i <=6)
            {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            }
            else if ( i==7)
            {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText(String.valueOf(i-4));
            }
            else if ( i <=10)
            {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            }
            else if ( i==11)
            {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText(String.valueOf(i-4));
            }
            else if ( i <=13)
            {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            }
            else if ( i==14)
            {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText("entrée");
                temp.removeActionListener(ecouteurNumero);
                temp.addActionListener(ecouteurEntree);
            }
            gl.setConstraints(temp, c );
            panelNumeros.add( temp);




        }
        // inscrire les sources à l'écouteur
        bouton25.addActionListener(ecouteurMonnaie);
        bouton100.addActionListener(ecouteurMonnaie);
        bouton200.addActionListener(ecouteurMonnaie);

        bouton25Credit.addActionListener(ecouteurCarteCredit);
        boutonMaxCredit.addActionListener(ecouteurCarteCredit);
        boutonValiderDateExp.addActionListener(ecouteurCarteCredit);
        boutonOk.addActionListener(ecouteurControles);
        boutonRapport.addActionListener(ecouteurControles);

        //créer objet Borne
        borne =  new Borne(); //demandeer pour le numero de borne
        if (borne.estHeureValide()) {
            champMessage.setText("Tapper le numero de stationnement");
        }
        else{
                champMessage.setText("Stationnement gratuit");
        }


    }

    //pas besoin de savoir
    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            champNumeroCarte = new JFormattedTextField(new MaskFormatter("#### #### #### ####"));
            champDateExp = new JFormattedTextField(new MaskFormatter("##/##"));
        }
        catch ( ParseException pe)
        {
            pe.printStackTrace();
        }
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
    private class EcouteurNumero implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            //lettre ou chiffre du bouton qu'on a cliqué dessus
           String lettreChiffre = ((JButton)e.getSource()).getText();
           boutonNumeroLettre_actionPerformed( lettreChiffre);


        }
    }

    private class EcouteurEntree implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boutonEntree_actionPerformed();
        }
    }

    private class EcouteurMonnaie implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() == bouton25)
                bouton25_actionPerformed();
            else if ( e.getSource()==bouton100)
                bouton100_actionPerformed();
            else if ( e.getSource() == bouton200)
                bouton200_actionPerformed();
        }
    }

    private class EcouteurCarteCredit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

             if ( e.getSource() == bouton25Credit)
                bouton25Credit_actionPerformed();
            else if (e.getSource() == boutonMaxCredit)
                boutonMaxCredit_actionPerformed();
            else if ( e.getSource() == boutonValiderDateExp)
                boutonValiderDateExp_actionPerformed();
        }
    }

    private class EcouteurControles implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() == boutonOk)
                boutonOK_actionPerformed();
            else if ( e.getSource() == boutonRapport)
                boutonRapport_actionPerformed();
        }
    }

//pas besoin de savoir



    private void bouton25_actionPerformed() {
        //créer une nouvelle pièce
        Piece piece = new Piece();
        //initie la piece à 25 sous
//        piece25 = piece.getVINGT_CINQ_SOU();
//        // prend la valeur courrente qui est 0.0 si c'est la premiere fois et l'addition
//        valeurCourante = Double.parseDouble(champMessage.getText());
//        MontantAPayer = borne.calculerMontantAPayer(piece25);
//
//        //verifie si la valeur est plus petit ou égal à 8 et additionne les pièces
//        if(valeurCourante != Double.parseDouble(borne.MONTANT_MAXIMUM)) {
//            valeurCourante += piece25;
//            valeurCourante += MontantAPayer;
//            champMessage.setText(String.valueOf(valeurCourante));
//        }else if(valeurCourante > Double.parseDouble(borne.MONTANT_MAXIMUM)){
//            champMessage.setText(String.valueOf(borne.MONTANT_MAXIMUM));
//        }

         valeurCourante = Double.parseDouble(champMessage.getText());
         piece25 = piece.getVINGT_CINQ_SOU();
        montantMaximum = Double.parseDouble(borne.MONTANT_MAXIMUM);

        // appel la fonction afin d'additionner les pièces
        nValeurCourant = borne.valeurCourante(valeurCourante, piece25, montantMaximum);
        champMessage.setText(String.valueOf(nValeurCourant));
    }


        private void bouton100_actionPerformed() {
            //créer une nouvelle pièce
            Piece piece = new Piece();
             valeurCourante = Double.parseDouble(champMessage.getText());
             piece1 = piece.getUN_DOLLARD();
             montantMaximum = Double.parseDouble(borne.MONTANT_MAXIMUM);

            // appel la fonction afin d'additionner les pièces
            nValeurCourant = borne.valeurCourante(valeurCourante, piece1, montantMaximum);
            champMessage.setText(String.valueOf(nValeurCourant));
        }


        private void bouton200_actionPerformed() {
            //créer une nouvelle pièce
            Piece piece = new Piece();
            valeurCourante = Double.parseDouble(champMessage.getText());
            piece2 = piece.getDEUX_DOLLARD();
            montantMaximum = Double.parseDouble(borne.MONTANT_MAXIMUM);

            // appel la fonction afin d'additionner les pièces
             nValeurCourant = borne.valeurCourante(valeurCourante, piece2, montantMaximum);
            champMessage.setText(String.valueOf(nValeurCourant));
        }

    private void boutonValiderDateExp_actionPerformed() {
        //prend le numéro de carte du champ
         numeroCarte = champNumeroCarte.getText();
         //prend la date d'expiration du champ mm/aa
         expirationCC = champDateExp.getText();
         //prend la valeur courrante
        valeurCourante = Double.parseDouble(champMessage.getText());




        //créer une nouvelle carte avec le numéro et la date en paramètre
        CarteCredit carte = new CarteCredit(numeroCarte, expirationCC);

        //créer un solde de carte de crédit avec le numéro de la carte
        soldeCC = carte.getSoldeCC();
        //soustraction du solde - valeur courrant à payer
        carte.nouveauSolde(valeurCourante);

        //vérifier si la carte est valide
        if (carte.isValideExpiration(expirationCC)) {
            zoneRecu.setText(zoneRecu.getText() +"La carte de crédit est expirée!\n");
        } else {
            // Vérifie le solde avant et après
            if (soldeCC <= 0) {
                zoneRecu.setText(zoneRecu.getText() +"Vous n'avez pas assez de fond\n");
            } else if (carte.nouveauSolde(valeurCourante) <= 0) {
                zoneRecu.setText(zoneRecu.getText() +"Vous n'avez pas assez de fond\n");
            }
        }

    }


    private void bouton25Credit_actionPerformed() {
        //créer une nouvelle pièce
         Piece piece = new Piece();
        //initie la piece à 2 dollar
        valeurCourante = Double.parseDouble(champMessage.getText());
        piece25 = piece.getVINGT_CINQ_SOU();
         montantMaximum = Double.parseDouble(borne.MONTANT_MAXIMUM);

        // appel la fonction afin d'additionner les pièces
        nValeurCourant = borne.valeurCourante(valeurCourante, piece25, montantMaximum);
        champMessage.setText(String.valueOf(nValeurCourant));
    }

    private void boutonMaxCredit_actionPerformed() {
        // prend la valeur courrente qui est 0.0 si c'est la premiere fois et l'addition
        MontantAPayer = borne.calculerMontantAPayer(Double.parseDouble(borne.MONTANT_MAXIMUM));
        valeurCourante = Double.parseDouble(champMessage.getText());

        //premet de mettre le maximum, prend en compte s'il y a déjà une valeur et le met à 8$
        if(valeurCourante != Double.parseDouble(borne.MONTANT_MAXIMUM)) {
             nValeurCourant=  Double.parseDouble(borne.MONTANT_MAXIMUM) - valeurCourante ;
            valeurCourante += nValeurCourant;
            champMessage.setText(String.valueOf(valeurCourante));
        }
    }



    public void boutonNumeroLettre_actionPerformed(String lettreChiffre) {
        //Prend les chiffre et les lettre entrez dans uen variable qui va les additionner dans une String

        champMessage.setText(borne.getNumeroDeBorne());
        place += lettreChiffre;
        champMessage.setText(place);
    }

    private void boutonEntree_actionPerformed() {

        //vérifie si la le numero de borne est du bon format
        if(Borne.verifierCodeStationnement(place)){
            //Transaction Trans = new Transaction();
            champMessage.setText(String.valueOf(borne.getCout()));
        }else{
            champMessage.setText("Numéro de Borne invalide");

        }
    }

    private void boutonOK_actionPerformed() {
        // prend la date actuel
        Transaction Trans = new Transaction();
        GregorianCalendar present = new GregorianCalendar();

        // objet date
        Date dateCourrant = present.getTime();

        // utilisation de simpleDateformat
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tempsCourrant = formatDate.format(dateCourrant);

        // Calculate le temps base sur l'argent rentrer
        GregorianCalendar tempsFin = borne.DateDebutFin(Double.parseDouble(champMessage.getText()));

        // Fin heure en objet
        Date dateFin = tempsFin.getTime();

        // format heure en string
        String tempsFinStr = formatDate.format(dateFin);

        // Affiche le recu
        zoneRecu.setText("Reçu\n");
        zoneRecu.setText(zoneRecu.getText() + "Votre place de stationnement: " + place + "\n");
        zoneRecu.setText(zoneRecu.getText() + "Type de paiment : " +Trans.getModeDePaiment() + "\n");
        zoneRecu.setText(zoneRecu.getText() + "Le cout de votre transaction est : " + champMessage.getText() + "$\n");
        zoneRecu.setText(zoneRecu.getText() + "Vous debutez à : " + tempsCourrant + "\n");
        zoneRecu.setText(zoneRecu.getText() + "Vous avez jusqu'à : " + tempsFinStr);

        //vide le String du numéro de borne
        place = "";
    }



    private void boutonRapport_actionPerformed()
    {
        //Calcule le montant dans la borne
        montantBorne = 0;
       montantBorne = borne.montantDeLaBorne(valeurCourante);
        zoneRecu.setText("Le montant qui se trouve dans la borne est: "+ montantBorne);
    }




    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("GUITP2");
            frame.setContentPane(new GUITP2().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 875);
            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
