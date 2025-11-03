package org.iut.refactoring.refactoring;

import java.util.UUID;

public abstract class Employe {
    private UUID id;
    private String nom;
    private double salaire;
    private int experience;

    public Employe(String nom, int experience) {
        this.id =  UUID.randomUUID();
        this.nom = nom;
        this.experience = experience;
    }
    public abstract double calculSalaire(double salaireDeBase);
    public double getSalaire() {
        return salaire;
    }
    public UUID getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public int getExperience() {
        return experience;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }


}
