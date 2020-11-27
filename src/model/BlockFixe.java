package model;

public class BlockFixe extends Block {
	private char _type;

	public BlockFixe(char t) {
		super();
		this._type = t;
	}

	public char getType() {
		return this._type;
	}
}