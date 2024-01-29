package xiangqi;

public class Char extends Piece {

    public Char(String nom, String couleur){

       super(nom,couleur);

    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        // Vérifie si la norme entre la position de départ et d'arrivée est nulle (même position)
        if (norme(depart, arrivee) == 0) {
            return true;
        }

        // Vérifie si la pièce se déplace sur la même colonne ou sur la même ligne
        if(depart.getColonne() == arrivee.getColonne()){
            return true;
        }else if (depart.getLigne() == arrivee.getLigne()){
            return true;
        }else {
            return false;
        }
    }









}
