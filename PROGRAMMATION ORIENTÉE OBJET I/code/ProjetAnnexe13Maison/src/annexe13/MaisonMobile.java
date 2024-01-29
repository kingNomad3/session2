package annexe13;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MaisonMobile extends Chalet{

    int anneeFabrication;

    public MaisonMobile(int nbrePieces, double prixVente, boolean electricite, boolean accesLac, int anneeFabrication){
        super(nbrePieces, 0, null, "", prixVente, electricite,accesLac);
        this.anneeFabrication = anneeFabrication;

    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }


    @Override
    public double valeur(){
        GregorianCalendar present = new GregorianCalendar();
        double valeur = super.valeur();
        int age = present.get((Calendar.YEAR)- anneeFabrication);
        if(age <= 10){
            return  valeur;
        }else if (age <= 19){
            return valeur *= 0.60;
        }else if (age >= 20){
           return valeur*=0.5;
        }

        return valeur;
    }
}
