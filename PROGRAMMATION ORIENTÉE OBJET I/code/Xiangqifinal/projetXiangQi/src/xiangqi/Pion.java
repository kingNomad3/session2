package xiangqi;


public class Pion extends Piece {

    private  int diffCol;
    private int diffLig;
    public Pion(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
         diffCol = Math.abs(arrivee.getColonne() - depart.getColonne());
         diffLig = Math.abs(arrivee.getLigne() - depart.getLigne());

        switch (getCouleur()) {
            case "noir":
                if (norme(depart, arrivee) == 0)
                    return true;
                if (arrivee.getLigne() > depart.getLigne()) {
                    // Verifie si le pion est de son coter avance en ligne droite
                    if (depart.getLigne() <= 4) {
                        // verifie si c'est en ligne
                        if (diffCol == 0 && diffLig == 1) {
                            return true;
                        }
                    }
                }else if (arrivee.getLigne() == depart.getLigne()){
                    // Verifie si le pion est de son coter avance en ligne droite
                    if (depart.getLigne() <= 4) {
                        // verifie si c'est en ligne
                        if (diffCol == 0 && diffLig == 1) {
                            return true;
                        }
                    } else { // Verifie si le poin est de l'autre coter de la rivière
                        // verifie si le pion avance d'une ligne ou du coter
                        if ((diffCol == 0 && diffLig == 1) || (diffCol == 1 && diffLig == 0)) {
                            return true;
                        }
                    }
                }
                return false;

            case "rouge":
                if (depart.getLigne() >= 5)
                    return true;
                // si le pion est de son coter avance en ligne droite
                if (norme(depart, arrivee) == 0) {
                    // verifie si c'est en ligne
                    if (arrivee.getLigne() > depart.getLigne()) {
                        // verifie si c'est en ligne
                        if (diffCol == 0 && diffLig == 1) {
                            return true;
                        }
                    }
                }else if (depart.getLigne() >= 5){
                    // verifie si c'est en ligne
                    if (arrivee.getLigne() == depart.getLigne()) {
                        // verifie si c'est en ligne
                        if (diffCol == 0 && diffLig == 1) {
                            return true;
                        }
                    } else {  // Verifie si le poin est de l'autre coter de la rivière
                        // verifie si le pion avance d'une ligne ou du coter
                        if ((diffCol == 0 && diffLig == 1) || (diffCol == 1 && diffLig == 0)) {
                            return true;
                        }
                    }
                }
                return false;
        }
        return false;
    }


}