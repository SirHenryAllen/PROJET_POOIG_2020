package view;

import model.Animaux;
import model.BlockDestructible;
import model.BlockFixe;
import model.BlockSpecial;
import model.Plateau;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class AffichageGraphique extends JFrame  {
    private static final long serialVersionUID = 1L;
    private JPanel playPanel;
    private Carre[][] pan;

    public AffichageGraphique(Plateau p) throws IOException{

        this.setTitle("PetRescue");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.playPanel = new JPanel();

        GridLayout alignBlock = new GridLayout(10,10);
        playPanel.setLayout(alignBlock);

        this.pan = new Carre[10][10];

        construct(p);
    }

    // Construit le tableau de blocks (visuellement).
    public void construct(Plateau p) {
        for (int i = 0 ; i < this.pan.length ; i++) {
            for (int j = 0 ; j < this.pan.length ; j++) {
                if (p.getBlock(i+11, j+1) instanceof BlockDestructible) {
                    if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'a') {
                        this.pan[i][j] = new Carre(new Color(249, 238, 3), p);  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'b') {
                        this.pan[i][j] = new Carre(new Color(51, 162, 255), p);  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'c') {
                        this.pan[i][j] = new Carre(new Color(70, 188, 2), p);  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'd') {
                        this.pan[i][j] = new Carre(new Color(207, 7, 38), p);
                    }
                }   
                else if (p.getBlock(i+11, j+1) instanceof BlockFixe) {
                    if (((BlockFixe)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new Carre(new Color(0, 0, 0), p);
                    }
                }
                else if (p.getBlock(i+11, j+1) instanceof Animaux) {
                    if (((Animaux)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new Carre(new Color(140, 138, 138), p); 
                    }                   
                }
                else if (p.getBlock(i+11, j+1) == null) {
                    this.pan[i][j] = new Carre(new Color(255, 255, 255), p);  
                }
                this.playPanel.add(this.pan[i][j]);       
            }
        }
        this.getContentPane().add(this.playPanel);
    }

    // Actualise l'affichage graphique des éléments
    public void reload(Plateau p) {
        for (int i = 0 ; i < this.pan.length ; i++) {
            for (int j = 0 ; j < this.pan.length ; j++) {
                if (p.getBlock(i+11, j+1) instanceof BlockDestructible) {
                    if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'a') {
                        this.pan[i][j].setBackground(new Color(249, 238, 3));
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'b') {
                        this.pan[i][j].setBackground(new Color(51, 162, 255));  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'c') {
                        this.pan[i][j].setBackground(new Color(70, 188, 2)); 
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'd') {
                        this.pan[i][j].setBackground(new Color(207, 7, 38));
                    }
                }   
                else if (p.getBlock(i+11, j+1) instanceof BlockSpecial) {
                    /* if ((BlockSpecial)p.getBlock(i+11, j+1).getType() == 'a') {
                        this.pan[i][j].setBackground(new Color(194, 14, 209));
                    } 
                    else if ((BlockSpecial)p.getBlock(i+11, j+1).getType() == 'b') {

                    } */
                }
                else if (p.getBlock(i+11, j+1) instanceof BlockFixe) {
                    if (((BlockFixe)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j].setBackground(new Color(0, 0, 0));
                    }
                }
                else if (p.getBlock(i+11, j+1) instanceof Animaux) {
                    if (((Animaux)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j].setBackground(new Color(140, 138, 138)); 
                    }                   
                }
                else if (p.getBlock(i+11, j+1) == null) {
                    this.pan[i][j].setBackground(new Color(255, 255, 255));  
                }
                this.playPanel.add(this.pan[i][j]);       
            }
        }        
    }

    public Carre getCarre(int x, int y) {
        return this.pan[x][y];
    }

    public int[] getPos(Carre c) {
        int[] t = new int[2];
        for (int i = 0 ; i < this.pan.length ; i++) {
            for (int j = 0 ; j < this.pan.length ; j++) {
                if (this.pan[i][j] == c) {
                    t[0] = i; t[1] = j;
                    return t;
                }
            }
        }
        return t;
    }

    public class Carre extends JPanel implements MouseInputListener {
        private static final long serialVersionUID = 1L;
        Plateau p;
        
        public Carre(Color color, Plateau p) {
            this.setBounds(100, 200, 50, 50);
            this.p = p;
            this.setBackground(color);
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        // Déclenche l'événement lorsqu'un clique est détecté dans une zone particulière
        @Override
        public void mouseClicked(MouseEvent e) {
            this.p.supprimer(getPos(this)[0] + 11, getPos(this)[1] + 1, new boolean[p.getHauteur()][p.getLargeur()]);
            this.p.actualiser();
            reload(p);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //TODO
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //TODO
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