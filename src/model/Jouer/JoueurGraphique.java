package model.Jouer;

import model.Niveau;
import view.Jeu;
import java.io.IOException;

public class JoueurGraphique {

    public static void jouerNiveau(Niveau n){
        Jeu visuel = new Jeu(n.getPlateau());
        visuel.setVisible(true);
    }   

}
