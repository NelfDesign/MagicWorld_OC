package fr.nelfdesign.personnages;

public class Mage extends Personnage {

    public Mage(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.setVie(niveau*5);
        this.cri = "Abracadabra";
        this.ATTAQUE_BASIQUE = "Boule de feu";
        this.ATTAQUE_SPECIALE = "Soin";
    }

}
