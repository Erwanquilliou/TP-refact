package org.iut.refactoring.refactoring;

public class ChefDeProjet extends EmployeLongTerme{
    public ChefDeProjet(String name, double salary, int exp) {
        super(name, exp);
        this.setSalaire(calculSalaire(salary));
        this.setBonus(calculBonusAnnuel());
    }

    @Override
    public double calculSalaire(double salaireDeBase) {
        if(this.getExperience() <3) {
            return salaireDeBase * 1.5 + 5000;
        }else{
            return salaireDeBase*1.5 *1.3 +5000;
        }
    }

    @Override
    public double calculBonusAnnuel(){
        if(this.getExperience()<=3){
            return this.getSalaire()*0.2;
        }else{
            return this.getSalaire()*0.2*1.3;
        }
    }

}
