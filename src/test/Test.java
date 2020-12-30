package test ;
import java.util.Scanner;
import java.io.IOException;
import model.Niveau;
import model.Jouer.JouerShell;
import model.Jouer.JoueurGraphique;
import view.Profil;

//import view.AffichageShell;
//import control.ControlShell;

public class Test {
	private static Scanner _choice = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
	//	Profil p = new Profil();
	//	p.setVisible(true);

		Niveau test = new Niveau(22, 12);
		test.ajouterBlock(4);
		test.getPlateau().actualiser();
		JoueurGraphique.jouerNiveau(test);

		// Construction niveau
		/* Niveau v1 = new Niveau(22, 12);
		v1.ajouterBlock(3);
		v1.getPlateau().actualiser();

		// Choix du controle
		System.out.println("Choisir le mode de jeu :\n - 0 : Interface Shell\n - 1 : Affichage Graphique");
		if (_choice.nextInt() == 0) {
			JouerShell.jouerNiveau(v1);
		} else {
			JoueurGraphique.jouerNiveau(v1);
		} */
		
		//----------
		//System.out.println("Hauteur du plateau = " + v1.getPlateau().getHauteur());
		//System.out.println("Largeur du plateau = " + v1.getPlateau().getLargeur());
		//v1.getPlateau().supprimer(17, 1, new boolean[22][12]);
		//AffichageShell.afficherFormatPlateau(v1.getPlateau());
		//v1.getPlateau().actualiser();
		//AffichageShell.afficherFormatPlateau(v1.getPlateau());
		//v1.getPlateau().selectionner(10, 1, new boolean[22][12]);
		//AffichageShell.afficherFormatPlateau(v1.getPlateau());
	}
}