package packagevector;

import java.awt.*;
import java.util.Vector;

public class TestVecteurs {

    public static void main(String[] args)
    {
        // Création d'un vecteur sans générique
       Vector v = new Vector ( 3 ); // sans generique


        // insertion ds le vecteur en une étape

        v.add ( new Point ( 3,3 ));

        // insertion ds le vecteur en deux étapes

        Point p = new Point ( 2,4 );
        v.add( p );



        v.add ( new Point ( 5,5 ));
        v.insertElementAt ( new Point (8,5), 0 );
        v.insertElementAt ( new Point( 4,7), 2);

        v.removeElementAt( 4 );

        // indice 1:3,3
        //
        System.out.println(v);

        // afficher la capacité du vecteur

        System.out.println(v.capacity());


        // afficher la grandeur du vecteur

        System.out.println(v.size());


        // afficher la valeur de la donnée x du premier élément du vecteur
        // sans enlever l'élément du vecteur
        Object o = v.get(0);
        Point s = ( Point )o;
        System.out.println(s.getX());

//        Point s1 = (Point)v.get(0);
//        System.out.println(s1.getX());

//        System.out.println(((Point)v.get(0)).getX());



        // afficher la valeur de la donnée y du deuxième élément du vecteur
        // sans enlever l'élément du vecteur

        Object g = v.get(1);
        Point a = ( Point )o;
        System.out.println(s.getY());

        Point p2 = (Point) v.get(1);
        System.out.println(p2.getY());



        // afficher la valeur de la donnée x du troisième élément du vecteur
        // sans enlever l'élément du vecteur
        // ( essayer de le faire en une étape une ligne )

        System.out.println(((Point)v.get(2)).getX());




        // à l'aide d'une boucle, faire le total des valeurs des données x de tous les
        // éléments du vecteur et l'afficher
         double lesX = 0;
         int compteur =0;

            for (int i = 0; i <v.size(); i++ ){
                lesX += ((Point)v.get(i)).getX();
                 compteur += ((Point) (v.get(i))).x;

            }
        System.out.println(lesX);
        System.out.println(compteur);
















    }
}
