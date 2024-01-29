public class Client {

    private String nomDuClient;
    private String telephoneDuClient;
    private int nbVoleAllerRetour;
    private int nbPoints;


    public Client(String nomDuClient, String telephoneDuClient, int nbVoleAllerRetour, int nbPoints){
        this.nomDuClient = nomDuClient;
        this.telephoneDuClient = telephoneDuClient;
        this.nbVoleAllerRetour = nbVoleAllerRetour;
        this.nbPoints = nbPoints;
    }

    public int getNbPoints(){return  nbPoints;}

    public String setTelephoneDuClient(String telephoneDuClient){return telephoneDuClient;}

    public int  acheterBillet (Billet billet){
        nbVoleAllerRetour++;

        if(billet.getPrix() > 1000){
            nbPoints+=400;
        }else{
            nbPoints+=100;
        }
        return nbPoints;
    }
}
