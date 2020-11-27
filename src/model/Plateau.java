package model;

public class Plateau {
	private final Block[][] _plateau;

	public Plateau (int x, int y) {
		this._plateau = new Block[x][y];
	}
	
	public boolean ajouter(int x, int y, Block b) {
		// Ajout du Block b à l'indice x,y : ssi x,y est vide
		if (isEmpty(x, y)) {
			this._plateau[x][y] = b;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(int x, int y) {
		// Vérification que l'indice x,y est bien vide
		if (this._plateau[x][y] == null) {
			return true;
		} return false;
	} 

	public void selectionner(int x, int y, int prev) {
		if (y < 9) {
			if (!(isEmpty(x, y+1))) {
				if (isDestructible(x, y+1)) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur) && x*(y+1) != prev) {
						selectionner(x, y+1, x*y);
					}	
					this._plateau[x][y] = null;
				}
			}
		}
		if (x < 9) {
			if (!(isEmpty(x+1, y))) {
				if (isDestructible(x+1, y)) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x+1][y]).couleur) && (x+1)*y != prev) {
						selectionner(x+1, y, x*y);
					}
					this._plateau[x][y] = null;
				}
			}
		}
		if (y > 0) {
			if (!(isEmpty(x, y-1))) {
				if (isDestructible(x, y-1)) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y-1]).couleur) && x*(y-1) != prev) {
						selectionner(x, y-1, x*y);
					}
					this._plateau[x][y] = null;
				}
			}
		}
		if (x > 0) {
			if (!(isEmpty(x-1, y))) {
				if (isDestructible(x-1, y)) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x-1][y]).couleur) && (x-1)*y != prev) {
						selectionner(x-1, y, x*y);
					}
					this._plateau[x][y] = null;
				}
			}
		}
	}

	public void actualiser() {
		int check = 1;
		while(check != 0) {
			check = 0;
			for (int i = 0 ; i<this._plateau.length ; i++) {
				for (int j = 0 ; j<this._plateau.length ; i++) {
					if (isEmpty(i-1, j)) {
						this._plateau[i-1][j] = this._plateau[i][j]; 
						check++;
					}
				}
			}
		}
	}

	public boolean isDestructible(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructible) {
			return true;
		} return false;
	} 

	public boolean controlBlockSpe() {
		return false;
	}

	public Block getBlock(int x, int y) {
		return this._plateau[x][y];
	}

	public Block[][] getPlateau() {
		return this._plateau;
	}

	public void setBlock(int x, int y, Block b) {
		this._plateau[x][y] = b;
	}

}