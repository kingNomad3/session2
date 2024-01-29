package Banque;

public class Banque {
    private String nom;
    private double solde;
    private String numero;
    private static int nbCompte = 0;



    public Banque( String nom,  double solde ){
        nbCompte++;

        this.nom = nom;
        this.solde= solde;
        this.numero = nom.charAt(0) + "-" + nbCompte;


    }


    public void Depot(double montant){

        this.solde -= montant;


    }

    public void Retirer( double montant){
        this.solde += montant;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde(){
        return solde;
    }


}
