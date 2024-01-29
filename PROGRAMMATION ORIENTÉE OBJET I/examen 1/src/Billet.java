public class Billet {

    private String codeDuVol;
    private double prix;

    public Billet(String codeDuVol,double prix){
        this.codeDuVol = codeDuVol;
        this.prix = prix;
    }

    public String getCodeDuVol(){return codeDuVol;}
    public double getPrix(){return prix;}



}
