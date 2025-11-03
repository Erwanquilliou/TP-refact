package org.iut.refactoring.refactoring;

import java.util.UUID;

public class Stagiaire extends Employe{
    public Stagiaire(String name, double salary, int exp){
        super(name,salary,exp);
        this.setSalaire(calculSalaire(salary));
    }
    public Stagiaire(UUID id,String name, double salary, int exp){
        super(id,name,salary,exp);
        this.setSalaire(calculSalaire(salary));
    }
    public double calculSalaire(double salaire){
        return salaire*0.6;
    }
}
