package projetchansons;

public class Test {

    public static void main(String[] args) {
        // Création des objets Chanson
        Chanson chanson1 = new Chanson("La Machine à danser", "La Compagnie créole", "Populaire", "3:45");
        Chanson chanson2 = new Chanson("Tourne la page", "René et Nathalie Simard", "Populaire", "3:03");
        Chanson chanson3 = new Chanson("I'm Gonna Getcha", "Shania Twain", "Country", "4:30");

        // Création du compte
        Compte compte = new Compte();

        // Ajout des chansons dans le compte
        compte.ajouterChanson(chanson1);
        compte.ajouterChanson(chanson2);
        compte.ajouterChanson(chanson3);

        // Affichage du nombre de chansons dans le compte
        System.out.println("Nombre de chansons dans le compte avant : " + compte.nombreDeChansons());

        // Enlever la chanson "Tourne la page" du compte
        compte.enleverChanson(chanson2);

        // Affichage du nombre de chansons dans le compte après suppression
        System.out.println("Nombre de chansons dans le compte apres : " + compte.nombreDeChansons());
    }
}
