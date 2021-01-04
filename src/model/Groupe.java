package model;

import java.util.ArrayList;

public class Groupe {

	// Liste des niveaux
	private ArrayList<Niveau> suiteNiveau;	

	// Définition d'un nouveau groupe de niveaux
	public Groupe () {
		this.suiteNiveau = new ArrayList<Niveau>();	
	}

	// ajout d'un nouveau niveau à la suite
	public void ajouterNiveau(Niveau v) {
		this.suiteNiveau.add(v);	
	}

	// Accesseur de la liste
	public ArrayList<Niveau> getNiveaux() {
		return this.suiteNiveau;
	}
}