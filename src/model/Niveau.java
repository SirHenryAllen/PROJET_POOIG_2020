package model;

public class Niveau extends Groupe {
	private Plateau _plateau;

	public Niveau(int x, int y) {
		this._plateau = new Plateau(x, y);
	}

	public void ajouterBlock(int x) {
		if (x == 1) {
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('a'));
				}
			}
			for (int i = 4 ; i < 7 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('b'));
				}
			}
			for (int i = 8 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					this._plateau.setBlock(j, i, new BlockDestructible('c'));
				}
			}
		}
	}

	public Plateau getPlateau() {
		return this._plateau;
	}
	
}