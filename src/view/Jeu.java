package view;

import model.Block.Animaux;
import model.Block.BlockDestructible;
import model.Block.BlockFixe;
import model.Block.BlockSpecial;
import model.Plateau;
import control.ControlGraphique.Carre;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Interface.GestionJeu;

import java.awt.Color;
import java.awt.*;

public class Jeu extends JFrame implements GestionJeu  {
    private static final long serialVersionUID = 1L;
    private JPanel playPanel;
    private Carre[][] pan;
    JButton aide ;
    JLabel scoreLabel ;   
    JLabel highScoreLabel ;   
    JMenuBar menubar ;
    JMenu file ;

    public Jeu(Plateau p) throws IOException{
        this.playPanel = new JPanel();
        JButton quitter = new JButton("quitter");
        aide = new JButton("aide");
        JMenuBar menubar = new JMenuBar();

        scoreLabel = new JLabel("Score :"+ p.getScore()) ;
        highScoreLabel = new JLabel("  Best score :"+ p.getHighScore()) ;

        this.setJMenuBar(menubar);
        menubar.add(quitter) ;
        menubar.add(aide) ;
        menubar.add(scoreLabel) ;
        menubar.add(highScoreLabel);    
        
        quitter.addActionListener((ActionEvent e)->{
            System.exit(0);
        });
        aide.addActionListener((ActionEvent e)->{
            p.aide();
            p.actualiser();
            this.reload(p);
            this.refreshScore(p);
            this.refreshHighScore(p);
            this.win(p);
        });

        this.setTitle("PetRescue");
        this.setSize(800, 600);
        
        GridLayout alignBlock = new GridLayout(10,10);
        playPanel.setLayout(alignBlock);

        this.pan = new Carre[10][10];

        construct(p);
        repaint();
    }

    public void refreshScore(Plateau p) {
        this.scoreLabel.setText("Score :"+((Integer)p.getScore()).toString());
    }

    public void refreshHighScore(Plateau p) {
        this.highScoreLabel.setText("  Best score :"+((Integer)p.getHighScore()).toString());
    }

    // Crée tous les Carre et remplit le tableau de Carre avec .
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
        this.getContentPane().add(this.playPanel);
    }
}

    // Modifi les Carre en blanc si leur valeur associée dans le tableau tab est true (pour donner l'impression de suppression avant de reload())
    public void displayOnClick(boolean[][] tab) {
        System.out.println("display");
        for (int i = 0 ; i < this.pan.length ; i++) {
            for (int j = 0 ; j < this.pan.length ; j++) {
                if (tab[i+11][j+1]) {
                    this.pan[i][j].setBackground(new Color(255, 255, 255));
                }
            }
        }
    }

    // Change la couleur des Carre dans le tableau en fonction du nouvel emplacement des bloques dans le tableau de Block[][]
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

    // Accesseurs
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

    // Vérification si la partie est gagnante
    public void win(Plateau p){
        if(p.checkAnimaux()){
            // Passage du bouton aide en invisible
            aide.setVisible(false);
            JLabel winner = new JLabel() ; 
            JPanel win = new JPanel();
            // Affichage du label de la victoire
            winner.setText("vous avez gagné !");
            winner.setHorizontalAlignment(0);
            winner.setVisible(true);
            win.add(winner);
            this.setContentPane(win);
            win.repaint();
            win.revalidate();
        }
    }
    
}