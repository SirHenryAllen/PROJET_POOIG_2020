import model.Niveau;
//import model.Plateau;
import view.AffichageShell;
import control.ControlShell;
public class Test {

	public static void main (String[] args) {
		System.out.println("--------main--------");
		
		// Construction niveau
		Niveau v1 = new Niveau(22, 12);
		v1.ajouterBlock(1);
		v1.getPlateau().actualiser();
		
		Jouer.jouerNiveau(v1);
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