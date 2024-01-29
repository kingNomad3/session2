package BorneInformatisee;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Borne {

    public static final String MONTANT_MAXIMUM = "8.0";


    private static final int JOUR_SEMAINE_DEBUT = GregorianCalendar.MONDAY;
    private static final int JOUR_SEMAINE_FIN = GregorianCalendar.FRIDAY;
    private static final int HEURE_SEMAINE_DEBUT = 9;
    private static final int HEURE_SEMAINE_FIN = 21;

    private static final int JOUR_SAMEDI = GregorianCalendar.SATURDAY;
    private static final int HEURE_SAMEDI_DEBUT = 9;
    private static final int HEURE_SAMEDI_FIN = 18;

    private static final int JOUR_DIMANCHE = GregorianCalendar.SUNDAY;
    private static final int HEURE_DIMANCHE_DEBUT = 13;
    private static final int HEURE_DIMANCHE_FIN = 18;

    private String numeroDeBorne;
    private double cout;
    private double montantTotal;
    private double nouveauSolde;
    private double montantBorne;


    Piece piece = new Piece();
    GregorianCalendar present = new GregorianCalendar();

    public Borne(){
        this.numeroDeBorne = numeroDeBorne;
        this.montantBorne =  montantDeLaBorne(montantTotal);
        this.cout = cout;
        this.nouveauSolde = nouveauSolde;
    }

        //verifie si la borne est valide
    public boolean estHeureValide() {
        //permet de savoir si la bone est valide
        int jour = present.get(GregorianCalendar.DAY_OF_WEEK);
        int heure = present.get(GregorianCalendar.HOUR_OF_DAY);

        if (jour >= JOUR_SEMAINE_DEBUT && jour <= JOUR_SEMAINE_FIN) {
            if (heure >= HEURE_SEMAINE_DEBUT && heure < HEURE_SEMAINE_FIN)
                return true;
        } else if (jour == JOUR_SAMEDI) {
            if (heure >= HEURE_SAMEDI_DEBUT && heure < HEURE_SAMEDI_FIN)
                return true;
        } else if (jour == JOUR_DIMANCHE) {
            if(heure >= HEURE_DIMANCHE_DEBUT && heure < HEURE_DIMANCHE_FIN)
                return true;
        }
        return false;
    }

    //permet de verifier si l'addition des pièces  ne depasse pas le maxium
    public double valeurCourante(double valeurCourante, double piece, double montantMaximum) {
        double MontantAPayer = calculerMontantAPayer(piece);

        double nouvelleValeurCourante = valeurCourante + piece + MontantAPayer;

        if (nouvelleValeurCourante <= montantMaximum) {
            return nouvelleValeurCourante;
        } else {
            return montantMaximum;
        }
    }
        //permet d'additionner les pieces
    public double calculerMontantAPayer(double pieceClient) {

        while (montantTotal > Double.parseDouble(MONTANT_MAXIMUM)) {
            if (pieceClient == piece.getVINGT_CINQ_SOU()) {
                montantTotal += pieceClient;

            } else if (pieceClient == piece.getUN_DOLLARD()) {
                montantTotal += pieceClient;

            } else if (pieceClient == piece.getDEUX_DOLLARD()) {
                montantTotal += pieceClient;

            } else if (!estHeureValide()) {
                return 0;// Si la borne est fermée à l'heure actuelle, retourner $
            }
        }
        return montantTotal;
    }


    //Permet de savoir le temps selon les pièces
    public GregorianCalendar DateDebutFin(double valeurCourante) {
        GregorianCalendar present = new GregorianCalendar();
        int currentHour = present.get(Calendar.HOUR_OF_DAY);
        int currentMinute = present.get(Calendar.MINUTE);
        int currentSecond = present.get(Calendar.SECOND);

        int dureeEnMinute = (int) (valeurCourante * 15);
        int dureeEnSeconds = dureeEnMinute * 60;

        GregorianCalendar dateDebut = new GregorianCalendar();
        dateDebut.set(Calendar.HOUR_OF_DAY, currentHour);
        dateDebut.set(Calendar.MINUTE, currentMinute);
        dateDebut.set(Calendar.SECOND, currentSecond);
        dateDebut.add(Calendar.SECOND, dureeEnSeconds);

        return dateDebut;
    }


    //Verifie le bon format de date
    public static boolean verifierCodeStationnement(String numeroDeBorne) {
        return numeroDeBorne.matches("^[A-D]\\d{3}$");
    }

    //addition le montant dans le borne
    public double montantDeLaBorne( double montantTotal){

        montantBorne+=montantTotal;
        return montantBorne;
    }



    public String getNumeroDeBorne() {
        return numeroDeBorne;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        cout = cout;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public double getNouveauSolde() {
        return nouveauSolde;
    }

    public double getMontantBorne() {
        return montantBorne;
    }

    public void setMontantBorne(double montantBorne) {
        this.montantBorne = montantBorne;
    }
}




