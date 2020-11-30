package control;
import java.util.Scanner;
//import model.Plateau;
import model.Niveau;

public class ControlShell {
    private Scanner _coordonate;

    public ControlShell() {
        this._coordonate = new Scanner(System.in);
    }

    public void selectionner(Niveau v) {
        int[] coo = coordonate(v);
        v.getPlateau().supprimer(coo[0], coo[1], new boolean[v.getPlateau().getHauteur()][v.getPlateau().getLargeur()]);
    }

    public int[] coordonate(Niveau v) {
		int ha = evalInt("Définir hauteur : ");
        int la = evalInt("Définir largeur : ");
        int[] t = {0, 0};
		if (!(v.getPlateau().isEmpty(ha, la))) {
            int[] tt = {ha, la};
            return tt;
        } else {
            System.out.println("Emplacement non desctructible");
            coordonate(v);
        }
		return t;
    }

    public int evalInt (String q) {
		System.out.println(q);
		return this._coordonate.nextInt();
	}
}
