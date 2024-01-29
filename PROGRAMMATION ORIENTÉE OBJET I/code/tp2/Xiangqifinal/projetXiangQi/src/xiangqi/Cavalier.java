package xiangqi;

public class Cavalier extends Piece {
    private int diffCol;
    private int diffLig;

    public Cavalier(String nom, String couleur ) {
        super(nom, couleur);

    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        switch (getCouleur()) {
            case "noir":

                //Verifie si le Cavalier reste sur place
                if (norme(depart, arrivee) == 0) {
                    return true;
                }

                //Remplace la norme par le calcul des différences de colonnes et de lignes
                 diffCol = Math.abs(arrivee.getColonne() - depart.getColonne());
                diffLig = Math.abs(arrivee.getLigne() - depart.getLigne());

                // Vérifie si le déplacement correspond à un mouvement en L du cavalier
                if ((diffCol == 1 && diffLig == 2) || (diffCol == 2 && diffLig == 1)) {
                    return true;
                }

                return false;

            case "rouge":
                //Vérifie si le Cavalier reste sur place
                if (norme(depart, arrivee) == 0) {
                    return true;
                }

                //Remplace la norme par le calcul des différences de colonnes et de lignes
                diffCol = Math.abs(arrivee.getColonne() - depart.getColonne());
                diffLig = Math.abs(arrivee.getLigne() - depart.getLigne());

                // Vérifie si le déplacement correspond à une des deux positions spéciales du cavalier rouge
                if ((depart.getLigne() == 9 && depart.getColonne() == 1) || (depart.getLigne() == 9 && depart.getColonne() == 7)) {
                    return true;
                }
        }
        return false;
    }
}
