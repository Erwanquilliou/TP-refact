package org.iut.refactoring.refactoring;

import java.util.UUID;

public class ChefDeProjet extends EmployeLongTerme{
    public ChefDeProjet(String name, double salary, int exp,String equipe) {
        super(name,salary,exp,equipe);
        this.setSalaire(calculSalaire(salary));
        this.setBonus(calculBonusAnnuel());
    }
    public ChefDeProjet(UUID id,String name, double salary, int exp,String equipe) {
        super(id,name,salary,exp,equipe);
        this.setSalaire(calculSalaire(salary));
        this.setBonus(calculBonusAnnuel());
    }

    @Override
    public double calculSalaire(double salaireDeBase) {
        if(this.getExperience() <3) {
            return salaireDeBase * 1.5 + 5000;
        }else{
            return salaireDeBase*1.5 *1.1 +5000;
        }
    }

    @Override
    public double calculBonusAnnuel(){
        if(this.getExperience()<=3){
            return this.getSalaireDeBase()*0.2;
        }else{
            return this.getSalaireDeBase()*0.2*1.3;
        }
    }

}
