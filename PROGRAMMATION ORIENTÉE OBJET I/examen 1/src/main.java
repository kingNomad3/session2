public class main {

public static void main(String[] args){
    Billet a = new Billet("R7-555",800);
    Billet b = new Billet("R7-976",1400);
    Client c = new Client("Benjamin","514-685-77186",6,12);

    System.out.println(c.acheterBillet((b)));
}
}
