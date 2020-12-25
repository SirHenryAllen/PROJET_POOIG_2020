package Interface;

import model.Block.Block;

public interface GestionBlock {

    public abstract boolean checkAnimaux();
    public abstract boolean ajouter(int x, int y, Block b);
    public abstract boolean isEmpty(int x, int y);
    public abstract void supprimer(int x, int y, boolean[][] verifRecurence);
    public abstract void actualiser();
    public abstract boolean isDestructible(int x, int y);
    public abstract Block getBlock(int x, int y);
    public abstract Block[][] getPlateau();
    public abstract int getHauteur();
    public abstract int getLargeur();
    public abstract void setBlock(int x, int y, Block b);
    
}
