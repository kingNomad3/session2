package packageTP1;

public class Employe {
    // données
    private String nom;
    private String numero;
    private double salaireHoraire;
    private double nbreHeuresSemaine;
    private int anciennete;
    private  double heuresSup;


    // constantes
    public static final double ASSURANCE_EMPLOI = 0.111;
    public static final double FOND_DE_PENSION =  0.0136;
    public static final byte COTISATION_SYNDICALE = 20;
    public static final double IMPOT_FEDERAL = 0.19;
    public static final double IMPOT_PROVINCIAL = 0.2;

    // méthode constructeur
    public Employe(String nom, String numero, double salaireHoraire, double nbreHeuresSemaine, int anciennete)
    {
        this.nom = nom;
        this.numero = numero;
        this.salaireHoraire = salaireHoraire;
        this.nbreHeuresSemaine = nbreHeuresSemaine;
        this.anciennete = anciennete;
    }

    //methode
    public double salaireBrut(){
        return   nbreHeuresSemaine * salaireHoraire;
}

    public double salaireNetAvantImpot()  {
         double salaireAss = 0;
         double salairePen = 0;

        salaireAss = salaireBrut() * ASSURANCE_EMPLOI;
        salairePen = salaireBrut() * FOND_DE_PENSION;
        return  salaireBrut() - salaireAss - salairePen - COTISATION_SYNDICALE;
    }

    public double impotFederal(){return  salaireNetAvantImpot() * IMPOT_FEDERAL;}

    public double impotProvincial(){
        return  salaireNetAvantImpot() *IMPOT_PROVINCIAL;
    }

    public double salaireNetApresImpot(){
       return  salaireNetAvantImpot() - impotProvincial() - impotFederal();
    }

    //permet d'identifier le premier chiffre du numero d'employe avec le charAT et retourne le nombre de jour de vacances
    public int joursVacances(){
        int premierChiffre = Character.getNumericValue(numero.charAt(0));

        int nbJoursVacances = 0;
        char classEmploye = ' ';

        switch (premierChiffre){

            case 1:
                classEmploye = 'A';
                nbJoursVacances = 5 + anciennete;
                break;
            case 2:
                classEmploye = 'B';
                nbJoursVacances = 10 + anciennete;
                break;
            case 3:
                classEmploye = 'C';
                nbJoursVacances = 15 + anciennete;
                break;
            case 4:
                classEmploye = 'D';
                nbJoursVacances = 20 + anciennete;
                break;
        }
        return nbJoursVacances;

    }
    public void heuresSup(int heuresSup){nbreHeuresSemaine += heuresSup;}
}

