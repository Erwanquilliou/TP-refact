package org.iut.refactoring.refactoring;

import java.util.List;

public class RapportExperience implements Rapport{
    @Override
    public void generationRapport(List<Employe> employes, String filtre) {
        for (Employe emp : employes) {
            if (filtre == null || filtre.isEmpty() ||
                    emp.getEquipe().equals(filtre)) {
                String nom = emp.getNom();
                int exp = emp.getExperience();
                System.out.println(nom + ": " + exp + " années");
            }
        }
    }
}
