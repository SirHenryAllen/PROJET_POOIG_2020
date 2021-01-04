package control;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.event.MouseEvent;

import model.Plateau;
import view.Jeu;



public class ControlGraphique {

    public ControlGraphique() {}

    public static class Carre extends JPanel implements MouseInputListener {
        private static final long serialVersionUID = 1L;
        private Plateau p;
        private Jeu affichage;

        // Création d'un carré à ajouter dans la view du Jeu
        public Carre(Color color, Plateau p, Jeu a) {
            this.setBounds(100, 200, 50, 50);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.p = p;
            this.affichage = a;
            this.setBackground(color);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {} 

        // Lorsque la souris est juste pressée
        @Override
        public void mousePressed(MouseEvent e) {
            // On repeint les carrés qui seront plus tard supprimés en blanc pour donner une impression visuelle de suppression
            this.affichage.displayOnClick(this.p.preSupprimer(this.affichage.getPos(this)[0] + 11, this.affichage.getPos(this)[1] + 1, new boolean[p.getHauteur()][p.getLargeur()]));         
        }

        // Lorsque la souris est relachée
        @Override
        public void mouseReleased(MouseEvent e) {
            // On déclenche l'event de supprimession des bloques associés au bloque cliqué dans le tableau de Block[][] (class Plateau)
            this.p.supprimer(this.affichage.getPos(this)[0] + 11, this.affichage.getPos(this)[1] + 1, new boolean[p.getHauteur()][p.getLargeur()]);
            // On actualise le tableau de Block[][] (class Plateau) afin de faire "tomber" les bloques se trouvant éventuellement au dessus de bloques null
            this.p.actualiser();
            // On actualise de tablau de Carre[][] pour rafraichir l'affichage graphique
            this.affichage.reload(p);
            // On rafraîchit le score courant 
            this.affichage.refreshScore(p);
            // On rafraîchit le meilleur score si : score courant > meilleur score
            this.affichage.refreshHighScore(p);
            // On vérifit si le niveau et gagnant
            this.affichage.win(p);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //TODO
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //TODO
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //TODO
        }
    }    
}
