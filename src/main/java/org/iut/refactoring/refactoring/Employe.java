package org.iut.refactoring.refactoring;

import java.util.UUID;

public abstract class Employe {
    private UUID id;
    private String nom;
    private double salaire;
    private double salaireDeBase;
    private int experience;
    private String equipe;

    public Employe(String nom,double salaireDeBase, int experience,String equipe) {
        this.id =  UUID.randomUUID();
        this.nom = nom;
        this.salaireDeBase = salaireDeBase;
        this.experience = experience;
        this.equipe = equipe;
    }
    public Employe(UUID id, String nom,double salaireDeBase, int experience,String equipe) {
        this.id = id;
        this.nom = nom;
        this.salaireDeBase = salaireDeBase;
        this.experience = experience;
        this.equipe = equipe;
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
    public double getSalaireDeBase() {
        return salaireDeBase;
    }
    public String getEquipe() {
        return equipe;
    }


}
