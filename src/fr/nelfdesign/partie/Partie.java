package fr.nelfdesign.partie;

import fr.nelfdesign.personnages.Guerrier;
import fr.nelfdesign.personnages.Mage;
import fr.nelfdesign.personnages.Personnage;
import fr.nelfdesign.personnages.Rodeur;

import java.util.Scanner;

public class Partie {
    Personnage perso = null;

    /**
     * fonction de création d'un personnage
     * @param joueur
     * @return le personnage créé
     */
    public Personnage newPersonnage(Joueur joueur) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Création du Personnage du " + joueur.getNom());

        int choix;
        do {
            choix = readInt(sc, "Veuillez choisir la classe de votre personnage :\n" +
                    "1: Guerrier (attaque basée sur la force)\n" +
                    "2: Rôdeur (attaque basée sur l'agilité)\n" +
                    "3: Mage (attaque basée sur l'intelligence)", "Vous devez saisir un nombre. Recommencez..");
        } while (!validateSaisieClasse(choix));

        int niveau;
        do {
            niveau = readInt(sc,
                    "Niveau du personnage entre 1 et 100?",
                    "Le niveau saisie n'est pas un nombre. Recommencez.." );
        }while (!validate(niveau)) ;

            int force, agility, intel;
            do {
                force = readInt(sc,
                        "Force du personnage entre 0 et 100?",
                        "La force saisie n'est pas un nombre. Recommencez..");

                agility = readInt(sc,
                        "Agilité du personnage entre 0 et 100?",
                        "L'agilité saisie n'est pas un nombre. Recommencez..");

                intel = readInt(sc,
                        "Intelligence du personnage entre 0 et 100?",
                        "L'intelligence saisie n'est pas un nombre. Recommencez..");
            } while (!validateCarac(force) || !validateCarac(agility) || !validateCarac(intel) || !validateTotal(niveau, force, agility, intel));

            switch (choix) {
                case 1:
                    perso = new Guerrier(niveau, force, agility, intel);
                    break;
                case 2:
                    perso = new Rodeur(niveau, force, agility, intel);
                    break;
                case 3:
                    perso = new Mage(niveau, force, agility, intel);
                    break;
            }

            return perso;
    }

    /**
     * fonction de déroulement d'un tour de combat entre 2 joueurs
     * @param joueur
     * @param joueur2
     */
    public void tourDeCombat(Joueur joueur, Joueur joueur2){
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = readInt(sc,
                    joueur.getNom() + " (" + joueur.perso.getVie() +" Vitalité) veuillez choisir votre action : \n" +
                            "1: Attaque Basique\n" +
                            "2: Attaque Spéciale",
                    "La saisie n'est pas un nombre. Recommencez..");
        }while (!validateSaisie(choix));

        joueur.attaque(joueur2, choix, joueur.getPerso().getClass().getSimpleName());
    }

    /**
     * vérifie que la somme des caractéristiques est bien égale au niveau
     * @param niveau
     * @param force
     * @param agility
     * @param intel
     * @return vrai si la condition est vérifiée
     */
    boolean validateTotal(int niveau, int force, int agility, int intel) {
        if (force+agility+intel > niveau || force+agility+intel < niveau){
            System.out.println("La somme des caractéristiques doit être égal au niveau du personnage. Recommencez.");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Vérifie que l'utilisateur entre bien un nombre entre 0 et 100
     * @param number nombre à tester
     * @return vrai si la condition est vérifiée
     */
    boolean validateCarac(int number) {
        if (number < 0 || number > 100){
            System.out.println("La force, l'agilité et l'intelligence doivent être compris entre 0 et 100. Recommencez!");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Vérifie que l'utilisateur entre bien un nombre entre 1 et 100
     * @param number nombre à tester
     * @return vrai si la condition est vérifiée
     */
    boolean validate(int number) {
        if (number < 1 || number > 100){
            System.out.println("Le nombre n'est pas compris entre 1 et 100. Recommencez!");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Vérifie que l'utilisateur entre bien les choix proposés
     * @param number  nombre à tester
     * @return vrai si la condition est vérifiée
     */
    boolean validateSaisie(int number) {
        if (number < 1 || number > 2){
            System.out.println("Le nombre saisi doit être 1 ou 2. Recommencez!");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Vérifie que l'utilisateur entre bien les choix proposés
     * @param choix nombre saisie
     * @return vrai si la condition est vérifiée
     */
    boolean validateSaisieClasse(int choix) {
        if (choix < 1 || choix > 3){
            System.out.println("Le nombre saisi doit être compris entre 1 et 3. Recommencez!");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Vérifie que l'utilisateur entre bien un chiffre
     * @param scanner
     * @param prompt message de saisie
     * @param promptOnError message d'erreur si la saisie n'est pas un nombre
     * @return retourne le nombre saisie après vérification
     */
    private static int readInt(Scanner scanner, String prompt, String promptOnError) {

        System.out.println(prompt);

        while ( !scanner.hasNextInt() ) {
            System.out.println(promptOnError);
            scanner.nextLine(); // vidage saisie incorrect
        }

        final int input = scanner.nextInt();
        scanner.nextLine(); // vidage buffer
        return input;
    }
}
