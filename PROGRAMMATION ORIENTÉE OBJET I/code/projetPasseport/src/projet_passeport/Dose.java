package projet_passeport;

import java.util.GregorianCalendar;

public class Dose {

    private String fournisseur;
    private GregorianCalendar dateVaccination;

    public Dose(String fournisseur, GregorianCalendar dateVaccination)
    {
        this.fournisseur = fournisseur;
        this.dateVaccination = dateVaccination;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public GregorianCalendar getDateVaccination() {
        return dateVaccination;
    }

    public void setDateVaccination(GregorianCalendar dateVaccination) {
        this.dateVaccination = dateVaccination;
    }
}
