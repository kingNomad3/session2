package Banque;

public class TestBanque {

    public static void main(String[] args) {

        Banque a = new Banque("Flavien", 100);
        Banque b = new Banque("Denise", 36.78);
        System.out.println(a.getNom());
        System.out.println(a.getSolde());


    }
}