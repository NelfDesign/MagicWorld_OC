package fr.nelfdesign.partie;

import fr.nelfdesign.personnages.Personnage;
import fr.nelfdesign.personnages.combat;

public class Joueur implements combat {
    String nom;
    Personnage perso = null;
    boolean isInLife =true;

    public boolean isInLife() {
        return isInLife;
    }

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String decrisToi() {
        return perso.getCri() + ", je suis le "+ perso.getClass().getSimpleName() + " " + this.getNom() + " de niveau " + perso.getNiveau() + " je possède " +
                perso.getVie() + " de vitalité, " + perso.getForce() + " de force, " + perso.getAgilite() + " d'agilité et " +
                perso.getIntelligence() + " d'intelligence!";
    }

    public String getNom() {
        return nom;
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    @Override
    public void attaque(Joueur j, int choix, String nomPerso) {
        switch (nomPerso.toLowerCase()){
            case "guerrier":
                switch (choix){
                    case 1 :
                        System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_BASIQUE() + " et inflige " +
                                perso.getForce() + " dommages.");
                        j.getPerso().setVie(j.getPerso().getVie() - perso.getForce());
                        System.out.println(j.getNom() + " perd " + perso.getForce() + " points de vie.");
                        j.isMort();
                        break;
                    case 2 :
                        System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_SPECIALE() + " et inflige "
                                + perso.getForce() * 2 + " dommages.");
                        j.getPerso().setVie(j.getPerso().getVie() - perso.getForce()*2);
                        perso.setVie(perso.getVie() - perso.getForce()/2);
                        System.out.println(j.getNom() + " perd " + perso.getForce() * 2 + " points de vie.");
                        j.isMort();
                        System.out.println(this.getNom() + " perd " + perso.getForce()/2 + " points de vie.");
                        break;
                }
                break;
            case "rodeur":
                switch (choix){
                    case 1 :
                        System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_BASIQUE() + " et inflige " +
                                perso.getAgilite() + " dommages.");
                        j.getPerso().setVie(j.getPerso().getVie() - perso.getAgilite());
                        System.out.println(j.getNom() + " perd " + perso.getAgilite() + " points de vie.");
                        j.isMort();
                        break;
                    case 2 :
                        System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_SPECIALE() + " et gagne "
                                + perso.getAgilite()/2 + " en agilité.");
                        perso.setAgilite(perso.getAgilite() + perso.getAgilite()/2);
                        break;
                }
                break;
            case "mage":
                switch (choix){
                    case 1 :
                        System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_BASIQUE() + " et inflige " +
                                perso.getIntelligence() + " dommages.");
                        j.getPerso().setVie(j.getPerso().getVie() - perso.getIntelligence());
                        System.out.println(j.getNom() + " perd " + perso.getIntelligence() + " points de vie.");
                        j.isMort();
                        break;
                    case 2 :
                        if (perso.getVie() < perso.getNiveau()*5){
                            if (perso.getVie() + perso.getIntelligence()*2 > perso.getNiveau()*5 ){
                                int vieGagne = (perso.getVie()+perso.getIntelligence()*2) - (perso.getNiveau()*5);
                                System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_SPECIALE() + " et gagne "
                                        + vieGagne + " en vitalité.");
                                perso.setVie(perso.getNiveau() * 5);
                            }else {
                                System.out.println(this.getNom() + " utilise " + perso.getATTAQUE_SPECIALE() + " et gagne "
                                        + perso.getIntelligence()*2 + " en vitalité.");
                                perso.setVie(perso.getVie() + perso.getIntelligence()*2);
                            }
                        }
                        break;
                }
                break;
        }
    }

    /**
     * vérifie si le personnage est bien en vie
     */
    private void isMort(){
        if (this.perso.getVie() <= 0){
            this.isInLife = false;
            System.out.println(this.getNom() + " est mort.");
        }
    }
}
