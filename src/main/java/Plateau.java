public class Plateau implements Modele {
	private final Block[][] _plateau;

	public Plateau (int x, int y) {
		this.plateau = new plateau[x][y];
	}
	
	public boolean ajouter(int x, int y, Block b) {
		
	}

	public boolean isEmpty(int x, int y) {
		if (this._plateau[x][y] == null) {
			return true;
		} return false;
	} 

	public boolean suppression(int x, int y) {
		if (!(isEmpty(x, y))) {
			else if (isDestructible(x, y)) {

			}
		}
		return false;
	}

	public boolean selectionner() {
		
	}

	public boolean isDestructible(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructible) {
			return true
		} return false;
	} 

	public Block[][] getPlateau() {
		return this.plateau;
	}

	public Block getBlock(int x, int y) {
		return this._plateau[x][y];
	}



}