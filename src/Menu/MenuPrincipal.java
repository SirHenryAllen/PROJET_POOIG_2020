package Menu;

import model.Groupe;
import model.Jouer.JouerShell;
import view.ChooseLevelView;
import view.BackgroundModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = -3909496315491074971L;
	JButton play, dev;
	ImagePane imagePane ;
	BackgroundModel model ;
	JMenuBar bar ;
	private Groupe _groupe; 
	
	public MenuPrincipal(BackgroundModel model, Groupe g) {
		
		// View
		this.model = model; 
		this._groupe = g;  
		this.setTitle("PetRescue");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.imagePane = new ImagePane();
		this.play = new JButton("PLAY");
		this.dev = new JButton("MODE DEVELOPPEUR (shell)");
		this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
		this.setContentPane(imagePane);
		
		JMenuBar bar = new JMenuBar();
        bar.setLayout(new GridLayout(1,3));
		bar.add(play);
		bar.add(dev);
		
		this.setJMenuBar(bar);
		this.setContentPane(imagePane);

		play.addActionListener((ActionEvent e)->{new ChooseLevelView(this._groupe);});
		dev.addActionListener((ActionEvent e)->{JouerShell.jouerNiveau(this._groupe);});
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