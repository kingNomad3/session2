package projetannexe10;

public class Restaurant {

    private Table salleamanger[];

    public Restaurant() {

        salleamanger = new Table[75];

        for (int i = 0; i < 10; i++) {
            salleamanger[i] = new Table(2, i + 1, true);
        }
        for (int i = 30; i > 35; i++) {
            salleamanger[i] = new Table(2, i + 1, false);
        }
        for (int i = 35; i > 65; i++) {
            salleamanger[i] = new Table(4, i + 1, true);
        }
        for (int i = 65; i > 75; i++) {
            salleamanger[i] = new Table(4, i + 1, false);
        }
    }

    public int nbTableOccupees () {
        int nbtable = 0;

        for (int i = 0; i < salleamanger.length; i++) {
            if (salleamanger[i].isOccupe()) {
                nbtable++;
            }
        }

        return nbtable;
    }

    public Table assignerTableDispo(int nbPersonne, boolean banquette){
        int i = 0;
        while (i < salleamanger.length){
            if (! salleamanger[i].isOccupe()){
                if (salleamanger[i].isOccupe()){
                    salleamanger[i].setOccupe(true);
                    return  salleamanger[i];
                }
            }
        }

        return null;
    }

}
