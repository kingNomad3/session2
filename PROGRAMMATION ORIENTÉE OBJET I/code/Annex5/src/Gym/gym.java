package Gym;

public class gym {


    private double prix;
    private int nbJours;
    private String nom;

    //Abonnement base
    public gym( String nom, double prix, int nbJours ){
        this.prix = prix;
        this.nbJours= nbJours;
        this.nom = nom;
    }

    //Abonnement base
    public gym(String nom){
    this.prix = 41.25;
    this.nbJours = 30;
    this.nom = nom;
    }
    //Abonnement base
    public gym( String nom,  int nbJours){
       prix = this.nbJours * 8.25;
        this.nom = nom;
        this.nbJours = nbJours;
    }
    //Abonnement base


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prixabonne){
        this.prix = prixabonne;
    }
}
