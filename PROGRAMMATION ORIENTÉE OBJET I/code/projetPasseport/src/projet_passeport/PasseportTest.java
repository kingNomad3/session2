package projet_passeport;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PasseportTest {
    @Test
    public void testerPasseportVide()
    {
        // créer un passeport vide
        Passeport p = new Passeport();

        assertEquals(0, p.possibleDAvoirAutreDose());
    }

    @Test
    public void testerPasseportPossible()
    {
        // créer un passeport vide
        Passeport p = new Passeport();
        //ajouter une Dose datant du 8 novembre 2021, Moderna
        Dose d = new Dose("Moderna", new GregorianCalendar(2021, 10, 8));
        assertTrue(p.ajouterDose(d));
    }

    @Test
    public void testerPasseportDejaPlein()
    {
        Dose[] doses = new Dose[3];
        doses[0] = new Dose ( "Moderna", new GregorianCalendar(2021, 4, 21));
        doses[1] = new Dose ( "Pfizer", new GregorianCalendar(2022, 6,7));
        doses[2] = new Dose("Pfizer", new GregorianCalendar(2023, 1, 14));
        Passeport p = new Passeport(doses);
        assertEquals(-1, p.possibleDAvoirAutreDose());
    }
    @Test
    public void testerPasseportVaccinTrotTot()
    {
        Dose[] doses = new Dose[3];
        doses[0] = new Dose ( "Moderna", new GregorianCalendar(2021, 6, 21));
        doses[1] = new Dose ( "Pfizer", new GregorianCalendar(2023, 1,7));

        Passeport p = new Passeport(doses);
        assertFalse( p.ajouterDose(new Dose("Pfizer", new GregorianCalendar())));
    }
    @Test
    public void testerPasseportVaccinTrotTot2()
    {
        Dose[] doses = new Dose[3];
        doses[0] = new Dose ( "Moderna", new GregorianCalendar(2022, 10, 1));


        Passeport p = new Passeport(doses);
        assertTrue( p.ajouterDose(new Dose("Pfizer", new GregorianCalendar())));
    }


}