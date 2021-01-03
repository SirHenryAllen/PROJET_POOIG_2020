package Menu;

import model.Niveau;
import view.BackgroundModel;
import model.Groupe;

import java.io.IOException;


public class Settings {
	BackgroundModel model;

	public Settings() {
		Niveau v1 = new Niveau(22, 12);
		Niveau v2 = new Niveau(22, 12);
		Niveau v3 = new Niveau(22, 12);
		Niveau v4 = new Niveau(22, 12);
		v1.ajouterBlock(1);
		v2.ajouterBlock(2);
		v3.ajouterBlock(3);
		v4.ajouterBlock(4);
		Groupe g = new Groupe();
		g.ajouterNiveau(v1);
		g.ajouterNiveau(v2);
		g.ajouterNiveau(v3);
		g.ajouterNiveau(v4);

		try {
			model = new BackgroundModel("/Assets/backgroundMenu.png");
			MenuPrincipal view = new MenuPrincipal(model, g);
			view.pack();
			view.setVisible(true);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}		
		
	public static void main(String []args) {
		new Settings() ;
	}
}


