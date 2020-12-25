package model.Block;

public class BlockFixe extends Block {
	private char _type;	// type de block fixe

	public BlockFixe(char t) {
		super();
		this._type = t;
	}

	public char getType() {
		return this._type;
	}
}