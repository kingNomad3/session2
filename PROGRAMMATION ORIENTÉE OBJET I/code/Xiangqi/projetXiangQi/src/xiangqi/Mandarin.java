package xiangqi;

public class Mandarin extends Piece {
    public Mandarin(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        switch (getCouleur()) {
            case "noir":
                // Vérifie si la norme entre la position de départ et d'arrivée est nulle
                if (norme(depart, arrivee) == 0)
            if (norme(depart, arrivee) == 0)
                return true;
            else if (norme(depart, arrivee) == 2) {
                return true;
            }
                // Vérifie si la position d'arrivée se trouve dans les plages valides pour le mouvement du cavalier noir
            if (arrivee.getColonne() >= 2 && arrivee.getColonne() <= 4 || arrivee.getColonne() >= 4 && arrivee.getColonne() <= 6) {
                if (arrivee.getLigne() <= 2 && arrivee.getLigne() >= 0) {
                    return true;
                }
            }
            return false;

            case "rouge":
                // Vérifie si la norme entre la position de départ et d'arrivée est nulle
                if (norme(depart, arrivee) == 0)
                    return true;
                else if (norme(depart, arrivee) == 2) {
                    return true;
                }
                // Vérifie si la position d'arrivée se trouve dans les plages valides pour le mouvement du cavalier rouge
                if (arrivee.getColonne() >= 2 && arrivee.getColonne() <= 4 || arrivee.getColonne() >= 4 && arrivee.getColonne() <= 6) {
                    if (arrivee.getLigne() <= 9 && arrivee.getLigne() >= 7) {
                        return true;
                    }
                }
        }
        return false;
    }
}
