package Annex18B;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Investissement {
    private int nbAction;
    private String nomAction;
    private String symbole;
    private double prixAction;

    public Investissement(int nbAction, String nomAction, double prixAction) {
        this.nbAction = nbAction;
        this.nomAction = nomAction;
        this.prixAction = prixAction;

        symbole="";

        for (int i =0; i <nomAction.length(); i++){
            if (Character.isUpperCase(nomAction.charAt(i))){
                symbole+= nomAction.charAt(i);
            }
        }

//        Pattern p = Pattern.compile("[A-Z]");
//        Matcher m = p.matcher(nomAction);
//        while (m.find()) //tant que je trouve une lette majuscule
//            symbole+= nomAction.charAt(m.start());

    }

    public int getNbAction() {
        return nbAction;
    }

    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public double getPrixAction() {
        return prixAction;
    }

    public void setPrixAction(double prixAction) {
        this.prixAction = prixAction;
    }

    public double valeurMarchande(){
        return nbAction * prixAction;
    }


}
