package control;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import model.Plateau;
import view.Jeu;

import java.awt.Color;

import java.awt.event.MouseEvent;

public class ControlGraphique {
    
    public ControlGraphique() {}

    public static class Carre extends JPanel implements MouseInputListener {
        private static final long serialVersionUID = 1L;
        Plateau p;
        Jeu affichage;
        
        public Carre(Color color, Plateau p, Jeu a) {
            this.setBounds(100, 200, 50, 50);
            this.p = p;
            this.affichage = a;
            this.setBackground(color);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        // Déclenche l'événement lorsqu'un clique est détecté dans une zone particulière
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.affichage.displayOnClick(this.p.preSupprimer(this.affichage.getPos(this)[0] + 11, this.affichage.getPos(this)[1] + 1, new boolean[p.getHauteur()][p.getLargeur()]));       
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.p.supprimer(this.affichage.getPos(this)[0] + 11, this.affichage.getPos(this)[1] + 1, new boolean[p.getHauteur()][p.getLargeur()]);
            this.p.actualiser();
            this.affichage.reload(p);
            this.affichage.refreshScore(p);
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
            // TODO Auto-generated method stub

        }
    }    
}
