package Menu;

import view.Profil;
import model.Niveau;
import model.Groupe;
import model.Jouer.JouerShell;
import model.Jouer.JoueurGraphique;

import view.ChooseLevelView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.undo.UndoManager;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = -3909496315491074971L;
	JButton play, setting, profil, dev;
	ImagePane imagePane ;
	MenuModel model ;
	JMenuBar bar ;
	private Groupe _groupe; 
	
	public MenuPrincipal(MenuModel model, Groupe g) {
		//View
		this.model = model; 
		this._groupe = g;  
		this.setTitle("PetRescue");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.imagePane = new ImagePane();

		this.play = new JButton("PLAY");
		this.setting = new JButton("SETTING");
		this.profil = new JButton("PROFIL");
		this.dev = new JButton("MODE DEVELOPPEUR (shell)");


		this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
		this.setContentPane(imagePane);
		JMenuBar bar = new JMenuBar();
        bar.setLayout(new GridLayout(1,3));
		bar.add(play);
		bar.add(setting);
		bar.add(profil);
		bar.add(dev);
		this.setJMenuBar(bar);
		
		this.setContentPane(imagePane);
		play.addActionListener(
			(ActionEvent e) ->{
				Niveau v1 = new Niveau(22, 12);
				v1.ajouterBlock(3);
				v1.getPlateau().actualiser();
			});

		play.addActionListener((ActionEvent e)->{new ChooseLevelView(this._groupe);});
		dev.addActionListener((ActionEvent e)->{JouerShell.jouerNiveau(this._groupe);});
        profil.addActionListener((ActionEvent e)->{
			new Profil();
		});
	}
 
    public class ImagePane extends JPanel{
		private static final long serialVersionUID = -5943567091824810243L;

		public ImagePane() {
            this.setPreferredSize(new Dimension(1024,768));  
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
        
        }
        
    }
}