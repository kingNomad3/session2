package Annex18B;
import java.util.Vector;

public class Portefeuille {

    private String nom;
    private String numero;
    private Vector<Investissement> investissementClient;
    private double encaisse;

    public Portefeuille() {
        investissementClient = new Vector<>();
    }

    public Portefeuille(String nom, String numero, Vector<Investissement> investissementClient, double encaisse) {
        this.nom = nom;
        this.numero = numero;
        this.investissementClient = new Vector<>(investissementClient);
        this.encaisse = encaisse;
    }

    public boolean acheterInvestissement (Investissement investissement){
        //verifie s'il y a assez d'argent
        if (investissement.valeurMarchande() <= encaisse){

            //ajouter au vecteur
            investissementClient.add(investissement);
            //soustrait l'achat
            encaisse -= investissement.valeurMarchande();
            return true;
        }else {
            return false;
        }
    }



    public boolean vendreInvestissement (String nomAction){
        //trouver l<investissement a partie de son nom
        for (int i= 0; i< investissementClient.size(); i++){
            //verifie si je la trouve
            if (investissementClient.get(i).getNomAction().equals(nomAction)){
                //ajouter l'argent de la vente a l'encaisse
                encaisse+= investissementClient.get(i).valeurMarchande();
                //enleve du vecteur
                investissementClient.remove(i);
                return true;
            }

        }
        return false;
    }


    public double calculerTotal() {
        double total = encaisse;

        for (int i = 0; i < investissementClient.size(); i++) {
            total += investissementClient.get(i).valeurMarchande();
        }

        return total;
    }

//    public void trierOrdreValeur() {
//        Vector<Investissement> vecteurTemporaire = new Vector<>(investissementClient.size());
//
//        while (!investissementClient.isEmpty()) {
//            Investissement investissementMax = investissementClient.get(0);
//            int indexMax = 0;
//
//            for (int i = 1; i < investissementClient.size(); i++) {
//                Investissement investissement = investissementClient.get(i);
//                if (investissementClient.get(i).valeurMarchande() > investissementClient.get(i-1).valeurMarchande()) {
//                    investissementMax = investissement;
//                    indexMax = i;
//                }
//            }
//
//            investissementClient.remove(indexMax);
//            vecteurTemporaire.add(investissementMax);
//        }
//
//        investissementClient = vecteurTemporaire;
//    }



    public void trierOrdreValeur(){
        Vector <Investissement> vecteurTemp = new Vector<>();

        //pt de comparaison

        double plusGrandeValeur =0;
        int plusGrandValeurIndice =0;

        //le faire tant que le vecteur original n'est pas vide
        while (investissementClient.size() !=0){

            plusGrandeValeur =0;
            plusGrandValeurIndice=0;

            for ( int i = 0 ; i < investissementClient.size(); i++){
              if (investissementClient.get(i).valeurMarchande() > plusGrandeValeur){
                  plusGrandeValeur = investissementClient.get(i).valeurMarchande();
                  plusGrandValeurIndice = i;
              }
            }

            vecteurTemp.add(investissementClient.get(plusGrandValeurIndice));
            investissementClient.remove(plusGrandValeurIndice);

        }
        investissementClient = vecteurTemp;

    }
//  public void vendreInvestissement(String nomAction) {
//        for (int i = 0; i < investissementClient.size(); i++) {
//            if (investissementClient.get(i).getNomAction().equals(nomAction)) {
//                encaisse += investissementClient.get(i).valeurMarchande();
//                investissementClient.remove(i);
//            }
//        }
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Vector<Investissement> getInvestissementClient() {
        return investissementClient;
    }

    public void setInvestissementClient(Vector<Investissement> investissementClient) {
        this.investissementClient = investissementClient;
    }

    public double getEncaisse() {
        return encaisse;
    }

    public void setEncaisse(double encaisse) {
        this.encaisse = encaisse;
    }
}
