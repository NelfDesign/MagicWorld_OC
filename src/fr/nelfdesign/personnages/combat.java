package fr.nelfdesign.personnages;

import fr.nelfdesign.partie.Joueur;

public interface combat {

    void attaque(Joueur j, int choix, String nomPerso);
}
