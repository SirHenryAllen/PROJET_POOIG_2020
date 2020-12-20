package view;

import model.Animaux;
import model.BlockDestructible;
import model.BlockFixe;
import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class AffichageGraphique extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel playPanel;
    private JButton[][] pan;

    public AffichageGraphique(Plateau p) {

        this.setTitle("PetRescue");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.playPanel = new JPanel();

        GridLayout alignBlock = new GridLayout(10,10);
        playPanel.setLayout(alignBlock);

        this.pan = new JButton[10][10];

        for (int i = 0 ; i < this.pan.length ; i++) {
            for (int j = 0 ; j < this.pan.length ; j++) {
                if (p.getBlock(i+11, j+1) instanceof BlockDestructible) {
                    if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'a') {
                        this.pan[i][j] = new JButton();  
                        this.pan[i][j].setBackground(Color.YELLOW);
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'b') {
                        this.pan[i][j] = new JButton();  
                        this.pan[i][j].setBackground(Color.BLUE);
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'c') {
                        this.pan[i][j] = new JButton();  
                        this.pan[i][j].setBackground(Color.GREEN);
                    }
                    else if (((BlockDestructible)p.getBlock(i+11, j+1)).couleur == 'd') {
                        this.pan[i][j] = new JButton();
                        this.pan[i][j].setBackground(Color.RED);
                    }
                }   
                else if (p.getBlock(i+11, j+1) instanceof BlockFixe) {
                    if (((BlockFixe)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new JButton();
                        this.pan[i][j].setBackground(Color.BLACK);
                    }
                }
                else if (p.getBlock(i+11, j+1) instanceof Animaux) {
                    if (((Animaux)p.getBlock(i+11, j+1)).getType() == 'a') {
                        this.pan[i][j] = new JButton(); 
                        this.pan[i][j].setBackground(Color.GRAY);
                    }                   
                }
                else if (p.getBlock(i+11, j+1) == null) {
                    this.pan[i][j] = new JButton();  
                    this.pan[i][j].setBackground(Color.WHITE);
                }
                this.playPanel.add(this.pan[i][j]);       
            }
        }
        this.getContentPane().add(this.playPanel);
    }

    public JButton getBouton(int x, int y) {
        return this.pan[x][y];
    }
}