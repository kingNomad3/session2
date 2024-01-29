package projet_interface;

public class Vehicule {


    private double valeur;
    private int anneeModele;
    private Proprietaire pr;
    private String numeroPlaque;

    public Vehicule ( double valeur, int anneeModele, Proprietaire pr, String numeroPlaque )
    {
        this.valeur = valeur;
        this.anneeModele = anneeModele;
        this.pr = pr;
        this.numeroPlaque = numeroPlaque;
    }

    public double getValeur()
    {
        return valeur;
    }

    public int getAnneeModele()
    {
        return anneeModele;
    }

    public Proprietaire getPr ()
    {
        return pr;
    }

    public String getNumeroPlaque()
    {
        return numeroPlaque;
    }

}
