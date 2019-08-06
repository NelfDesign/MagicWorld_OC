package fr.nelfdesign.personnages;

public class Rodeur extends Personnage {

    public Rodeur(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.setVie(niveau*5);
        this.cri = "Invisible";
        this.ATTAQUE_BASIQUE = "Tir à l'arc";
        this.ATTAQUE_SPECIALE = "Concentration";
    }

}
