package fr.nelfdesign.personnages;

public abstract class Personnage {

    protected int niveau;
    protected int vie;
    protected int force;
    protected int agilite;
    protected int intelligence;
    protected String cri;
    protected String ATTAQUE_BASIQUE;
    protected String ATTAQUE_SPECIALE;

    public Personnage(int niveau, int force, int agilite, int intelligence) {
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getCri() {
        return cri;
    }

    public String getATTAQUE_BASIQUE() {
        return ATTAQUE_BASIQUE;
    }

    public String getATTAQUE_SPECIALE() {
        return ATTAQUE_SPECIALE;
    }
}
