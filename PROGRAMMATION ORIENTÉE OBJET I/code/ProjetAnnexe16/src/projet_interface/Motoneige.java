package projet_interface;

import java.security.cert.CertificateNotYetValidException;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Motoneige extends Vehicule implements Assurable{
    private final int cC;

    public Motoneige(double valeur, int anneeModele, Proprietaire pr, String numeroPlaque, int cC) {
        super(valeur, anneeModele, pr, numeroPlaque);
        this.cC = cC;
    }

    @Override
    public boolean estAssurable() {
        
        if (cC > 600)
             return false;
        else
            return true;
    }

    @Override
    public double coutAssurance() {
        GregorianCalendar present = new GregorianCalendar();
      int age = getAnneeModele() - present.get(Calendar.YEAR);

        double coutAssurance = 500 - (age *25);
        return coutAssurance;
    }
}
