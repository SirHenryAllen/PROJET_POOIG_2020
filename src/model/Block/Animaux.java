package model.Block;

public class Animaux extends Block {
	// Type d'animal
	private final char _type;	

	public Animaux(char t) {
		super();
		this._type = t;
	}

	public char getType() {
		return this._type;
	}
}