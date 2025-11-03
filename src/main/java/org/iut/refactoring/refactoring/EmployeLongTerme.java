package org.iut.refactoring.refactoring;

import java.util.UUID;

public abstract class EmployeLongTerme extends Employe{
    double bonus;
    public EmployeLongTerme(String name, int exp) {
        super(name,exp);
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public abstract double calculBonusAnnuel();
}
