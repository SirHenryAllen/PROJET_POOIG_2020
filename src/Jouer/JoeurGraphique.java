package Jouer;

import model.Niveau;
import view.AffichageGraphique;

public class JoeurGraphique {

    public static void jouerNiveau(Niveau n) {
        AffichageGraphique visuel = new AffichageGraphique(n.getPlateau());
        visuel.setVisible(true);
    }   

}
