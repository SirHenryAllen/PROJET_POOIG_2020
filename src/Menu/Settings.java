package Menu ;

import model.Niveau;
import model.Groupe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class Settings {
	MenuModel model;

	public Settings() {
		Niveau v1 = new Niveau(22, 12);
		Niveau v2 = new Niveau(22, 12);
		Niveau v3 = new Niveau(22, 12);
		v1.ajouterBlock(1);
		v2.ajouterBlock(2);
		v3.ajouterBlock(3);
		Groupe g = new Groupe();
		g.ajouterNiveau(v1);
		g.ajouterNiveau(v2);
		g.ajouterNiveau(v3);


		try {
			model = new MenuModel("C:\\Users\\Sunay\\eclipse-workspace\\MenuM\\backgroundMenu.png");
			//model = new MenuModel("/home/sha/Projets/PROJET_POOIG_2020/src/Menu/backgroundMenu.png");
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


