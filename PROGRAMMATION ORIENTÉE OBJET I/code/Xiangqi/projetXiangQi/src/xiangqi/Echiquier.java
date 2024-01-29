package xiangqi;

public class Echiquier {

    private Intersection[][] intersection;


    public Echiquier() {
        intersection = new Intersection[10][9];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                intersection[i][j] = new Intersection();
            }
        }
    }

    public Intersection getIntersection(int i, int j) {
        return intersection[i][j];
    }

    public void debuter() {
        //place de départ pour tout les pièces
        //Piece noir
        intersection[0][0].setPiece(new Char("t1", "noir"));
        intersection[0][1].setPiece(new Cavalier("c1", "noir"));
        intersection[0][2].setPiece(new Elephant("e1", "noir"));
        intersection[0][3].setPiece(new Mandarin("m1", "noir"));
        intersection[0][4].setPiece(new Roi("r1", "noir"));
        intersection[0][5].setPiece(new Mandarin("m2", "noir"));
        intersection[0][6].setPiece(new Elephant("e2", "noir"));
        intersection[0][7].setPiece(new Cavalier("c2", "noir"));
        intersection[0][8].setPiece(new Char("t2", "noir"));

        intersection[2][1].setPiece(new Bombarde("b1", "noir"));
        intersection[2][6].setPiece(new Bombarde("b2", "noir"));

        intersection[3][0].setPiece(new Pion("p1", "noir"));
        intersection[3][2].setPiece(new Pion("p1", "noir"));
        intersection[3][4].setPiece(new Pion("p1", "noir"));
        intersection[3][6].setPiece(new Pion("p1", "noir"));
        intersection[3][8].setPiece(new Pion("p1", "noir"));

        //Piece rouge

        intersection[9][0].setPiece(new Char("t1", "rouge"));
        intersection[9][1].setPiece(new Cavalier("c1", "rouge"));
        intersection[9][2].setPiece(new Elephant("e1", "rouge"));
        intersection[9][3].setPiece(new Mandarin("m1", "rouge"));
        intersection[9][4].setPiece(new Roi("r1", "noir"));
        intersection[9][5].setPiece(new Mandarin("m2", "rouge"));
        intersection[9][6].setPiece(new Elephant("e2", "rouge"));
        intersection[9][7].setPiece(new Cavalier("c2", "rouge"));
        intersection[9][8].setPiece(new Char("t2", "rouge"));

        intersection[7][1].setPiece(new Bombarde("b1", "rouge"));
        intersection[7][6].setPiece(new Bombarde("b2", "rouge"));

        intersection[6][0].setPiece(new Pion("p1", "rouge"));
        intersection[6][2].setPiece(new Pion("p1", "rouge"));
        intersection[6][4].setPiece(new Pion("p1", "rouge"));
        intersection[6][6].setPiece(new Pion("p1", "rouge"));
        intersection[6][8].setPiece(new Pion("p1", "rouge"));
    }



    public boolean cheminPossible(Position depart, Position arrivee) {
        Piece p = intersection[depart.getLigne()][depart.getColonne()].getPiece();

        if (arrivee.getLigne() == depart.getLigne() && arrivee.getColonne() == depart.getColonne()) {
            // La position de départ et d'arrivée sont les mêmes, déplacement valide
            return true;
        }

        if (p instanceof Roi) {
            // Vérifier le déplacement pour le Roi
            return cheminPossibleRoi(depart, arrivee, p);
        } else if (p instanceof Mandarin) {
            // Vérifier le déplacement pour le Mandarin
            return cheminPossibleMandarin(depart, arrivee, p);
        } else if (p instanceof Elephant) {
            // Vérifier le déplacement pour l'Éléphant
            return cheminPossibleElephant(depart, arrivee, p);
        } else if (p instanceof Cavalier) {
            // Vérifier le déplacement pour le Cavalier
            return cheminPossibleCavalier(depart, arrivee, p);
        } else if (p instanceof Char) {
            // Vérifier le déplacement pour le Char
            return cheminPossibleChar(depart, arrivee, p);
        } else if (p instanceof Bombarde) {
            // Vérifier le déplacement pour la Bombarde
            return cheminPossibleBombarde(depart, arrivee, p);
        } else if (p instanceof Pion) {
            // Vérifier le déplacement pour le Pion
            return cheminPossiblePion(depart, arrivee, p);
        } else {
            // Pièce inconnue, déplacement invalide
            return false;
        }
    }



    public boolean cheminPossibleCavalier(Position depart, Position arrivee, Piece p) {

        if (arrivee.getLigne() - depart.getLigne() == -2) {
            // Déplacement vers le haut
            if (intersection[depart.getLigne() - 1][depart.getColonne()].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }
        } else if (arrivee.getLigne() - depart.getLigne() == 2) {
            // Déplacement vers le bas
            if (intersection[depart.getLigne() + 1][depart.getColonne()].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }
        }

        if (arrivee.getColonne() - depart.getColonne() == -2) {
            // Déplacement vers la gauche
            if (intersection[depart.getLigne()][arrivee.getColonne() - 1].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }
        } else if (arrivee.getColonne() - depart.getColonne() == 2) {
            // Déplacement vers la droite
            if (intersection[depart.getLigne()][depart.getColonne() + 1].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true; // La pièce à la position d'arrivée est occupée par l'adversaire, déplacement valide
            } else {
                return false; // La pièce à la position d'arrivée est occupée par le joueur lui-même, déplacement invalide
            }
        }
        return true; // Aucun cas invalide n'a été rencontré, déplacement valide
    }


    public boolean cheminPossibleRoi(Position depart, Position arrivee, Piece p) {

        if (depart.getColonne() == arrivee.getColonne()) {
            // Cas où la colonne de départ et d'arrivée est la même
            if (arrivee.getLigne() < depart.getLigne()) {
                // Vérifier s'il y a des pièces sur les lignes intermédiaires
                for (int i = depart.getLigne() - 1; i > arrivee.getLigne(); i--) {
                    if (intersection[i][depart.getColonne()].estOccupee()) {
                        return false; // Le déplacement est bloqué, déplacement invalide
                    }
                }
                return true; // Aucune pièce sur le chemin, déplacement valide
            }
        } else if (depart.getLigne() == arrivee.getLigne()) {
            // Cas où la ligne de départ et d'arrivée est la même
            if (arrivee.getColonne() < depart.getColonne()) {
                // Vérifier s'il y a des pièces sur les colonnes
                for (int j = depart.getColonne() - 1; j > arrivee.getColonne(); j--) {
                    if (intersection[depart.getLigne()][j].estOccupee()) {
                        return false; // Le déplacement est bloqué, déplacement invalide
                    }
                }
                return true; // Aucune pièce sur le chemin, déplacement valide
            }
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true; // La pièce à la position d'arrivée est occupée par l'adversaire, déplacement valide
            } else {
                return false; // La pièce à la position d'arrivée est occupée par une piece, déplacement invalide
            }
        }

        return false; // Aucun cas valide n'a été rencontré, déplacement invalide
    }

    public boolean cheminPossibleElephant(Position depart, Position arrivee, Piece p) {
        int colonne;
        int ligne;
        int ligneIncrement;
        int colonneIncrement;

        if (arrivee.getLigne() < depart.getLigne()) {
            // Vérifier si la destination se situe au-dessus de la position de départ
            ligneIncrement = -1;
        } else {
            // Vérifier si la destination se situe en dessous de la position de départ
            ligneIncrement = 1;
        }

        if (arrivee.getColonne() < depart.getColonne()) {
            // Vérifier si la destination se situe à gauche de la position de départ
            colonneIncrement = -1;
        } else {
            // Vérifier si la destination se situe à droite de la position de départ
            colonneIncrement = 1;
        }

         ligne = depart.getLigne();
         colonne = depart.getColonne();

        while (ligne != arrivee.getLigne() || colonne != arrivee.getColonne()) {
            ligne += ligneIncrement;
            colonne += colonneIncrement;

            if (ligne < 0 || ligne >= intersection.length || colonne < 0 || colonne >= intersection[0].length) {
                // Les indices sortent des limites de l'array intersection
                return false;
            }

            if (intersection[ligne][colonne].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true;
            } else {
                return false;
            }
        }

        // Le déplacement est valide
        return true;
    }

    public boolean cheminPossibleMandarin(Position depart, Position arrivee, Piece p) {

        int ligneIncrement;
        int colonneIncrement;
        int ligne;
        int colonne;

        if (arrivee.getLigne() < depart.getLigne()) {
            ligneIncrement = -1; // Le déplacement se fait vers le haut
        } else {
            ligneIncrement = 1; // Le déplacement se fait vers le bas
        }

        if (arrivee.getColonne() < depart.getColonne()) {
            colonneIncrement = -1; // Le déplacement se fait vers la gauche
        } else {
            colonneIncrement = 1; // Le déplacement se fait vers la droite
        }

         ligne = depart.getLigne() + ligneIncrement;
         colonne = depart.getColonne() + colonneIncrement;

        while (ligne != arrivee.getLigne() && colonne != arrivee.getColonne()) {
            if (intersection[ligne][colonne].estOccupee()) {
                // Le déplacement est bloqué, déplacement invalide
                return false;
            }

            ligne += ligneIncrement;
            colonne += colonneIncrement;
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true; // La pièce à la position d'arrivée est occupée par l'adversaire, déplacement valide
            } else {
                return false; // La pièce à la position d'arrivée est occupée par le joueur lui-même, déplacement invalide
            }
        }

        return true; // Aucune condition de déplacement invalide n'a été rencontrée, déplacement valide
    }


    public boolean cheminPossibleChar(Position depart, Position arrivee, Piece p) {

        // Vérifier si le char se déplace sur la même ligne ou la même colonne
        if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne()) {

            if (arrivee.getLigne() < depart.getLigne()) {
                // vers le haut
                for (int i = arrivee.getLigne() +1; i < depart.getLigne(); i++){
                    if (intersection[i][depart.getColonne()].estOccupee()) {
                        // Le déplacement est bloqué, déplacement invalide
                        return false;
                    }
                }
            } else {
                for (int i = depart.getLigne() +1; i < arrivee.getLigne() ; i++){ //uniquement vers le bas
                    if (intersection[i][depart.getColonne()].estOccupee()) {
                        // Le déplacement est bloqué, déplacement invalide
                        return false;
                    }
                }
            }

            if (arrivee.getColonne() < depart.getColonne()) {
                //gauche
                for (int i = arrivee.getColonne() +1; i < depart.getColonne(); i++){
                    if (intersection[depart.getLigne()][i].estOccupee()) {
                        // Le déplacement est bloqué, déplacement invalide
                        return false;
                    }
                }
            } else {
                //droit
                for (int i = depart.getColonne() +1; i < arrivee.getColonne() ; i++){ //uniquement vers le bas
                    if (intersection[depart.getLigne()][i].estOccupee()) {
                        // Le déplacement est bloqué, déplacement invalide
                        return false;
                    }
                }
            }
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true; // La pièce à la position d'arrivée est occupée par l'adversaire, déplacement valide
            } else {
                return false; // La pièce à la position d'arrivée est occupée par le joueur lui-même, déplacement invalide
            }
        }
        return false; // Aucune condition de déplacement valide n'a été satisfaite, déplacement invalide
    }



    public boolean cheminPossibleBombarde(Position depart, Position arrivee, Piece p) {
        // Étape 1 : Déplacement comme un char
        // Vérifier si le char se déplace sur la même ligne ou la même colonne
        int compteur = 0;
        int increment =0;
        int ligneDiff=0;
        int colonneDiff=0;
        int colonne=0;
        int ligne=0;

        if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne()) {
             ligneDiff = Math.abs(arrivee.getLigne() - depart.getLigne());
             colonneDiff = Math.abs(arrivee.getColonne() - depart.getColonne());

            if (ligneDiff == 0) {
                // Mouvement horizontal sur la même ligne
                 increment = (arrivee.getColonne() < depart.getColonne()) ? -1 : 1;

                for ( colonne = depart.getColonne() + increment; colonne != arrivee.getColonne(); colonne += increment) {
                    if (intersection[depart.getLigne()][colonne].estOccupee()) {
                        compteur++;
                    }
                }

                ///etape 2
                if (compteur == 1) {
                    // Il y a exactement une pièce entre la Bombard et la pièce à capturer
                    return true;
                }
            } else if (colonneDiff == 0) {
                // Mouvement vertical sur la même colonne
                 increment = (arrivee.getLigne() < depart.getLigne()) ? -1 : 1;

                for ( ligne = depart.getLigne() + increment; ligne != arrivee.getLigne(); ligne += increment) {
                    if (intersection[ligne][depart.getColonne()].estOccupee()) {
                        compteur++;
                    }
                }
                if (compteur >= 1) {
                    // Il y a exactement une pièce entre la Bombard et la pièce à capturer
                    return true;
                }else {
                    return false;
                }
            }
        }

        // Le déplacement n'est pas valide selon les conditions requises
        return false;
    }


    public boolean cheminPossiblePion(Position depart, Position arrivee, Piece p) {

        int ligneIncrement;

        if (p.getCouleur().equals("noir")) {
            ligneIncrement = 1; // Le pion noir avance vers le bas
        } else {
            ligneIncrement = -1; // Le pion rouge avance vers le haut
        }

        int ligne = depart.getLigne() + ligneIncrement;
        int colonne = depart.getColonne();

        // Vérifier le déplacement en ligne droite
        if (colonne == arrivee.getColonne() && ligne == arrivee.getLigne()) {
            if (!intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                // Case d'arrivée vide, déplacement valide
                return true;
            }
        }

        // Vérifier le déplacement sur les côtés
        if (colonne == arrivee.getColonne() - 1 || colonne == arrivee.getColonne() + 1) {
            if (ligne == arrivee.getLigne() && intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                // Déplacement sur les côtés et capture d'une pièce adverse, déplacement valide
                return true;
            }
        }

        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            // Si une pièce se trouve à la position d'arrivée, vérifier si elle est occupée par l'adversaire
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return true; // La pièce à la position d'arrivée est occupée par l'adversaire, déplacement valide
            } else {
                return false; // La pièce à la position d'arrivée est occupée par le joueur lui-même, déplacement invalide
            }
        }

        return false; // Aucune condition de déplacement valide n'a été satisfaite, déplacement invalide
    }


    public boolean roisNePouvantEtreFaceAFace(Position depart, Position arrivee) {
        Position postionRoiNoir = new Position();
        Position postionRoiRouge = new Position();
        int ligneDiff = Math.abs(arrivee.getLigne() - depart.getLigne());
        int colonneDiff = Math.abs(arrivee.getColonne() - depart.getColonne());
        int compteur = 0;
        Piece p = intersection[depart.getLigne()][depart.getColonne()].getPiece();

        // Recherche des positions des rois noir et rouge
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (intersection[i][j].estOccupee()) {
                    if (intersection[i][j].getPiece() instanceof Roi && intersection[i][j].getPiece().getCouleur().equals("noir")) {
                        postionRoiNoir.setLigne(i);
                        postionRoiNoir.setColonne(j);
                    } else if (intersection[i][j].getPiece() instanceof Roi && intersection[i][j].getPiece().getCouleur().equals("rouge")) {
                        postionRoiRouge.setLigne(i);
                        postionRoiRouge.setColonne(j);
                    }
                }
            }
        }

        // Mise à jour des positions des rois si le roi de départ est lui-même un roi et prend les deux rois pour ensuite les comparés
        if (intersection[depart.getLigne()][depart.getColonne()].getPiece() instanceof Roi) {
            if (intersection[depart.getLigne()][depart.getColonne()].getPiece().getCouleur().equals("rouge")) {
                postionRoiRouge.setLigne(arrivee.getLigne());
                postionRoiRouge.setColonne(arrivee.getColonne());
            } else if (intersection[depart.getLigne()][depart.getColonne()].getPiece().getCouleur().equals("noir")) {
                postionRoiNoir.setLigne(arrivee.getLigne());
                postionRoiNoir.setColonne(arrivee.getColonne());
            }
        }

        // Vérification des rois face à face sur la même colonne
        if (postionRoiNoir.getColonne() == postionRoiRouge.getColonne()) {
            for (int i = postionRoiNoir.getLigne() + 1; i < postionRoiRouge.getLigne(); i++) {
                if (intersection[i][depart.getColonne()].estOccupee()) {
                    compteur++;
                    if (compteur >= 1) {
                        return false;
                    }
                }
            }
        }

        // Vérification de la position d'arrivée occupée par l'adversaire
        if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
            if (intersection[arrivee.getLigne()][arrivee.getColonne()].estOccupeeParAdversaire(p.getCouleur())) {
                return false;  // Position occupée par l'adversaire, déplacement invalide
            }
        }

        return true;  // Déplacement valide
    }

    public Intersection[][] getintersection() {
        return intersection;
    }

    public void setintersection(Intersection[][] intersection) {
        this.intersection = intersection;
    }


    public void setIntersection(Intersection[][] intersection) {
        this.intersection = intersection;
    }

    public Intersection[][] getIntersection() {
        return intersection;
    }
}
