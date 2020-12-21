package model.Jouer;

import model.Niveau;
import view.AffichageGraphique;

public class JoueurGraphique {

    public static void jouerNiveau(Niveau n) {
        
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
