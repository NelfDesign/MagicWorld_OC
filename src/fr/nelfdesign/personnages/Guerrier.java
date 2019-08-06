package fr.nelfdesign.personnages;

import fr.nelfdesign.partie.Joueur;

public class Guerrier extends Personnage {

    public Guerrier(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.setVie(niveau*5);
        this.cri = "Woag";
        this.ATTAQUE_BASIQUE = "Coup d'épée";
        this.ATTAQUE_SPECIALE = "Coup de rage";
    }

}
