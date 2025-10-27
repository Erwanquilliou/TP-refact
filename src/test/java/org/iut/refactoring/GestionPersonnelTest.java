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
        assertThat(app.employes.size()).isEqualTo(4);
    }
}