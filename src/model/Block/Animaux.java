package model.Block;

public class Animaux extends Block {
	private final char _type;	// Type d'animal

	public Animaux(char t) {
		super();
		this._type = t;
	}

	public char getType() {
		return this._type;
	}
}