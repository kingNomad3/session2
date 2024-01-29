package xiangqi;

public class Intersection {

        private Piece piece;
    public Intersection( Piece piece) {

        this.piece = piece;
    }

    public Intersection(){
        this.piece = null;
    }

    public boolean estOccupee(){

        if( piece != null ) {
            return true;
        }
        return false;
    }

    public boolean estOccupeeParCouleur(String couleur){
            if(piece.getCouleur().equals(couleur) ){
                return true;
            }
            return false;
    }

    public boolean estOccupeeParAdversaire ( String couleur ){
        if (piece.getCouleur() != couleur) {
                    return true;
        }
        return false;
    }

    public Piece getPiece() {
        return piece;
    }



    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
