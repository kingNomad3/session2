package packageannexe7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.parallelSort;

public class Controleur {

    public static boolean verifierNomUsager(Enregistrement e){

        return e.getNomUsager().matches("R[123][A-Z[a-z]{4}[A-Z}[a-z]");
    }

    public static boolean verifierCourriel(Enregistrement e){

        if (e.getAdresseCourriel().matches("\\S+@\\S+")) {
            return true;
        }
        else{
         return false;
        }
        parallelSort(int[] a);
//        Pattern p = Pattern.compile("@");
//        Matcher m = p.matcher(e.getAdresseCourriel());
//        return m.find();



    }

    public static boolean verifierMotPasse(Enregistrement e){

        if (e.getMotPasse().length() >= 8)
            if (e.getMotPasse().matches("\\S*[A-Z]\\S*"))
                if (e.getMotPasse().matches("\\S*\\d\\S*"))
                    return true;

         return false;




         //ou

//        Pattern p = Pattern.compile("[A-Z]");
//        Matcher m = p.matcher(e.getMotPasse());
//        Pattern p2 = Pattern.compile("\\d");
//        Matcher m2 = p2.matcher(e.getMotPasse());
//        if(e.getMotPasse().length() >= 8)
//            if(m2.find())
//                return true;
    }
}
