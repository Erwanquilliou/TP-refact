package org.iut.refactoring.refactoring;

import java.util.List;

public class RapportSalaire implements Rapport{
    @Override
    public void generationRapport(List<Employe> employes,String filtre) {
        System.out.println("=== RAPPORT: SALAIRE ===");
        for (Employe emp : employes) {
            if (filtre == null || filtre.isEmpty() ||
                    emp.getEquipe().equals(filtre)) {
                String id = emp.getId().toString();
                String nom = emp.getNom();
                double salaire = emp.getSalaire();
                System.out.println(nom + ": " + salaire + " €");
            }
        }
    }
}
