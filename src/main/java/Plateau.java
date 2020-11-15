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

	public boolean selectionner(int x, int y) {
		if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {
				if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur)) {
					selectionner(x, y+1);
				}	
				this._plateau[x][y] = null;
				return true;	
			}
		}
		return false;	
	}

	public boolean isDestructible(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructible) {
			return true;
		} return false;
	} 

	public Block getBlock(int x, int y) {
		return this._plateau[x][y];
	}

}