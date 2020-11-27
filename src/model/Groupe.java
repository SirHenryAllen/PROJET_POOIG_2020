package model;

import java.util.ArrayList;

public class Groupe {
	ArrayList<Niveau> suiteNiveau;

	public Groupe () {
		this.suiteNiveau = new ArrayList<Niveau>();
	}

	public void ajouterNiveau(Niveau v) {
		this.suiteNiveau.add(v);
	}
}