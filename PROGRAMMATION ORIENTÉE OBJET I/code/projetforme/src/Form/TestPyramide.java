package Form;

public class TestPyramide {
    public PyramideBaseCarree() {
        super();
    }


    public double calcukerapotheme(){
        double aptheme  = Math.pow(getHauteur(), 2) + Math.pow( getLargeur()/2),2)
    }


    @Override
    public double air(){

        double airBase = getLargeur() * getLongueur;
        double airCote = getLargeur() * calcukerapotheme();
        return airBase;
    }





    @Override
    public double volume() {
        return super.volume() / 3;
    }
}