package model.Jouer;

import control.ControlShell;
import model.Niveau;
import view.AffichageShell;

public class JouerShell {
    
    public static void jouerNiveau(Niveau n) {
        ControlShell control = new ControlShell();
        while(n.getPlateau().checkAnimaux() == false) {
            AffichageShell.afficherFormatPlateau(n.getPlateau());
            control.selectionner(n);
            n.getPlateau().actualiser();
        }
        System.out.println("\n      Gagné ! Félicitations !\n");
        AffichageShell.afficherFormatPlateau(n.getPlateau());
    }


}
