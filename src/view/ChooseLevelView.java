package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Groupe;
import model.Jouer.JoueurGraphique;

import java.awt.event.ActionEvent;

public class ChooseLevelView extends JFrame {
    private static final long serialVersionUID = -8094173797402644184L;
    private JPanel _levelPanel;
    private Groupe _groupe;
    private JButton[] _levelPan;
    private JMenuBar _menubar;

    public ChooseLevelView(Groupe g) {
        this.setTitle("Niveaux");
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this._levelPanel = new JPanel();
        this.setVisible(true); 
        this._groupe = g;
        this._levelPan = new JButton[this._groupe.getNiveaux().size()];
        this._menubar = new JMenuBar() ;
        this.setJMenuBar(this._menubar);
        this.lister();
        this.addButtonsToView();

        this._levelPan[0].addActionListener((ActionEvent e)->{JoueurGraphique.jouerNiveau(this._groupe.getNiveaux().get(0));});
        this._levelPan[1].addActionListener((ActionEvent e)->{JoueurGraphique.jouerNiveau(this._groupe.getNiveaux().get(1));});
        this._levelPan[2].addActionListener((ActionEvent e)->{JoueurGraphique.jouerNiveau(this._groupe.getNiveaux().get(2));});
        
    }

    public void lister() {
        for (int i = 0 ; i < this._groupe.getNiveaux().size() ; i++) {
            this._levelPan[i] = new JButton("Niveau " + (i+1));
        }
    }

    public void addButtonsToView() {
        for (int i = 0 ; i < this._levelPan.length ; i++) {
            this._menubar.add(this._levelPan[i]);
        }
    }
}