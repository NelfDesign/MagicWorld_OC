package fr.nelfdesign.partie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartieTest {

    @Test
    void Given_params_When_validateCarac_Then_false() {
        Partie partie = new Partie();
        int number=100;
        assertEquals(true, partie.validateCarac(number));
    }

    @Test
    void Given_3params_When_validateTotal_Then_false(){
        Partie partie = new Partie();
        int niveau = 10;
        int force = 8;
        int agility = 0;
        int intel = 5;
        assertEquals(false, partie.validateTotal(niveau,force,agility,intel));
    }

    @Test
    void Given_niveau_When_validate_Then_true(){
        Partie partie = new Partie();
        int niveau = 10;
        assertEquals(true, partie.validate(niveau));
    }

    @Test
    void Given_saisie_When_validateSaisie_Then_false(){
        Partie partie = new Partie();
        int choix = 3;
        assertEquals(false, partie.validateSaisie(choix));
    }

    @Test
    void Given_saisieClasse_When_validateSaisieClasse_Then_false(){
        Partie partie = new Partie();
        int choix = 0;
        assertEquals(false, partie.validateSaisieClasse(choix));
    }
}