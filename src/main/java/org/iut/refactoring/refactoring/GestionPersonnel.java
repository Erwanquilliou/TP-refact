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
                emp = new Stagiaire(nom, salaireDeBase, experience);
                break;
            case "DEVELOPPEUR" :
                emp = new Developpeur(nom, salaireDeBase, experience);
                break;
            case "CHEF DE PROJET" :
                emp = new ChefDeProjet(nom, salaireDeBase, experience);
                break;
            default:
                return;
        }
        // Faire une classe employé pour plus de clarté et de maîtrise

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
/*
    public void generationRapport(String typeRapport, String filtre) {
        System.out.println("=== RAPPORT: " + typeRapport + " ===");
        // pas idéal d'utiliser des println
        // il est préférable de faire de l'écriture dans des fichiers
        if (typeRapport.equals("SALAIRE")) {
            for (Employe emp : employes) {
                if (filtre == null || filtre.isEmpty() ||
                        emp[5].equals(filtre)) {
                    String id = (String) emp[0];
                    String nom = (String) emp[2];
                    double salaire = calculSalaire(id);
                    System.out.println(nom + ": " + salaire + " €");
                }
            }
        } else if (typeRapport.equals("EXPERIENCE")) {
            for (Object[] emp : employes) {
                if (filtre == null || filtre.isEmpty() ||
                        emp[5].equals(filtre)) {
                    String nom = (String) emp[2];
                    int exp = (int) emp[4];
                    System.out.println(nom + ": " + exp + " années");
                }
            }
        } else if (typeRapport.equals("DIVISION")) {
            HashMap<String, Integer> compteurDivisions = new HashMap<>();
            for (Object[] emp : employes) {
                String div = (String) emp[5];
                compteurDivisions.put(div, compteurDivisions.getOrDefault(div, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : compteurDivisions.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " employés");
            }
        }
        logs.add(LocalDateTime.now() + " - Rapport généré: " + typeRapport);
        //au lieu de faire des if else sur des chaines de caractère on peut créer 3 classes division,
        //expérience et salaire issue d'une même classe rapport
    }
    */


    public void avancementEmploye(String employeId, String newType) {
        for (int i = 0; i < employes.size(); i++) {
            Employe emp = employes.get(i);
            if (emp.getId().toString().equals(employeId)) {
                Employe nouveauEmp = null;

                switch (newType) {
                    case "STAGIAIRE":
                        nouveauEmp = new Stagiaire(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience());
                        break;
                    case "DEVELOPPEUR":
                        nouveauEmp = new Developpeur(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience());
                        break;
                    case "CHEF DE PROJET":
                        nouveauEmp = new ChefDeProjet(emp.getId(), emp.getNom(), emp.getSalaireDeBase(), emp.getExperience());
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



