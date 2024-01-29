package packageTP1;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEmploye2
{
    private Employe unEmploye;

    @Before
    public void setUp ()
    {
        //nom,     numero,  salaireHoraire, nbreHeures, ancienneté
        unEmploye = new Employe ( "Cloutier", "323",       12.60,           32,          4   );
    }
    @Test
    public void testSalaireBrut ()
    {
       assertEquals ( 403.20, unEmploye.salaireBrut(), 0.02 );
    }
    @Test
    public void testsalaireNetAvantImpot ()
    {
        assertEquals ( 332.96, unEmploye.salaireNetAvantImpot(), 0.02 );
    }
    @Test
    public void testsalaireNetApresImpot() {assertEquals ( 203.11, unEmploye.salaireNetApresImpot(), 0.02 );}
    @Test
    public void testjoursVacances ()
    {
        assertEquals ( 19, unEmploye.joursVacances());
    }
    @Test
    public void testimpotFederal() {assertEquals ( 63.26, unEmploye.impotFederal(), 0.02);}
}
