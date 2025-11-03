package org.iut.refactoring;

import org.iut.refactoring.refactoring.GestionPersonnel;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class GestionPersonnelTest {
    GestionPersonnel app = new GestionPersonnel();

    @Test
    @DisplayName("Test pour ajouter un salarié dans une équipe")
    void test1() {
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 6, "IT");
        app.ajouteSalarie("CHEF DE PROJET", "Bob", 60000, 4, "RH");
        app.ajouteSalarie("STAGIAIRE", "Charlie", 20000, 0, "IT");
        app.ajouteSalarie("DEVELOPPEUR", "Dan", 55000, 12, "IT");
        assertThat(app.employes).hasSize(4);
    }

    @Test
    @DisplayName("test calculer salaire Dev")
    void test2() {
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 0, "IT");
        String id =app.employes.get(0).getId().toString();
        assertThat(app.calculSalaire(id)).isEqualTo(60000);
    }

    @Test
    @DisplayName("test calculer salaire stagiaire")
    void test3() {
        app.ajouteSalarie("STAGIAIRE", "Alice", 50000, 0, "IT");
        String id = app.employes.get(0).getId().toString();
        assertThat(app.calculSalaire(id)).isEqualTo(30000);
    }

    @Test
    @DisplayName("test caclul salaire dev avec experience")
    void test4() {
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 15, "IT");
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 6, "IT");

        // la structure va changer
        String id =app.employes.get(0).getId().toString();
        String id2 =app.employes.get(1).getId().toString();
        assertThat(app.calculSalaire(id)).isEqualTo((60000*1.15*1.05));
        assertThat(app.calculSalaire(id2)).isEqualTo((60000*1.15));
    }
    @Test
    @DisplayName("test calcul salaire chef proj avec / sans experience")
    void test5() {
        app.ajouteSalarie("CHEF DE PROJET", "Alice", 50000, 0,"IT");
        app.ajouteSalarie("CHEF DE PROJET", "Alice", 50000, 6, "IT");
        String id =app.employes.get(0).getId().toString();
        String id2 =app.employes.get(1).getId().toString();
        assertThat(app.calculSalaire(id)).isEqualTo((50000*1.5+5000));
        assertThat(app.calculSalaire(id2)).isEqualTo((50000*1.5*1.1+5000));
    }

    @Test
    @DisplayName("test calcul salaire avancement métier")
    void test6() {
        app.ajouteSalarie("CHEF DE PROJET", "Alice", 50000, 0,"IT");
        String id =app.employes.get(0).getId().toString();
        app.avancementEmploye(id,"STAGIAIRE");
        assertThat(app.calculSalaire(id)).isEqualTo((50000*0.6));
    }
    @Test
    @DisplayName("test bonus annuel dev")
    void test7() {
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 0,"IT");
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 6,"IT");
        String id =app.employes.get(0).getId().toString();
        String id2 =app.employes.get(1).getId().toString();
        assertThat(app.calculBonusAnnuel(id)).isEqualTo((50000*0.1));
        assertThat(app.calculBonusAnnuel(id2)).isEqualTo(((50000*0.1)*1.5));
    }
    @Test
    @DisplayName("test bonus annuel chef de projet")
    void test8() {
        app.ajouteSalarie("CHEF DE PROJET", "Alice", 50000, 0,"IT");
        app.ajouteSalarie("CHEF DE PROJET", "Alice", 50000, 4,"IT");
        String id =app.employes.get(0).getId().toString();
        String id2 =app.employes.get(1).getId().toString();
        assertThat(app.calculBonusAnnuel(id)).isEqualTo((50000*0.2));
        assertThat(app.calculBonusAnnuel(id2)).isEqualTo(((50000*0.2)*1.3));
    }
    @Test
    @DisplayName("test bonus annuel stagiare")
    void test9() {
        app.ajouteSalarie("STAGIAIRE", "Alice", 50000, 0,"IT");
        app.ajouteSalarie("STAGIAIRE", "Alice", 50000, 4,"IT");
        String id =app.employes.get(0).getId().toString();
        String id2 =app.employes.get(1).getId().toString();
        assertThat(app.calculBonusAnnuel(id)).isEqualTo(0);
        assertThat(app.calculBonusAnnuel(id2)).isEqualTo(0);
    }
}