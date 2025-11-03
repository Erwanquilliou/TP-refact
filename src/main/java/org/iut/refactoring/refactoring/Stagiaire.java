package org.iut.refactoring.refactoring;

public class Stagiaire extends Employe{
    public Stagiaire(String name, double salary, int exp){
        super(name,exp);
        this.setSalaire(calculSalaire(salary));
    }
    public double calculSalaire(double salaire){
        return salaire*0.6;
    }
}
