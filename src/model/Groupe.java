package model;

import java.util.ArrayList;

public class Groupe {
	ArrayList<Niveau> suiteNiveau;	// Liste des niveaux

	public Groupe () {
		this.suiteNiveau = new ArrayList<Niveau>();	// Définition d'un nouveau groupe de niveaux
	}

	public void ajouterNiveau(Niveau v) {
		this.suiteNiveau.add(v);	// ajout d'un nouveau niveau à la suite
	}
}