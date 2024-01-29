package projet_passeport;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Passeport {

    private Dose[] doses;

    // passeport sans Dose
    public Passeport ( )
    {
       doses = new Dose[3];
    }
    // passeport avec doses déjà données
    public Passeport ( Dose[] doses)
    {
      this.doses = doses;
    }

    public int possibleDAvoirAutreDose()
    {
        // vérifier s'il y a une Dose libre sur 3, retourner l'indice ou -1 s'il n'y a plus d'indice libre sur 3
        for (int i = 0; i < doses.length; i++){

            if(doses[i] == null ){

                return i;
            }


        }
        return -1;
    }

    public boolean ajouterDose ( Dose d )
    {
        int indice = possibleDAvoirAutreDose();
	    //s'il y a pas de doses possibles, retourner faux
      
      
        // si la dose possible est le premier vaccin , rien à vérifier
            
      
	// si ce n'est pas le premier vaccin, calculer délai de 6 mois pour savoir si possible, l'ajouter dans le tableau si ce l'est
    
      if( indice == -1 ){
        return false;

      }else if(doses[0] == null){
          doses[0] =d;
          return true;
      }else{
          GregorianCalendar datePrecendent = doses[indice-1].getDateVaccination();
          GregorianCalendar dateDElaDosesACtuelle = d.getDateVaccination();
          datePrecendent.add(Calendar.MONTH, 6);

          //si encore avant, il y a eu 6 mois
          if(datePrecendent.before(datePrecendent)){
              doses[indice] = d;
              return true;

          }else{
              return false;
          }
      }


     }
}


