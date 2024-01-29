package Examen2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ForfaitVacances {
    public static final double SEMAINE_1_BASE = 499.99;
    public static final double SEMAINE_2_BASE = 799.99;
    public static final double BARRE_INCLUS_1 = 110;
    public static final double BARRE_INCLUS_2 = 129.99;
    public static final double DATE_DEPART_1 = 200;
    public static final double DATE_DEPART_2 = 390;
    public static final double ETOILE_1 = 199.99;
    public static final double ETOILE_2 = 129.99;
    private static final int DEBUT_VACANCES_MOIS = GregorianCalendar.JULY;
    private static final int FIN_VACANCES_MOIS = GregorianCalendar.JULY;
    private static final int DEBUT_VACANCES_JOUR = 2;
    private static final int FIN_VACANCES_JOUR = 30;

    private String destination;
    private int duree;
    private GregorianCalendar dateDepart;
    private int etoile;
    private boolean barInclus;
    GregorianCalendar present = new GregorianCalendar();

    public ForfaitVacances(String destination, int duree, GregorianCalendar dateDepart, int etoile, boolean barInclus) {
        this.destination = destination;
        this.duree = duree;
        this.dateDepart = dateDepart;
        this.barInclus = barInclus;
        if (etoile>1 && etoile <=5)
            this.etoile = etoile;
    }


    public double calculerPrix() {
        int mois = present.get(GregorianCalendar.MONTH);

        GregorianCalendar debutVacances = new GregorianCalendar(2023,6,2);
        GregorianCalendar finVacances = new GregorianCalendar(2023,6,30);
        GregorianCalendar dateDedepart = new GregorianCalendar();


        double total = 0;

        if (duree == 1){
            total = 499.99 + (etoile -1) * 199.99 ;
            if (barInclus)
                total+= 110;
            if (dateDedepart.after(debutVacances) &&  dateDedepart.before(finVacances))
                total+=200;

        }else{

        }

            total = 799.99 + (etoile -1) * 129.99 ;
            if (barInclus)
                total+= 200;
            if (dateDedepart.after(debutVacances) &&  dateDedepart.before(finVacances))
                total+=390;


            if (dateDedepart.get(Calendar.DAY_OF_YEAR ) - present.get(Calendar.DAY_OF_YEAR) <= 5)
                total = total - total *0.1;

            return total;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public GregorianCalendar getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(GregorianCalendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    public boolean isBarInclus() {
        return barInclus;
    }

    public void setBarInclus(boolean barInclus) {
        this.barInclus = barInclus;
    }

    public GregorianCalendar getPresent() {
        return present;
    }

    public void setPresent(GregorianCalendar present) {
        this.present = present;
    }
}