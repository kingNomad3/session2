package xiangqi;

import static org.junit.jupiter.api.Assertions.*;

class Testpartie1 {



    @org.junit.jupiter.api.BeforeEach
    void setUp() {}

    @org.junit.jupiter.api.Test
    void testChar() {
        Char c1 = new Char("c1","noir");
        Position depart = new Position (3,7);
        Position arrivee = new Position(3,4);
        assertTrue(c1.estValide(depart,arrivee));
    }

    @org.junit.jupiter.api.Test
    void testRoi() {
        Roi r = new Roi("r","noir");
        Position depart = new Position(0,4);
        Position arrivee = new Position(2,5);
        assertTrue(r.estValide(depart,arrivee));

        Roi r2 = new Roi("r2","noir");
        Position depart2 = new Position(0,4);
        Position arrivee2 = new Position(3,4);
        assertFalse(r2.estValide(depart2,arrivee2));

        Roi r3 = new Roi("r3", "rouge");
        Position depart3 = new Position(9, 4);
        Position arrivee3 = new Position(8, 5);
        assertTrue(r3.estValide(depart3, arrivee3));

        Roi r4 = new Roi("r4","rouge");
        Position depart4 = new Position(9,4);
        Position arrivee4 = new Position(5,4);
        assertFalse(r4.estValide(depart4,arrivee4));

    }

    @org.junit.jupiter.api.Test
    void testMandarin() {
        Mandarin m1 = new Mandarin("m1","noir");
        Position depart= new Position(0,3);
        Position arrivee = new Position(2,4);
        assertTrue(m1.estValide(depart,arrivee));

        Mandarin m2 = new Mandarin("m2","noir");
        Position depart2= new Position(0,3);
        Position arrivee2 = new Position(3,4);
        assertFalse(m2.estValide(depart2,arrivee2));

        Mandarin m3 = new Mandarin("m3","rouge");
        Position depart3 = new Position(9,3);
        Position arrivee3 = new Position(8,4);
        assertTrue(m3.estValide(depart3,arrivee3));

        Mandarin m4 = new Mandarin("m4","rouge");
        Position depart4 = new Position(9,3);
        Position arrivee4 = new Position(6,4);
        assertFalse(m4.estValide(depart4,arrivee4));
    }

    @org.junit.jupiter.api.Test
    void testElephant() {
        Elephant e1 = new Elephant("e1","noir");
        Position depart= new Position(0,2);
        Position arrivee = new Position(3,4);// a changer
        assertTrue(e1.estValide(depart,arrivee)); // un assert pas methode

        Elephant e2 = new Elephant("e2","noir");
        Position depart2= new Position(0,2);
        Position arrivee2 = new Position(5,4);// a changer
        assertFalse(e2.estValide(depart2,arrivee2)); // un assert pas methode

        Elephant e3 = new Elephant("e3","rouge");
        Position depart3= new Position(9,2);
        Position arrivee3 = new Position(8,4);// a changer
        assertTrue(e3.estValide(depart3,arrivee3)); // un assert pas methode

        Elephant e4 = new Elephant("e4","rouge");
        Position depart4= new Position(9,0);
        Position arrivee4 = new Position(4,6);// a changer
        assertFalse(e4.estValide(depart4,arrivee4)); // un assert pas methode
    }

    @org.junit.jupiter.api.Test
    void testCavalier() {
        Cavalier c1 = new Cavalier("c1","noir");
        Position depart= new Position(0,1);
        Position arrivee = new Position(2,2);// a changer
        assertTrue(c1.estValide(depart,arrivee)); // un assert pas methode

        Cavalier c2 = new Cavalier("c2","noir");
        Position depart2= new Position(0,7);
        Position arrivee2 = new Position(0,2);// a changer
        assertFalse(c2.estValide(depart2,arrivee2)); // un assert pas methode

        Cavalier c3 = new Cavalier("c3","rouge");
        Position depart3= new Position(9,1);
        Position arrivee3 = new Position(2,2);// a changer
        assertTrue(c3.estValide(depart3,arrivee3)); // un assert pas methode


    }


    @org.junit.jupiter.api.Test
    void testPion() {
        Pion p1 = new Pion("p1", "noir");
        Position depart = new Position(3, 0);
        Position arrivee = new Position(4, 0);
        assertTrue(p1.estValide(depart, arrivee));
    }
    @org.junit.jupiter.api.Test
    void testBomBarde() {
        Bombarde b1 = new Bombarde("b1","noir");
        Position depart= new Position(2,1);
        Position arrivee = new Position(3,1);// a changer
        assertTrue(b1.estValide(depart,arrivee)); // un assert pas methode

    }





}