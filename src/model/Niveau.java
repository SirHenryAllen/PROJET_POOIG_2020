package model;
import java.util.Random;

public class Niveau extends Groupe {
	private Plateau _plateau;

	public Niveau(int x, int y) {
		this._plateau = new Plateau(x, y);	// définition de la taille du plateau (si supérieur à 10 de haut, le reste ne sera pas visible par le joueur)
	}

	public final void ajouterBlock(int niveau) {
		//Aléatoire (non recommandé)
		if (niveau == 0) {
			for (int a = 0 ; a < 22 ; a++) {
				this._plateau.setBlock(a, 0, new BlockFixe('a'));
				this._plateau.setBlock(a, 11, new BlockFixe('a'));
			}
			for (int b = 0 ; b < 12 ; b++) {
				this._plateau.setBlock(21, b, new BlockFixe('a'));
				this._plateau.setBlock(0, b, new BlockFixe('a'));
			}			
			for (int i = 1 ; i < 21 ; i++) {
				for (int j = 1 ; j < 11 ; j++) {
					if (new Random().nextInt(6) == 0) {
						this._plateau.setBlock(i, j, null);
					}
					else if (new Random().nextInt(6) == 1) {
						this._plateau.setBlock(i, j, new BlockDestructible('a'));
					}
					else if (new Random().nextInt(6) == 2) {
						this._plateau.setBlock(i, j, new BlockDestructible('b'));
					}
					else if (new Random().nextInt(6) == 3) {
						this._plateau.setBlock(i, j, new BlockDestructible('c'));
					}
					else if (new Random().nextInt(6) == 4) {
						this._plateau.setBlock(i, j, new BlockDestructible('d'));
					}
				}
			}
		}
		//Niveau 1
		if (niveau == 1) {
			// Décors
			for (int a = 0 ; a < 22 ; a++) {
				this._plateau.setBlock(a, 0, new BlockFixe('a'));
				this._plateau.setBlock(a, 11, new BlockFixe('a'));
			}
			for (int b = 0 ; b < 12 ; b++) {
				this._plateau.setBlock(21, b, new BlockFixe('a'));
				this._plateau.setBlock(0, b, new BlockFixe('a'));
			}

			// Blocks Desctructibles & Animaux
			for (int i = 1 ; i < 4 ; i++) {
				this._plateau.setBlock(13, i, new BlockDestructible('b'));
			}
			this._plateau.setBlock(13, 1, new Animaux('a'));
			this._plateau.setBlock(14, 1, new BlockDestructible('a'));
			this._plateau.setBlock(14, 2, new BlockDestructible('a'));
			this._plateau.setBlock(14, 3, new BlockDestructible('b'));
			this._plateau.setBlock(15, 1, new BlockDestructible('a'));
			this._plateau.setBlock(15, 2, new BlockDestructible('a'));
			this._plateau.setBlock(15, 3, new BlockDestructible('b'));
			for (int i = 1 ; i < 4 ; i++) {
				this._plateau.setBlock(16, i, new BlockDestructible('d'));
			}
			this._plateau.setBlock(17, 1, new BlockDestructible('a'));
			this._plateau.setBlock(17, 2, new BlockDestructible('a'));
			this._plateau.setBlock(17, 3, new BlockDestructible('b'));
			this._plateau.setBlock(18, 1, new BlockDestructible('a'));
			this._plateau.setBlock(18, 2, new BlockDestructible('a'));
			this._plateau.setBlock(18, 3, new BlockDestructible('b'));
			for (int i = 1 ; i < 4 ; i++) {
				this._plateau.setBlock(19, i, new BlockDestructible('a'));
			}
			this._plateau.setBlock(20, 1, new BlockDestructible('a'));
			this._plateau.setBlock(20, 2, new BlockDestructible('a'));
			this._plateau.setBlock(20, 3, new BlockDestructible('b'));

			this._plateau.setBlock(16, 4, new Animaux('a'));
			this._plateau.setBlock(17, 4, new BlockDestructible('d'));
			this._plateau.setBlock(18, 4, new BlockDestructible('d'));
			this._plateau.setBlock(19, 4, new BlockDestructible('b'));
			this._plateau.setBlock(20, 4, new BlockDestructible('b'));
			
			this._plateau.setBlock(13, 5, new BlockDestructible('b'));
			this._plateau.setBlock(14, 5, new BlockDestructible('b'));
			this._plateau.setBlock(15, 5, new BlockDestructible('c'));
			this._plateau.setBlock(16, 5, new BlockDestructible('d'));
			this._plateau.setBlock(17, 5, new BlockDestructible('d'));
			this._plateau.setBlock(18, 5, new BlockDestructible('b'));
			this._plateau.setBlock(19, 5, new BlockDestructible('b'));
			this._plateau.setBlock(20, 5, new BlockDestructible('b'));

			this._plateau.setBlock(13, 6, new BlockDestructible('b'));
			this._plateau.setBlock(14, 6, new BlockDestructible('c'));
			this._plateau.setBlock(15, 6, new BlockDestructible('c'));
			this._plateau.setBlock(16, 6, new BlockDestructible('d'));
			this._plateau.setBlock(17, 6, new BlockDestructible('c'));
			this._plateau.setBlock(18, 6, new BlockDestructible('c'));
			this._plateau.setBlock(19, 6, new BlockDestructible('b'));
			this._plateau.setBlock(20, 6, new BlockDestructible('c'));

			this._plateau.setBlock(13, 7, new BlockDestructible('d'));
			this._plateau.setBlock(14, 7, new BlockDestructible('d'));
			this._plateau.setBlock(15, 7, new BlockDestructible('c'));
			this._plateau.setBlock(16, 7, new BlockDestructible('b'));
			this._plateau.setBlock(17, 7, new BlockDestructible('c'));
			this._plateau.setBlock(18, 7, new BlockDestructible('b'));
			this._plateau.setBlock(19, 7, new BlockDestructible('b'));
			this._plateau.setBlock(20, 7, new BlockDestructible('c'));

			this._plateau.setBlock(15, 8, new Animaux('a'));
			this._plateau.setBlock(16, 8, new BlockDestructible('b'));
			this._plateau.setBlock(17, 8, new BlockDestructible('c'));
			this._plateau.setBlock(18, 8, new BlockDestructible('c'));
			this._plateau.setBlock(19, 8, new BlockDestructible('c'));
			this._plateau.setBlock(20, 8, new BlockDestructible('c'));

			this._plateau.setBlock(16, 9, new BlockDestructible('b'));
			this._plateau.setBlock(17, 9, new BlockDestructible('b'));
			this._plateau.setBlock(18, 9, new BlockDestructible('b'));
			this._plateau.setBlock(19, 9, new BlockDestructible('b'));
			this._plateau.setBlock(20, 9, new BlockDestructible('c'));

			this._plateau.setBlock(19, 10, new Animaux('a'));
			this._plateau.setBlock(20, 10, new BlockDestructible('c'));
		}

		//Niveau 2
		if (niveau == 2) {
			this._plateau.setBlock(11, 2, new BlockDestructible('d'));
			this._plateau.setBlock(11, 3, new BlockDestructible('d'));
			this._plateau.setBlock(11, 4, new BlockDestructible('d'));			
		}

	}

	public Plateau getPlateau() {
		return this._plateau;
	}
	
}