package Examen2;

import java.util.GregorianCalendar;

public class ForfaitSpecial extends ForfaitVacances{


    public ForfaitSpecial( GregorianCalendar dateDepart, boolean barInclus) {
        super("Varadero", 1, dateDepart, 4, true);
    }

    @Override
    public double calculerPrix() {
        double total = 999;
        if (isBarInclus())
            total+= 110;

        return total;
    }
}
