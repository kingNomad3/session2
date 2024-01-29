package annexe13;

public class Chalet extends Maison {
    boolean electricite;
    boolean accesLac;

    public Chalet(int nbrePieces, double superficieTerrain, String noAdresse, String nomRue, double prixVente, boolean electricite, boolean accesLac){
        super(nbrePieces, superficieTerrain, noAdresse, nomRue, prixVente);
        this.accesLac = accesLac;
        this.electricite = electricite;

    }

    public boolean isElectricite() {
        return electricite;
    }

    public boolean isAccesLac() {
        return accesLac;
    }

@Override
    public double valeur(){
       double valeur = super.valeur() * 0.75;
       if(electricite = true){
           valeur = valeur *1.10;
           if(accesLac = true){
               valeur += 15000;
           }
       }

       return valeur;
    }
}
