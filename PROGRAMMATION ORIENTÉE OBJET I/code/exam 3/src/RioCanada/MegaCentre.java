package RioCanada;

import java.awt.*;
import java.util.Vector;

public class MegaCentre {
    private Vector<Magasin> magasin;
    private double superficieTotale;

    public MegaCentre( double superficieTotale) {
        this.magasin = new Vector<>(6);;
        this.superficieTotale = superficieTotale;
    }

    public double superficieConstruite(){

        for (int i =0; i< magasin.size(); i++){
            superficieTotale += magasin.get(i).getSuperficie();

        }
        return superficieTotale;
    }

    public double superficieStationnement(){
        double nbStationnement;
        double placeParMetre;

        placeParMetre =  superficieTotale/1000;

        return   placeParMetre %6;
    }

    public double superficieEcnoreDisponible(){
        double encoreDispo = superficieTotale -superficieStationnement() -superficieConstruite();
        return encoreDispo;
    }

    public double afficheNbMagasin(String categorieMagasin){
        double total = 0;

        for (int i = 0; i < magasin.size(); i++){
            if (magasin.contains(magasin.get(i).getCategorieMagasin()) ) {
                total++;

            }
        }

        return total;
    }


    public boolean contruireMagasin(Magasin nouveauMagasin){
        int compteur =0;
        boolean Contruire;
        if ( superficieEcnoreDisponible() >= nouveauMagasin.getSuperficie()){
            for (int i = 0; i < magasin.size(); i++){
                if (magasin.contains(nouveauMagasin.getCategorieMagasin()) ) {
                    compteur++;
                    if (compteur <3 ){
                        magasin.add(nouveauMagasin);
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public double nombreMagasinsConstruits( ){

        double nbMagasin = 0;

        for (int i = 0; i <magasin.size(); i++ ){

            nbMagasin += (Double.parseDouble(magasin.get(i).getCategorieMagasin()));

        }

        return nbMagasin;
    }











}
