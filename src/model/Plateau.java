package model;

import model.Block.Block;
import model.Block.Animaux;
import model.Block.BlockFixe;
import model.Block.BlockSpecial;
import model.Block.BlockDestructible;
import model.Block.BlockDestructibleSi;

import Interface.GestionBlock;

public class Plateau implements GestionBlock{
	private final Block[][] _plateau;

	public Plateau (int x, int y) {
		this._plateau = new Block[x][y];
	}
	
	public boolean checkAnimaux() {
		for (int i = 0 ; i<this._plateau.length ; i++) {
			for (int j = 0 ; j<this._plateau[i].length ; j++) {
				if (this._plateau[i][j] instanceof Animaux) {
					if (!(this._plateau[i+1][j] instanceof BlockFixe)) {
						return false;
					}
				}
			}
		}	return true;
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
		
		System.out.println("supprimer");

		System.out.println(x + ", " + y);

		if (isSpecial(x, y)) {
			if (((BlockSpecial)this._plateau[x][y]).getType() == 'a') {
				System.out.println("bombre sup");
				bombe(x, y);
				return;
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'b') {
				supprimeColone(y);
				this._plateau[x][y] = null;
				return;
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'c') {
				supprimeLigne(x);
				this._plateau[x][y] = null;
				return;
			}
		}

		else if (!isDestructible(x, y)) {
			return;
		}

		else if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {
				if (verifRecurence[x][y+1] == false) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x, y+1, verifRecurence);
						System.out.println("Destruction");
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
						System.out.println("Destruction");
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
						System.out.println("Destruction");
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
						System.out.println("Destruction");
					}			
				}
			}
		}
		this._plateau[x][y] = null;		
	}

	public void bombe(int x, int y) {
		//block special qui supprime les blocks destructible adjacents 

		if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {		
				this._plateau[x][y+1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {		
				this._plateau[x+1][y] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x+1, y+1))) {
			if (isDestructible(x+1, y+1)) {		
				this._plateau[x+1][y+1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x-1, y+1))) {
			if (isDestructible(x-1, y+1)) {		
				this._plateau[x-1][y+1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x+1, y-1))) {
			if (isDestructible(x+1, y-1)) {		
				this._plateau[x+1][y-1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x-1, y-1))) {
			if (isDestructible(x-1, y-1)) {		
				this._plateau[x-1][y-1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x, y-1))) {
			if (isDestructible(x, y-1)) {		
				this._plateau[x][y-1] = null;		
				System.out.println("Destruction");		
			}					
		}

		if (!(isEmpty(x-1, y))) {
			if (isDestructible(x-1, y)) {		
				this._plateau[x-1][y] = null;		
				System.out.println("Destruction");		
			}					
		}

		this._plateau[x][y] = null;		
	}

	public void supprimeColone(int y){
		for(int i = 0; i<this._plateau.length ; i++){
			if(this._plateau[i][y] instanceof BlockDestructible || this._plateau[i][y] instanceof BlockDestructibleSi){
				this._plateau[i][y] = null;
				System.out.println("Destruction");		
			}
		}
	}

	public void supprimeLigne(int x){
		for(int i = 0; i<this._plateau[x].length ; i++){
			if(this._plateau[x][i] instanceof BlockDestructible || this._plateau[x][i] instanceof BlockDestructibleSi){
				this._plateau[x][i] = null;
				System.out.println("Destruction");		
			}
		}
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
		// Décalage vers la gauche
		for (int i = 1 ; i < this._plateau[0].length-1 ; i++) {
			if (this._plateau[20][i] == null) {
				for (int j = 1 ; j < this._plateau.length ; j++) {
					if (!(this._plateau[j][i+1] instanceof BlockFixe)) {
						this._plateau[j][i] = this._plateau[j][i+1]; 
						this._plateau[j][i+1] = null;
					}
				}
				//this.actualiser();
			}
		}
	}

	public boolean isDestructible(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructible) {
			return true;
		} return false;
	}
	
	public boolean isDestructibleSi(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructibleSi) {
			return true;
		} return false;
	}

	public boolean isSpecial(int x, int y) {
		System.out.println("isSpecial ?");
		if (this._plateau[x][y] instanceof BlockSpecial) {
			System.out.println("isSpecial");
			return true;
		} return false;
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