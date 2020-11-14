public class Plateau {
	private final Block[][] plateau;

	public Plateau (int x, int y) {
		this.plateau = new plateau[x][y];
	}

	public Block[][] getPlateau() {
		return this.plateau;
	}
}