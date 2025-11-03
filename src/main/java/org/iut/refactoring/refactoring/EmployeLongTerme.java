package org.iut.refactoring.refactoring;

import java.util.UUID;

public abstract class EmployeLongTerme extends Employe{
    double bonus;
    public EmployeLongTerme(String name,double salaire, int exp,String equipe) {
        super(name,salaire,exp,equipe);
    }
    public EmployeLongTerme(UUID id,String name,double salaire, int exp,String equipe) {
        super(id,name,salaire,exp,equipe);
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public abstract double calculBonusAnnuel();
}
