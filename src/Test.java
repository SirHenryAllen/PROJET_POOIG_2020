import model.Niveau;
//import model.Plateau;
import view.AffichageShell;
public class Test {

	public static void main (String[] args) {
		System.out.println("--------main--------");
		
		//Plateau p = new Plateau(20, 10);
		Niveau v1 = new Niveau(20, 10);
		v1.ajouterBlock(1);
		AffichageShell.afficherFormatPlateauJoueur(v1.getPlateau(), 10, 10);
		AffichageShell.afficherFormatPlateau(v1.getPlateau());
	}
}