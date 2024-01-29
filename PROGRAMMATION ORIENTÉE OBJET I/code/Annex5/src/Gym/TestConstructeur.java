package Gym;

public class TestConstructeur {

    public static void main(String[] args) {

        gym a =  new gym("Annie");
        gym b = new gym("Alice", 23);
        System.out.println(a.getPrix());
        System.out.println(b.getPrix() +"$");
        a.setPrix(10);
        System.out.println(a.getPrix());


    }
}
