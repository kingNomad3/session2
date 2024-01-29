package xiangqi;

public class Elephant extends Piece {
    public Elephant(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        switch (getCouleur()) {
            case "noir":
                // Vérifie si la norme entre la position de départ et d'arrivée est nulle
            if (norme(depart, arrivee) == 0) {
                return true;
                // Vérifie si la norme entre la position de départ est de deux intersections
            }
                // Vérifie si la position d'arrivée se trouve dans la plage valide pour le mouvement du cavalier noir
            if (arrivee.getColonne() >= 0 && arrivee.getColonne() <= 8 ) {
                if (arrivee.getLigne() <= 4 && arrivee.getLigne() >= 0) {
                    if (norme(depart, arrivee) == 8) {
                        return true;
                    }
                }
            }
            return false;

            case "rouge":
                // Vérifie si la norme entre la position de départ et d'arrivée est nulle
                if (norme(depart, arrivee) == 0)
                    return true;
                    // Vérifie si la norme entre la position de départ est de deux intersections
                else if (norme(depart, arrivee) == 8) {
                    return true;
                }
                // Vérifie si la position d'arrivée se trouve dans la plage valide pour le mouvement du cavalier rouge
                if (arrivee.getColonne() >= 0 && arrivee.getColonne() <= 8) {
                    if (arrivee.getLigne() <= 9 && arrivee.getLigne() >= 5) {
                        if (norme(depart, arrivee) == 8) {
                            return true;
                        }

                    }
                }
                return false;
        }
        return false;
    }
}
