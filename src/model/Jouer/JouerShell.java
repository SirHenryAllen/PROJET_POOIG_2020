package model.Jouer;

import java.util.Scanner;

import control.ControlShell;
import model.Groupe;
import model.Niveau;
import view.AffichageShell;

public class JouerShell {
    
    public static void jouerNiveau(Groupe g) {
        ControlShell control = new ControlShell();
        Scanner read = new Scanner(System.in);
        Niveau n = evalNiveau(read, g);

        while (!(n.getPlateau().checkAnimaux())) {
            AffichageShell.afficherFormatPlateau(n.getPlateau());
            control.selectionner(n);
            n.getPlateau().actualiser();
        }
        System.out.println("\n      Gagné ! Félicitations !\n");
        AffichageShell.afficherFormatPlateau(n.getPlateau());
    }

    public static Niveau evalNiveau(Scanner read, Groupe g) {
		System.out.println("Choisissez votre niveau :\n - 0 : Random\n - 1 : Niveau 1\n - 2 : Niveau 2\n - 3 : Niveau 3\n - 4 : Niveau 4");
        int val = read.nextInt();
        switch(val) {
            case 0: return g.getNiveaux().get(0);
            case 1: return g.getNiveaux().get(1);
            case 2: return g.getNiveaux().get(2);
            case 3: return g.getNiveaux().get(3);
            case 4: return g.getNiveaux().get(4);
            default: return g.getNiveaux().get(0);
        }
	}
}
