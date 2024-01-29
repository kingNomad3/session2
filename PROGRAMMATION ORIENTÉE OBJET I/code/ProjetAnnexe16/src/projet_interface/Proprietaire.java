package projet_interface;

import java.util.GregorianCalendar;

public class Proprietaire {

    private String villeRes;
    private GregorianCalendar dateNaissance;

    public Proprietaire(String villeRes, GregorianCalendar dateNaissance)
    {
        this.villeRes = villeRes;
        this.dateNaissance = dateNaissance;
    }

    public GregorianCalendar getDate ()
    {
        return dateNaissance;
    }
    public String getVille()
    {
        return villeRes;
    }
}
