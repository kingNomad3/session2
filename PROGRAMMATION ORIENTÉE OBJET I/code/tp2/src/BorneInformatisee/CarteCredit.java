package BorneInformatisee;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarteCredit {
    private String numeroCarte;
    private String expirationCC;
    private double soldeCC;
    private boolean valideCC;
    private double sub1;
    private double sub2;

    GregorianCalendar present = new GregorianCalendar();
    Transaction T = new Transaction();


    public CarteCredit( String numeroCarte, String expirationC){
        this.numeroCarte = numeroCarte;
        this.expirationCC = expirationCC;
        this.soldeCC = solde(numeroCarte);
        this.valideCC = valideCC;
    }

    //permet de trouver le solde de la carte de crédit
    public double solde(String numeroCarte){

        sub1 = 0;
        sub2 = 0;

        if (numeroCarte.length() >= 18) {
            sub1 = Double.parseDouble(numeroCarte.substring(0, 1));
            sub2 = Double.parseDouble(numeroCarte.substring(17, 18));
        } else {
            throw new IllegalArgumentException("Invalid input string length");
        }

        soldeCC = sub2 - sub1;
        return soldeCC ;
    }

    //Soustraction du solde de la carte de credit au montant du client
    public double nouveauSolde(double montantCourant ){

        double nouveauSolde = soldeCC - montantCourant;

        return nouveauSolde;
    }
    //calcule si la date d'expiration est depassé
    public boolean isValideExpiration(String expirationCC) {
        String[] parts = expirationCC.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]) + 2000;

        Calendar expirationDate = new GregorianCalendar(year, month - 1, 1);
        Calendar currentDate = new GregorianCalendar();

        return expirationDate.before(currentDate);
    }

    public String getExpirationCC() {
        return expirationCC;
    }


    public String getNumeroCarte(){
        return numeroCarte;
    }

    public double getSoldeCC() {
        return soldeCC;
    }


}
