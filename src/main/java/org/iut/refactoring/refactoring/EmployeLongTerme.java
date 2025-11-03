package org.iut.refactoring.refactoring;

import java.util.UUID;

public abstract class EmployeLongTerme extends Employe{
    double bonus;
    public EmployeLongTerme(String name,double salaire, int exp) {
        super(name,salaire,exp);
    }
    public EmployeLongTerme(UUID id,String name,double salaire, int exp) {
        super(id,name,salaire,exp);
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public abstract double calculBonusAnnuel();
}
