import fr.nelfdesign.partie.Joueur;
import fr.nelfdesign.partie.Partie;

public class Main {

    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("joueur 1");
        Joueur joueur2 = new Joueur("joueur 2");

        Partie partie = new Partie();
        joueur1.setPerso(partie.newPersonnage(joueur1));
        System.out.println(joueur1.decrisToi());
        joueur2.setPerso(partie.newPersonnage(joueur2));
        System.out.println(joueur2.decrisToi());

        do {
            if (joueur1.isInLife()){
                partie.tourDeCombat(joueur1, joueur2);
            }
            if (joueur2.isInLife()){
                partie.tourDeCombat(joueur2, joueur1);
            }

        }while (joueur1.isInLife() && joueur2.isInLife());

        if (!joueur1.isInLife()){
            System.out.println(joueur1.getNom() + " a perdu!");
        }else if (!joueur2.isInLife()){
            System.out.println(joueur2.getNom() + " a perdu!");
        }

    }
}
