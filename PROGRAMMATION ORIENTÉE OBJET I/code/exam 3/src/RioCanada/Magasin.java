package RioCanada;

public class Magasin {
      private String nomMagasin;
      private double superficie;
      private String categorieMagasin;
      private int numeroLocal;

    public Magasin(String nomMagasin, double superficie, String categorieMagasin) {
        this.nomMagasin = nomMagasin;
        this.superficie = superficie;
        this.categorieMagasin = categorieMagasin;
        numeroLocal =0;

        //pas une bonne methode
        for (int i = 0; i< nomMagasin.length(); i++){
            if (Character.isUpperCase(nomMagasin.charAt(i))){
                numeroLocal+= nomMagasin.charAt(i);
            }
        }
    }


    public String getNomMagasin() {
        return nomMagasin;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getCategorieMagasin() {
        return categorieMagasin;
    }

    public void setCategorieMagasin(String categorieMagasin) {
        this.categorieMagasin = categorieMagasin;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }
}
