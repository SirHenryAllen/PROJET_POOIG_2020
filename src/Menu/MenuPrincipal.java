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
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.undo.UndoManager;

public class MenuPrincipal extends JFrame{

	JButton play , setting , profil ;
	ImagePane imagePane ;
	MenuModel model ;
	JMenuBar bar ;
	
	public MenuPrincipal(MenuModel model) {
		this.model = model;   
		this.setTitle("PetRescueProut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.imagePane = new ImagePane();
		this.play = new JButton("PLAY") ;
		this.setting = new JButton("SETTING") ;
		this.profil = new JButton("PROFIL") ;
		JMenuBar bar = new JMenuBar();
        bar.setLayout(new GridLayout(1,3));
		bar.add(play);
		bar.add(setting);
		bar.add(profil);
		this.setJMenuBar(bar);

		this.setContentPane(imagePane);
        
    }
 
    public class ImagePane extends JPanel{

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