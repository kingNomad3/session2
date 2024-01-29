package xiangqi;

public class Roi extends Piece {

    public Roi(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

            switch (getCouleur()) {
                case "noir":
                    // Vérifie si la norme entre la position de départ et d'arrivée est nulle
                    if (norme(depart, arrivee) == 0) {
                        return true;
                    }
                    // Vérifie si la position d'arrivée se trouve dans la plage valide pour le mouvement du cavalier
                    if (arrivee.getColonne() >= 3 && arrivee.getColonne() <= 5) {
                        if (arrivee.getLigne() <= 2 && arrivee.getLigne() >= 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                case "rouge":
                    // Vérifie si la norme entre la position de départ et d'arrivée est nulle
                    if (norme(depart, arrivee) == 0) {
                        return true;
                    }
                    // Vérifie si la position d'arrivée se trouve dans la plage valide pour le mouvement du cavalier
                    if (arrivee.getColonne() >= 3 && arrivee.getColonne() <= 5) {
                        if (arrivee.getLigne() <= 9 && arrivee.getLigne() >= 7) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            }
            return false;
    }

}
