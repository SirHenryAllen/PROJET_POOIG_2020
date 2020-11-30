import model.Niveau;
//import model.Plateau;
import view.AffichageShell;
public class Test {

	public static void main (String[] args) {
		System.out.println("--------main--------");
		
		//Plateau p = new Plateau(20, 10);
		Niveau v1 = new Niveau(22, 12);
		v1.ajouterBlock(1);
		//AffichageShell.afficherFormatPlateauJoueur(v1.getPlateau(), 11, 12);
		AffichageShell.afficherFormatPlateau(v1.getPlateau());
		v1.getPlateau().selectionner(11, 4, new boolean[22][12]);
		v1.getPlateau().actualiser();
		AffichageShell.afficherFormatPlateau(v1.getPlateau());
		//v1.getPlateau().selectionner(10, 1, new boolean[22][12]);
		//AffichageShell.afficherFormatPlateau(v1.getPlateau());
	}
}