package view;
import model.Block.BlockDestructible;
import model.Block.BlockDestructibleSi;
import model.Block.BlockFixe;
import model.Block.BlockSpecial;
import model.Plateau;
import model.Block.Animaux;

public class AffichageShell {

	public static void afficherFormatPlateauJoueur(Plateau p, int x, int y) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();	// Définition d'un alphabet	pour l'affichage de la largeur
		System.out.println("\n########################\nPlateau format utilisateur\n########################\n");
		System.out.print("      |  ");
		//Affichage des lettres références pour la largeur du tableau
		for (int i = 0 ; i<y ; i++) {
			System.out.print(alphabet[i] + "  ");
		}
		System.out.println("");
		//Affichage de toutes lignes du tableau
		int a = 0;
		for (int j = x ; j<p.getPlateau().length ; j++) {
			a = j-x;
			if (a < 10) { 
				System.out.print("  " + a + "   |  ");
			} else { System.out.print("  " + a + "  |  "); }		
			for (int k = 0 ; k<y ; k++) {
				if (p.getBlock(j, k) == null) {
					System.out.print(".  ");
				}
				if (p.getBlock(j, k) instanceof BlockFixe) {
					System.out.print("#  ");
				}
				if (p.getBlock(j, k) instanceof BlockDestructible) {
					//Affichage des blocks destructibles
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'a') {
						System.out.print("a  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'b') {
						System.out.print("b  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'c') {
						System.out.print("c  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'd') {
						System.out.print("d  ");
					}
				}
				//Affichage des blocks destructibles spéciaux
				if (p.getBlock(j, k) instanceof BlockDestructibleSi) {
					System.out.print("-  ");
				}
				if (p.getBlock(j, k) instanceof BlockFixe) {
					System.out.print("# ");
				}
			}
			System.out.println("");	
		}
	}

	public static void afficherFormatPlateau(Plateau p) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();	// Définition d'un alphabet	pour l'affichage de la largeur
		System.out.println("\n########################\nPlateau format développeur\n########################\n");
		if (p.getPlateau().length > 10) {
			System.out.print("      |  ");
		} else { System.out.print("     |  "); }
		
		//Affichage des lettres références pour la largeur du tableau
		for (int i = 0 ; i<p.getPlateau()[i].length ; i++) {
			System.out.print(alphabet[i] + "  ");
		}
		System.out.println("");
		//Affichage de toutes lignes du tableau
		for (int j = 0 ; j<p.getPlateau().length ; j++) {
			if (j < 10) { 
				System.out.print("  " + j + "   |  ");
			} else { System.out.print("  " + j + "  |  "); }
			for (int k = 0 ; k<(p.getPlateau())[j].length ; k++) {
				if (p.getBlock(j, k) == null) {
					System.out.print(".  ");
				}
				if (p.getBlock(j, k) instanceof BlockFixe) {
					System.out.print("#  ");
				}
				if (p.getBlock(j, k) instanceof BlockDestructible) {
					//Affichage des blocks destructibles
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'a') {
						System.out.print("a  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'b') {
						System.out.print("b  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'c') {
						System.out.print("c  ");
					}
					if(((BlockDestructible)p.getBlock(j, k)).couleur == 'd') {
						System.out.print("d  ");
					}
				}
				if (p.getBlock(j, k) instanceof Animaux) {
					//Affichage des blocks animaux
					if(((Animaux)p.getBlock(j, k)).getType() == 'a') {
						System.out.print("+  ");
					}
				}
				if (p.getBlock(j, k) instanceof BlockSpecial) {
					//Affichage des Blocks destructibles
					if (((BlockSpecial)p.getBlock(j, k)).getType() == 'a') {
						System.out.print("~ ");
					}
					if (((BlockSpecial)p.getBlock(j, k)).getType() == 'a') {
						System.out.print("$ ");
					}
					if (((BlockSpecial)p.getBlock(j, k)).getType() == 'a') {
						System.out.print("* ");
					}
				}
				//Affichage des blocks destructibles spéciaux
				if (p.getBlock(j, k) instanceof BlockDestructibleSi) {
					System.out.print("-  ");
				}
			}
			System.out.println("");	
		}
	}
}