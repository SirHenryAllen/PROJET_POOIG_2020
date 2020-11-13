public class BlockDestructible extends Block {
	private final char couleur;

	public BlockDestructible(char c) {
		this.couleur = c;
	} 

	public char getCouleur() {
		return this.couleur;
	}
}