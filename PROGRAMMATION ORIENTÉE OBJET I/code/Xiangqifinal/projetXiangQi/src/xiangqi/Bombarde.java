package xiangqi;

public class Bombarde extends Piece {
    public Bombarde(String nom, String couleur) {
        super(nom, couleur);
    }
        Piece p;
    @Override
    public boolean estValide(Position depart, Position arrivee) {
        //verifie si la piece ne bouge pas
        if (norme(depart, arrivee) == 0) {
            return true;
        }

        //Verifie si le Bombarde reste sur la même ligne ou sur la même colonne
        if(depart.getColonne() == arrivee.getColonne()){
            return true;
        }else if (depart.getLigne() == arrivee.getLigne()){
            return true;
        }else {
            return false;
        }
    }



}
