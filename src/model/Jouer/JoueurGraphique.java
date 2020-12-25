package model.Jouer;

import model.Niveau;
import view.AffichageGraphique;
import java.io.IOException;

public class JoueurGraphique {

    public static void jouerNiveau(Niveau n) throws IOException{
        
        //Construction de l'affichage
        AffichageGraphique visuel = new AffichageGraphique(n.getPlateau());
        visuel.setVisible(true);
        /* javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                ControlGraphique control = new ControlGraphique();
                
            }
            
        }); */
    }   

}
