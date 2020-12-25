package view;

import model.Block.Animaux;
import model.Block.BlockDestructible;
import model.Block.BlockFixe;
import model.Block.BlockSpecial;
import model.Plateau;
import control.ControlGraphique.Carre;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.*;

public class Jeu extends JFrame  {
    private static final long serialVersionUID = 1L;
    private JPanel playPanel;
    private Carre[][] pan;

    public Jeu(Plateau p) {

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
                        this.pan[i][j] = new Carre(new Color(249, 238, 3), p, this);
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'b') {
                        this.pan[i][j] = new Carre(new Color(51, 162, 255), p, this);  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'c') {
                        this.pan[i][j] = new Carre(new Color(70, 188, 2), p, this);  
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'd') {
                        this.pan[i][j] = new Carre(new Color(207, 7, 38), p, this);
                    }
                }   
                else if (p.getBlock(i+11, j+1) instanceof BlockSpecial) {
                    if (((BlockSpecial) p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new Carre(new Color(194, 14, 209), p, this);
                    } 
                    else if (((BlockSpecial) p.getBlock(i + 11, j + 1)).getType() == 'b') {
                        this.pan[i][j] = new Carre(new Color(16, 232, 209), p, this);
                    }
                    else if (((BlockSpecial) p.getBlock(i + 11, j + 1)).getType() == 'c') {
                        this.pan[i][j] = new Carre(new Color(232, 140, 16), p, this);
                    }
                }
                else if (p.getBlock(i+11, j+1) instanceof BlockFixe) {
                    if (((BlockFixe)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new Carre(new Color(0, 0, 0), p, this);
                    }
                }
                else if (p.getBlock(i+11, j+1) instanceof Animaux) {
                    if (((Animaux)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new Carre(new Color(140, 138, 138), p, this); 
                    }                   
                }
                else if (p.getBlock(i+11, j+1) == null) {
                    this.pan[i][j] = new Carre(new Color(255, 255, 255), p, this);  
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
                    if (((BlockSpecial) p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j].setBackground(new Color(194, 14, 209));
                    } 
                    else if (((BlockSpecial) p.getBlock(i + 11, j + 1)).getType() == 'b') {
                        this.pan[i][j].setBackground(new Color(16, 232, 209));
                    }
                    else if (((BlockSpecial) p.getBlock(i+11, j+1)).getType() == 'c') {
                        this.pan[i][j].setBackground(new Color(232, 140, 16));
                    } 
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
}