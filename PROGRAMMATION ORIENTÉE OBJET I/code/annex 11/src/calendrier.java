import java.util.Calendar;
import java.util.GregorianCalendar;



public class calendrier {


        public static void main(String[] args) {

            //creer un objet de l'instant present lorsque c'est sans parametre
            GregorianCalendar present = new GregorianCalendar();
            //dernier jour d'ecole 25 mai
            //on est le 114 ieme jour dans l'annee  System.out.println(present.get(Calendar.DAY_OF_YEAR));
            System.out.println(present.get(Calendar.DAY_OF_YEAR));
            //System.out.println(present.get(1)); donne le meme resultat que get(YEAR))
       //creer un objet qui represente le dernier jour d'ecole
            GregorianCalendar dernierJour = new GregorianCalendar(2023,4,25);
            System.out.println(dernierJour.get(Calendar.DAY_OF_YEAR) - present.get((Calendar.DAY_OF_YEAR)));
            //System.out.println(Calendar.DAY_OF_WEEK ==1);
        }

}
