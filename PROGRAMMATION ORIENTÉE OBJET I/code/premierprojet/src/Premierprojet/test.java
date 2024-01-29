package Premierprojet;

public class test {

    public static void main(String[] args) {
        Ordinateur o = new Ordinateur();
        o.code = "FAFSA";
        o.marque = "Dell";
        o.local = "C408";
        o.ram = 32;

        System.out.println(o.local);

        o.setlocal("a745");
        System.out.println(o.local);

    }


}
