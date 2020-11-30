package model;

public class Plateau {
	private final Block[][] _plateau;

	public Plateau (int x, int y) {
		this._plateau = new Block[x][y];
	}
	
	public boolean ajouter(int x, int y, Block b) {
		// Ajout du Block b à l'indice x,y : ssi x,y est vide
		if (isEmpty(x, y)) {
			this._plateau[x][y] = b;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(int x, int y) {
		// Vérification que l'indice x,y est bien vide
		if (this._plateau[x][y] == null) {
			return true;
		} return false;
	} 

	public void supprimer(int x, int y, boolean[][] verifRecurence) {
		//System.out.println(((BlockDestructible)this._plateau[x][y]).couleur);
		//System.out.println("x = " + x + " ; y = " + y);
		
		if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {
				if (verifRecurence[x][y+1] == false) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x, y+1, verifRecurence);
					}					
				}
			}
		}

		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {
				if (verifRecurence[x+1][y] == false) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x+1][y]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x+1, y, verifRecurence);
					}				
				}
			}		
		}

		if (!(isEmpty(x, y-1))) {
			if (isDestructible(x, y-1)) {
				if (verifRecurence[x][y-1] == false) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y-1]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x, y-1, verifRecurence);
					}			
				}
			}	
		}
		if (!(isEmpty(x-1, y))) {
			if (isDestructible(x-1, y)) {
				if (verifRecurence[x-1][y] == false) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x-1][y]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x-1, y, verifRecurence);
					}			
				}
			}
		}
		this._plateau[x][y] = null;		
	}

	public void actualiser() {
		// Mise en oeuvre de la "gravité" afin de de ramener les blocs, ne s'appuyant sur rien, vers le bas.
		for (int i = 0 ; i<this._plateau.length ; i++) {
			for (int j = 0 ; j<this._plateau[i].length ; j++) {
				if (!(this._plateau[i][j] instanceof BlockFixe) && this._plateau[i][j] != null) {
					if (isEmpty(i+1, j)) {
						this._plateau[i+1][j] = this._plateau[i][j]; 
						this._plateau[i][j] = null;
						this.actualiser();
					}
				}
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

	public Block[][] getPlateau() {
		return this._plateau;
	}
	
	public int getHauteur() {
		return this._plateau.length;
	}

	public int getLargeur() {
		return this._plateau[0].length;
	}

	public void setBlock(int x, int y, Block b) {
		this._plateau[x][y] = b;
	}

}