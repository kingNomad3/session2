package Form;

public class Prisme {

    private double longuer;
    private double largeur;
    private double hauteur;

    public Prisme(){
        longuer = 1;
        largeur = 1;
        hauteur = 1;
    }

    public Prisme(double longuer, double largeur, double hauteur) {
        this.longuer = longuer;
        this.largeur = largeur;
        this.hauteur = hauteur;

    }



    public double volume(){
        return hauteur*largeur*longuer;
    }

    public double air(){
       return 2* longuer*largeur+longuer*largeur+largeur*hauteur;
    }

    public double getLonguer() {
        return longuer;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setLonguer(int longuer) {
        this.longuer = longuer;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLonguer(double longuer) {
        this.longuer = longuer;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
}
