package model;

public class Niveau extends Groupe {
	private Plateau _plateau;

	public Niveau(int x, int y) {
		this._plateau = new Plateau(x, y);	// définition de la taille du plateau (si supérieur à 10 de haut, le reste ne sera pas visible par le joueur)
	}

	public final void ajouterBlock(int x) {
		//Niveau 1
		if (x == 1) {
			for (int a = 0 ; a < 22 ; a++) {
				this._plateau.setBlock(a, 0, new BlockFixe('a'));
				this._plateau.setBlock(a, 11, new BlockFixe('a'));
			}
			for (int b = 0 ; b < 12 ; b++) {
				this._plateau.setBlock(21, b, new BlockFixe('a'));
				this._plateau.setBlock(0, b, new BlockFixe('a'));
			}
			for (int i = 1 ; i < 3 ; i++) {
				for (int j = 11 ; j < 21 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('a'));
				}
			}
			for (int i = 4 ; i < 8 ; i++) {
				for (int j = 11 ; j < 21 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('b'));
				}
			}
			for (int i = 9 ; i < 11 ; i++) {
				for (int j = 11 ; j < 21 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('c'));
				}
			}
			this._plateau.setBlock(10, 2, new Animaux('a'));
			this._plateau.setBlock(10, 5, new Animaux('b'));
			this._plateau.setBlock(10, 8, new Animaux('b'));
		}

		//Niveau 2

	}

	public Plateau getPlateau() {
		return this._plateau;
	}
	
}