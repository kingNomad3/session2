package Examen2;

public class Grossiste   {

    private ForfaitVacances [] tableau;

    public Grossiste(ForfaitVacances[] tableau){
        this.tableau = tableau;
    }

    public int  nbForfait4etoilesOuPlus(){

        int compteur =0;
        for (int i= 0; i <tableau.length; i ++){
            if (tableau[i].getEtoile() >= 4)
                compteur++;
        }
        return compteur;
    }
}
