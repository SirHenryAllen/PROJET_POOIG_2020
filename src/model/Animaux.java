package model;

public class Animaux extends Block {
	private final char _type;

	public Animaux(char t) {
		this._type = t;
	}

	public char getType() {
		return this._type;
	}
}