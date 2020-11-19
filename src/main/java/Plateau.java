public class Plateau implements Modele {
	private final Block[][] _plateau;

	public Plateau (int x, int y) {
		this._plateau = new Block[x][y];
	}
	
	public boolean ajouter(int x, int y, Block b) {
		if (isEmpty(x, y)) {
			this._plateau[x][y] = b;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(int x, int y) {
		if (this._plateau[x][y] == null) {
			return true;
		} return false;
	} 

	public void selectionner(int x, int y, int prev) {
		if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {
				if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur) && x*(y+1) != prev) {
					selectionner(x, y+1, x*y);
				}	
				this._plateau[x][y] = null;
			}
		}
		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {
				if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x+1][y]).couleur) && (x+1)*y != prev) {
					selectionner(x+1, y, x*y);
				}
				this._plateau[x][y] = null;
			}
		}
		if (!(isEmpty(x, y-1))) {
			if (isDestructible(x, y-1)) {
				if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y-1]).couleur) && x*(y-1) != prev) {
					selectionner(x, y-1, x*y);
				}
				this._plateau[x][y] = null;
			}
		}
		if (!(isEmpty(x-1, y))) {
			if (isDestructible(x-1, y)) {
				if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x-1][y]).couleur) && (x-1)*y != prev) {
					selectionner(x-1, y, x*y);
				}
				this._plateau[x][y] = null;
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

}