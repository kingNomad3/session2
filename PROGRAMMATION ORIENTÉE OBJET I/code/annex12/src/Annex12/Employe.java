package Annex12;

public class Employe {

    private String nom;
    private double salaireHoraire;
    private double nbreHeuresTRav;
    private double deductions;

    public Employe(String nom, double salaireHoraire, double nbreHeuresTRav, double deductions){
        this.nom = nom;
        this.salaireHoraire = salaireHoraire;
        this.nbreHeuresTRav = nbreHeuresTRav;
        this.deductions = deductions;


    }

    public double salaire(){
        return  salaireHoraire*nbreHeuresTRav - deductions;
    }
}
