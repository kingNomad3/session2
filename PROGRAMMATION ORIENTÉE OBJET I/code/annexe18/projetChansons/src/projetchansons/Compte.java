package projetchansons;

import java.util.Vector;

public class Compte {

    private Vector<Chanson> chansonsChoisies;

    public Compte()
    {
        chansonsChoisies = new Vector();
    }

    public Chanson getChansons(int index) {
        return chansonsChoisies.get(index);
    }

    public void ajouterChanson(Chanson chanson){
            chansonsChoisies.add(chanson);
    }
    public void enleverChanson(Chanson chanson) {
        chansonsChoisies.remove(chanson);
    }
    public int nombreDeChansons() {
        return chansonsChoisies.size();
    }

    public Vector<Chanson> grouperChansons(String style) {
        Vector<Chanson> chansonsGroupees = new Vector<Chanson>();

        for (Chanson chanson : chansonsChoisies) {
            if (chanson.getNom().equals(style)) {
                chansonsGroupees.add(chanson);
            }
        }

        return chansonsGroupees;
    }


}
