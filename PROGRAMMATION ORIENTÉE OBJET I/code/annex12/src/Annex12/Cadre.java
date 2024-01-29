package Annex12;

public class Cadre extends Employe{

    private double bonus;

    public Cadre(String nom, double salaireHoraire, double nbreHeuresTRav, double deductions, double bonus) {
        super(nom, salaireHoraire, nbreHeuresTRav, deductions);
        this.bonus = bonus;
    }

    // on doit donc redefinir la methode salaire
    @Override
    public double salaire() {
        return super.salaire()+bonus;//le super distingue la methode de la super classe
    }

    public double greve(){
        // va chercher le salaire dans le super
        return salaire()/5;
    }
}
