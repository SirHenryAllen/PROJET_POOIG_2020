package model;

import model.Block.Block;
import model.Block.Animaux;
import model.Block.BlockFixe;
import model.Block.BlockSpecial;
import model.Block.BlockDestructible;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import Interface.GestionBlock;
import java.io.InputStreamReader;
import java.util.Random;


public class Plateau implements GestionBlock{
	private final Block[][] _plateau;
	private int score ;
	private int highScore ;

	// Création du plateau et de ses attributs standards
	public Plateau (int x, int y) {
		this._plateau = new Block[x][y];
		this.score = 0 ;
		loadHighScore() ;
	}

	// Sélection d'une case aléatoire non nul pour sa suppression
	public void aide(){
		int x = new Random().nextInt(20 - 15 + 1) + 15;
		int y = new Random().nextInt(10 - 1 + 1) + 1;
		while(this._plateau [x][y] == null){
			x = new Random().nextInt(20 - 15 + 1) + 15;
			y = new Random().nextInt(10 - 1 + 1) + 1;	
		}
		if(this._plateau [x][y] instanceof BlockDestructible){
			supprimer( x, y,new boolean[this.getHauteur()][this.getLargeur()]);
		}else{
			aide();
		}
	}

	// Enregistrement du score
	public void createSaveData(){
		try {
			File file = new File("highScore.dat") ;	//on a preferé utiliser l'extension .dat au lieu de .txt pour que le joueur ne puisse pas modifier ses stats 
			FileWriter output = new FileWriter(file) ;
			BufferedWriter writer = new BufferedWriter(output) ;
			writer.write(""+0);
			writer.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Chargement du High Score
	public void loadHighScore(){
		try {
			File f = new File("highScore.dat") ;
			if(!f.isFile()){
				createSaveData();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			highScore = Integer.parseInt(reader.readLine());
			reader.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Modification du High Score
	public void setHighScore(){
		FileWriter output = null ;
		try {
			File f = new File("highScore.dat") ;
			output = new FileWriter(f) ;
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(""+highScore) ;
			writer.close();
		} 
		catch (Exception e) {
			e.printStackTrace();	
		}
	}

	// Vérification de la présence d'Animaux sur le tableau
	public boolean checkAnimaux() {
		for (int i = 0 ; i<this._plateau.length ; i++) {
			for (int j = 0 ; j<this._plateau[i].length ; j++) {
				if (this._plateau[i][j] instanceof Animaux) {
					return false;
				}
			}
		}
		setHighScore();	
		return true;
	}

	// Ajout de bloques au tableau Block[][]
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


	// Si l'indice passé en argument est supprimable
	public boolean[][] preSupprimer(int x, int y, boolean[][] verifRecurence) {
		/* On détermine son type exact pour sélectionner en conséquence ses voisins qui le sont également 
		 et ensuite retourner un tableau booléen témoin, calqué sur la taille de Block[][] avec les indices 'true'
		 comme éléments à repaint en blanc */
		if (isSpecial(x, y)) {
			if (((BlockSpecial)this._plateau[x][y]).getType() == 'a') {
				return preBombe(x, y, verifRecurence);
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'b') {
				verifRecurence[x][y] = true;
				return preSupprimeColonne(y, verifRecurence);
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'c') {
				verifRecurence[x][y] = true;
				return preSupprimeLigne(x, verifRecurence);
			}
		}

		if (isAnimaux(x, y) || !(isDestructible(x, y))) {
			return verifRecurence;
		}

		else if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {
				if (!verifRecurence[x][y+1]) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur)) {
						verifRecurence[x][y] = true;
						verifRecurence = preSupprimer(x, y+1, verifRecurence);
					}					
				}
			}
		}

		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {
				if (!verifRecurence[x+1][y]) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x+1][y]).couleur)) {
						verifRecurence[x][y] = true;
						verifRecurence = preSupprimer(x+1, y, verifRecurence);
					}				
				}
			}		
		}

		if (!(isEmpty(x, y-1))) {
			if (isDestructible(x, y-1)) {
				if (!verifRecurence[x][y-1]) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y-1]).couleur)) {
						verifRecurence[x][y] = true;
						verifRecurence = preSupprimer(x, y-1, verifRecurence);
					}			
				}
			}	
		}
		if (!(isEmpty(x-1, y))) {
			if (isDestructible(x-1, y)) {
				if (!verifRecurence[x-1][y]) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x-1][y]).couleur)) {
						verifRecurence[x][y] = true;
						verifRecurence = preSupprimer(x-1, y, verifRecurence);
					}			
				}
			}
		}	
		verifRecurence[x][y] = true;
		return verifRecurence;
	}


	public void supprimer(int x, int y, boolean[][] verifRecurence) {
		//debug
		System.out.println("supprimer");
		System.out.println(x + ", " + y);

		if (isSpecial(x, y)) {
			if (((BlockSpecial)this._plateau[x][y]).getType() == 'a') {
				System.out.println("bombre sup");
				bombe(x, y);
				return;
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'b') {
				supprimeColonne(y);
				this._plateau[x][y] = null;
				return;
			}
			else if (((BlockSpecial)this._plateau[x][y]).getType() == 'c') {
				supprimeLigne(x);
				this._plateau[x][y] = null;
				return;
			}
		}

		// Si le bloque à l'indice x, y n'est pas destructible, on sort de la fonction
		else if (!isDestructible(x, y)) {
			return;
		}

		/* Après avoir préalablement vérifié que le bloque était destructible,
		 on parcours récursivement tous les voisins afin de vérifier qu'ils soient du même type
		 (BlockDestructible) et de la même couleur. Si oui, on confirme que l'indice a été évalué
		 puis on rappel la fonction avec l'indice du voisin jusqu'à arriver à un état terminal.
		 A la fin de l'évaluation, on dépile et supprime les cases du plateau en les assignant à null 
		*/

		// Vérification que l'indice n'est pas pas null (donc vide)
		else if (!(isEmpty(x, y+1))) {
			// Vérification que l'indice est destructible
			if (isDestructible(x, y+1)) {
				// Vérification que l'indice n'a pas déjà été évalué
				if (!verifRecurence[x][y+1]) {
					// Vérification que l'indice est de la même couleur que l'indice courant
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x][y+1]).couleur)) {
						// Assignation de l'emplacement de l'indice courant à true pour confirmer son évaluation
						verifRecurence[x][y] = true;
						// Rappel de la fonction récursivement avec le nouvel indice
						supprimer(x, y+1, verifRecurence);
						// Débug
						System.out.println("Destruction");
					}					
				}
			}
		}

		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {
				if (!verifRecurence[x+1][y]) {
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
				if (!verifRecurence[x][y-1]) {
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
				if (!verifRecurence[x-1][y]) {
					if ((((BlockDestructible)this._plateau[x][y]).couleur) == (((BlockDestructible)this._plateau[x-1][y]).couleur)) {
						verifRecurence[x][y] = true;
						supprimer(x-1, y, verifRecurence);
						System.out.println("Destruction");
					}			
				}
			}
		}
		// Suppression de l'indice en l'assigant à null
		this._plateau[x][y] = null;		
		// Ajout des points de suppression au score
		this.setScore(10);
		// Débug
		System.out.println("score :"+ this.getScore());
		System.out.println("highScore :"+ this.highScore);
		
		// S'il y a des bloques de type Animaux au bas du tableau, on les supprime
		for(int i = 0 ; i<12 ; i++){
			if(this._plateau[20][i] instanceof Animaux){
				this._plateau[20][i] = null ;	
				System.out.println("Un Hawk a été sauvé !");
				this.setScore(50);
				System.out.println("score :"+ this.getScore());
				System.out.println("highScore :"+ this.highScore);

			} 
		}
	}


	/* Si les bloques adjacents et en diagonale sont destructibles, 
	on return leurs indice à true dans un tableau booléen afin d'évaluer quels bloques repaint en blanc pour l'animation */
	public boolean[][] preBombe(int x, int y, boolean[][] tab) {
		if (!(isEmpty(x, y+1))) {
			if (isDestructible(x, y+1)) {		
				tab[x][y+1] = true;			
			}					
		}

		if (!(isEmpty(x+1, y))) {
			if (isDestructible(x+1, y)) {		
				tab[x+1][y] = true;		
			}					
		}

		if (!(isEmpty(x+1, y+1))) {
			if (isDestructible(x+1, y+1)) {		
				tab[x+1][y+1] = true;		
			}					
		}

		if (!(isEmpty(x-1, y+1))) {
			if (isDestructible(x-1, y+1)) {		
				tab[x-1][y+1] = true;			
			}					
		}

		if (!(isEmpty(x+1, y-1))) {
			if (isDestructible(x+1, y-1)) {		
				tab[x+1][y-1] = true;			
			}					
		}

		if (!(isEmpty(x-1, y-1))) {
			if (isDestructible(x-1, y-1)) {		
				tab[x-1][y-1] = true;			
			}					
		}

		if (!(isEmpty(x, y-1))) {
			if (isDestructible(x, y-1)) {		
				tab[x][y-1] = true;			
			}					
		}

		if (!(isEmpty(x-1, y))) {
			if (isDestructible(x-1, y)) {		
				tab[x-1][y] = true;			
			}					
		}	
		return tab;	
	}


	public void bombe(int x, int y) {
		//block special qui supprime les bloques destructibles adjacents et en diagonale
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
		this.setScore(50);
		System.out.println("score :"+ this.getScore());
		System.out.println("highScore :"+ this.highScore);
	}


	// Même principe de preBombe avec les colonnes
	public boolean[][] preSupprimeColonne(int y, boolean[][] tab) {
		for(int i = 0; i<this._plateau.length ; i++){
			if(this._plateau[i][y] instanceof BlockDestructible){
				tab[i][y] = true;	
			}
		}
		return tab;
	}

	// Suppression des bloques destructibles sur toute une colonne
	public void supprimeColonne(int y){
		for(int i = 0; i<this._plateau.length ; i++){
			if(this._plateau[i][y] instanceof BlockDestructible){
				this._plateau[i][y] = null;
				System.out.println("Destruction");		
				System.out.println("score :"+ this.getScore());
			}
		}
		this.setScore(40);
	}

	// Même principe que preSupprimeColonne avec les lignes
	public boolean[][] preSupprimeLigne(int x, boolean[][] tab) {
		for(int i = 0; i<this._plateau[x].length ; i++){
			if(this._plateau[x][i] instanceof BlockDestructible){
				tab[x][i] = true;	
			}
		}		
		return tab;
	}

	// Même principe que supprimeColonne avec les lignes
	public void supprimeLigne(int x){
		for(int i = 0; i<this._plateau[x].length ; i++){
			if(this._plateau[x][i] instanceof BlockDestructible){
				this._plateau[x][i] = null;
				System.out.println("Destruction");		
				System.out.println("score :"+ this.getScore());
				System.out.println("highScore :"+ this.highScore);

			}
		}
		this.setScore(40);
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
					if(this._plateau[20][j] instanceof Animaux){
						this._plateau[i][j] = null;
					}
				}
			}
		}
		if(this.score >this.highScore){
			this.highScore = this.score ;
		}
		// Décalage vers la gauche si absence de bloques destructibles
		for (int i = 1 ; i < this._plateau[0].length-1 ; i++) {
			if (this._plateau[20][i] == null) {
				for (int j = 1 ; j < this._plateau.length ; j++) {
					if (!(this._plateau[j][i+1] instanceof BlockFixe)) {
						this._plateau[j][i] = this._plateau[j][i+1]; 
						this._plateau[j][i+1] = null;
					}
				}
			}
			else if (this._plateau[20][i] instanceof BlockFixe) {
				int j = 19;
				while ((this._plateau[j][i] instanceof BlockFixe || this._plateau[j][i] == null) && j > 1) {
					j--;
				}
				if (j == 1) {
					for (int k = 1 ; k < this._plateau.length ; k++) {
						if (!(this._plateau[k][i+1] instanceof BlockFixe)) {
							this._plateau[k][i] = this._plateau[k][i+1]; 
							this._plateau[k][i+1] = null;
						}
					}				
				}
			}
		}
	}


	// Est-ce que le bloque x,y est destructible ?
	public boolean isDestructible(int x, int y) {
		if (this._plateau[x][y] instanceof BlockDestructible) {
			return true;
		} return false;
	}

	// Est-ce que le bloque x,y est de type Animaux ?
	public boolean isAnimaux(int x, int y) {
		if (this._plateau[x][y] instanceof Animaux) {
			return true;
		} return false;
	}

	// Est-ce que le bloque x,y est de type BlockSpecial ?
	public boolean isSpecial(int x, int y) {
		if (this._plateau[x][y] instanceof BlockSpecial) {
			return true;
		} return false;
	}


	// Accesseurs
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
	public int getScore() {
        return this.score ;
	}
	public int getHighScore(){
		return this.highScore ;
	}	
	
	
	// Modificateurs 
	public void setBlock(int x, int y, Block b) {
		this._plateau[x][y] = b;
	}
    public void setScore(int s) {
		score = score + s ;
	}
	
	
}