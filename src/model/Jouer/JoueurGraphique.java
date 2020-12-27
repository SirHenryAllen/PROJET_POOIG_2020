package model.Jouer;

import model.Niveau;
import view.Jeu;
import java.io.IOException;

public class JoueurGraphique {

    public static void jouerNiveau(Niveau n){
        
        //Construction de l'affichage
        Jeu visuel = new Jeu(n.getPlateau());
        visuel.setVisible(true);
        /* javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                ControlGraphique control = new ControlGraphique();
                
            }
            
        }); */
    }   

}
