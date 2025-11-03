package org.iut.refactoring.refactoring;

import java.util.*;
import java.time.*;

public class GestionPersonnel {

    public ArrayList<Employe> employes = new ArrayList<>();
    public HashMap<String, Double> salairesEmployes = new HashMap<>();
    public ArrayList<String> logs = new ArrayList<>();

    public void ajouteSalarie(String type, String nom, double salaireDeBase, int experience, String equipe) {
        Employe emp;
        switch(type){
            case "STAGIAIRE":
                emp = new Stagiaire(nom, salaireDeBase, experience,equipe);
                break;
            case "DEVELOPPEUR" :
                emp = new Developpeur(nom, salaireDeBase, experience,equipe);
                break;
            case "CHEF DE PROJET" :
                emp = new ChefDeProjet(nom, salaireDeBase, experience,equipe);
                break;
            default:
                return;
        }


        employes.add(emp);



        salairesEmployes.put(emp.getId().toString(), emp.getSalaire());
        //cette méthode fait trop de chose, ajoute un employé et ajout son salaire dans une map qui n'est même pas
        //utilisé
        logs.add(LocalDateTime.now() + " - Ajout de l'employé: " + nom);
    }

    public double calculSalaire(String employeId) {
        for(Employe e : employes){
            if(e.getId().toString().equals(employeId)) {
                return e.getSalaire();
            }
        }
        System.out.println("ERREUR: impossible de trouver l'employé");
        return 0;
    }

    public void generationRapport(String typeRapport, String filtre) {
        System.out.println("=== RAPPORT: " + typeRapport + " ===");
        // pas idéal d'utiliser des println
        // il est préférable de faire de l'écriture dans des fichiers
        Rapport r = null;
        if (typeRapport.equals("SALAIRE")) {
            r = new RapportSalaire();
        } else if (typeRapport.equals("EXPERIENCE")) {
            r = new RapportExperience();
        } else if (typeRapport.equals("DIVISION")) {
            r = new RapportDivision();
        }
        if(r!= null) {
            r.generationRapport(employes,filtre);
            logs.add(LocalDateTime.now() + " - Rapport généré: " + typeRapport);
        }else{
            System.out.println("ERREUR: impossible de générer le rapport");
        }
    }



    public void avancementEmploye(String employeId, String newType) {
        for (int i = 0; i < employes.size(); i++) {
            Employe emp = employes.get(i);
            if (emp.getId().toString().equals(employeId)) {
                Employe nouveauEmp = null;

                switch (newType) {
                    case "STAGIAIRE":
                        nouveauEmp = new Stagiaire(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience(),emp.getEquipe());
                        break;
                    case "DEVELOPPEUR":
                        nouveauEmp = new Developpeur(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience(),emp.getEquipe());
                        break;
                    case "CHEF DE PROJET":
                        nouveauEmp = new ChefDeProjet(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience(),emp.getEquipe());
                        break;
                    default:
                        return;
                }

                employes.set(i, nouveauEmp);

                salairesEmployes.put(nouveauEmp.getId().toString(), nouveauEmp.getSalaire());
                logs.add(LocalDateTime.now() + " - Employé promu: " + newType);

                System.out.println("Employé promu avec succès!");
                return;
            }
        }

        System.out.println("ERREUR: impossible de trouver l'employé");
    }
/*
    public ArrayList<Object[]> getEmployesParDivision(String division) {
        ArrayList<Object[]> resultat = new ArrayList<>();
        for (Object[] emp : employes) {
            if (emp[5].equals(division)) {
                resultat.add(emp);
            }
        }
        return resultat;
    }

 */

    public void printLogs() {
        System.out.println("=== LOGS ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }



    public double calculBonusAnnuel(String employeId) {
        Employe emp = null;
        for (Employe e : employes) {
            if (e.getId().toString().equals(employeId)) {
                emp = e;
                break;
            }
        }
        if (emp == null) return 0;
        if(emp instanceof EmployeLongTerme){
            return ((EmployeLongTerme) emp).getBonus();
        }else{
            return 0;
        }

    }
}

// cette classe fait trop de choses (affichage / code métier création de données ..)
// non respect des principes SRP



