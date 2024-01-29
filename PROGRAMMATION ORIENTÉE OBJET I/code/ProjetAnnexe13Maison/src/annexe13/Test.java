package annexe13;

import java.text.DecimalFormat;

public class Test {

    public static void main(String[] args) {


        DecimalFormat df = new DecimalFormat();

        Maison m = new Maison(5,400,"12","Roy",180000);
        Maison m2 = new Maison(6,230,"13","Roy",25000);
        Chalet c = new Chalet(5,600,"33","Desilets",150000,true, true);
        MaisonMobile mm = new MaisonMobile(5,90500,true,true,1999);

        System.out.println(df.format((m.valeur())));
        c.ajouterPieces(2);
        System.out.println(df.format(c.valeur()));
        m.setSuperficie(500);
        System.out.println(m.meilleureAffaire(m2));
    }
}


