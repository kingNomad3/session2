package Frigo;

public class frigo {

    private String nomModele;
    private double prix;
    private int capacite;
    private boolean aDistributeurGalce



    // constructeur avec 4 parametres pour creer n'importe quel frigo
    public frigo (String nomModele, double prix, int capacite, boolean aDistributeurGalce){
        this.nomModele = nomModele;
        this.prix = prix;
        this.capacite = capacite;
        this.aDistributeurGalce = aDistributeurGalce;
    }

    // 80% des frigos  sont du meme modele --> le representer dans notre constructeur par defaut
    public frigo(){
        nomModele = "frigo";
        prix = 900;
        capacite = 16;
        aDistributeurGalce = false; //mais false par defaut
    }


// constructeur sans prix
ublic frigo (String nomModele, int capacite, boolean aDistributeurGalce){
    this.nomModele = nomModele;
    this.capacite = capacite;
    this.aDistributeurGalce = aDistributeurGalce;
}


}
