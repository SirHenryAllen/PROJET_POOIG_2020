package model.Jouer;

import model.Niveau;
import view.AffichageGraphique;

import control.ControlGraphique;

public class JoueurGraphique {

    public static void jouerNiveau(Niveau n) {
        AffichageGraphique visuel = new AffichageGraphique(n.getPlateau());
        visuel.setVisible(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                ControlGraphique control = new ControlGraphique();
                
            }
            
        });
    }   

}
