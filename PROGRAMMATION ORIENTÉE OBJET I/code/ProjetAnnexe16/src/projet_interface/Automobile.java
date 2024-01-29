package projet_interface;

import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Automobile extends Vehicule implements Assurable {

    private double coutAssurance;

    public Automobile(double valeur, int anneeModele, Proprietaire pr, String numeroPlaque) {
        super(valeur, anneeModele, pr, numeroPlaque);

    }

    GregorianCalendar present = new GregorianCalendar();

    @Override
    public boolean estAssurable() {
        GregorianCalendar datelimite = (GregorianCalendar) getPr().getDate().clone();
        datelimite.add(Calendar.YEAR,-21);

       if (getNumeroPlaque().substring(0,1).equals("T")  && datelimite.before(present))
            return false;
       else
           return true;
    }


    @Override
    public double coutAssurance() {
        if (estAssurable()) {
            coutAssurance = getValeur() * POURCENT_TAXE;
            if (getPr().getVille().equals("Montreal")) {
                coutAssurance *= 0.6;
            }
            return coutAssurance;
        }
        return 0;
    }
}
