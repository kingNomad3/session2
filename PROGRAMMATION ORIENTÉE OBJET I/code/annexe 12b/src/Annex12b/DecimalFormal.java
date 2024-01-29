package Annex12b;

import java.text.DecimalFormat;

public class DecimalFormal {

    public static void main(String[] args) {
        double valeur = 1234565.579;
        DecimalFormat fd = new DecimalFormat("0.00"); // ou 0.##
        System.out.println(fd.format(valeur));

        DecimalFormat dfb = new DecimalFormat("0.00$");// pas de # pour les chiffre money
        System.out.println(dfb.format(valeur));

        DecimalFormat dfc = new DecimalFormat("0,000.00");// pas de # pour les chiffre money
        System.out.println(dfc.format(valeur));

        DecimalFormat dfd = new DecimalFormat("0.00000");// pas de # pour les chiffre car ils ne sont pas significatif et ne vont pas afficher les 0
        System.out.println(dfd.format(valeur));
    }

}
