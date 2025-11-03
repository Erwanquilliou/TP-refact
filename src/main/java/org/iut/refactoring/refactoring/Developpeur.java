package org.iut.refactoring.refactoring;

public class Developpeur extends EmployeLongTerme{
    public Developpeur(String name,double salaire,int exp){
        super(name,exp);
        this.setSalaire(calculSalaire(salaire));
        this.setBonus(calculBonusAnnuel());
    }
    @Override
    public double calculSalaire(double salaireDeBase) {
        if(this.getExperience() <=5) {
            return salaireDeBase * 1.2;
        }else{
            if(this.getExperience()<=10){
                return salaireDeBase * 1.2*1.15;
            }else{
                return salaireDeBase * 1.2*1.15*1.05;
            }
        }
    }

    @Override
    public double calculBonusAnnuel(){
        if(this.getExperience()<=5){
            return this.getSalaire()*0.1;
        }else{
            return this.getSalaire()*0.1*1.5;
        }
    }
}
