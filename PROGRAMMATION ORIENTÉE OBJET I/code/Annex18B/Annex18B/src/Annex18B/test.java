package Annex18B;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Objects;
import java.util.Vector;


public class test {


    @Test
    public void testCalculerValeurMarchandeInvestissement() {
        Investissement investissement = new Investissement(5, "Action ABC", 20.0);
        double expectedValeurMarchande = 5 * 20.0;
        double actualValeurMarchande = investissement.valeurMarchande();
        assertEquals(expectedValeurMarchande, actualValeurMarchande, 0.01);
    }

    @Test
    public void testCalculerTotal() {
        Portefeuille portefeuille = new Portefeuille();

        Investissement investissement1 = new Investissement(5, "Action ABC", 20.0);
        Investissement investissement2 = new Investissement(10, "Action XYZ", 50.0);

        portefeuille.setEncaisse(700.0); // Set the initial encaisse value

        portefeuille.acheterInvestissement(investissement1);
        portefeuille.acheterInvestissement(investissement2);

        double expectedTotal = 100.0 + (5 * 20.0) + (10 * 50.0); // Include the initial encaisse
        double actualTotal = portefeuille.calculerTotal();
        assertEquals(expectedTotal, actualTotal, 0.01);
    }


    @Test
    public void testAcheterInvestissement() {
        Portefeuille portefeuille = new Portefeuille();

        Investissement investissement = new Investissement(5, "Action ABC", 20.0);
        assertTrue(portefeuille.acheterInvestissement(investissement));

        assertTrue(portefeuille.getInvestissementClient().contains(investissement));

        Investissement nonExistingInvestissement = new Investissement(10, "Action XYZ", 50.0);
        assertFalse(portefeuille.acheterInvestissement(nonExistingInvestissement));
        assertFalse(portefeuille.getInvestissementClient().contains(nonExistingInvestissement));
    }


    @Test
    public void testGenererSymbole() {
        Investissement investissement = new Investissement(10, "Action XYZ", 50.0);
        String expectedSymbol = "AXYZ";
        String actualSymbol = investissement.getSymbole();
        assertEquals(expectedSymbol, actualSymbol);
    }
}
