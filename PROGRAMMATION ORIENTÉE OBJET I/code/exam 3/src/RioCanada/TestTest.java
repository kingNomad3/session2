package RioCanada;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTest {


    @Test
    public void TestNumeroMagasin(){
            Magasin magasin = new Magasin("LesBananes",100,"Souliers");
            int expectedNumeroMagasin1 = 1;
            int numeroMagasin1 =magasin.getNumeroLocal();
            Magasin magasin2 = new Magasin("LesChauffrettes",100,"Cuisine");
            int expectedNumeroMagasin2 = 2;
            int numeroMagasin2 = magasin.getNumeroLocal(); //string value of not working
            assertEquals(expectedNumeroMagasin2, numeroMagasin2);


    }

    @Test
    public void Construisable() {
        Magasin magasin = new Magasin("Benjaminmorse",10000000,"Peinture");
        MegaCentre megaCentre = new MegaCentre(100);

        assertFalse( megaCentre.contruireMagasin(magasin));

    }

    @Test
    public void nbMagasinselonCategorie() {
        Magasin magasin = new Magasin("Aventures",10000000,"Sport");
        Magasin magasin2 = new Magasin("Sportplex",10000000,"Sport");
        Magasin magasin3 = new Magasin("Chute",10000000,"Sport");



    }

    @Test
    public void memeNomMagasin() {
        Magasin magasin = new Magasin("Aventures",10000000,"Sport");
        Magasin magasin2 = new Magasin("Sportplex",10000000,"Sport");
        Magasin magasin3 = new Magasin("Chute",10000000,"Sport");
        MegaCentre megaCentre = new MegaCentre(100);



        assertFalse(megaCentre.contruireMagasin(magasin));


    }
}