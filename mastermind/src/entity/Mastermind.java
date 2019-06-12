package entity;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    private static char OK = 'o';
    private static char FAUX = 'x';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nbCouleurs = 4;
        int nbCouleursMax = 4;
        int tentativesMax = 12;

        int[] solution = new int[nbCouleurs];

        Random r = new Random();
        for (int i = 0; i < nbCouleurs; i++) {
            solution[i] = r.nextInt(nbCouleursMax+1);
        }

        int compteur = 0;

        int[] couleurs = new int[nbCouleurs];
        boolean victoire = false;
        do {
            System.out.println("\nEssai n° " + (compteur + 1) + "/" + tentativesMax + " :");
            int couleurEntrée = sc.nextInt();

            for (int i = 0; i < nbCouleurs; i++)
                couleurs[i] = (int) (couleurEntrée / (Math.pow(12, (nbCouleurs - i - 1)))) % 12;

            for (int i = 0; i < nbCouleurs; i++)
                System.out.print(couleurs[i] + " ");
            System.out.println();

            victoire = true;
            for (int i = 0; i < nbCouleurs; i++) {
                boolean bonneCouleur = couleurs[i] == solution[i];
                System.out.print( (bonneCouleur ? OK : FAUX) + " ");
                victoire = victoire && bonneCouleur;
            }
            System.out.println();
            compteur++;

            sc.close();

        }
    }
}
