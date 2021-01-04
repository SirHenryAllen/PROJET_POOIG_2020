package Interface;

import model.Plateau;

public interface GestionJeu {
    public abstract void refreshScore(Plateau p);
    public abstract void refreshHighScore(Plateau p);
    public abstract void construct(Plateau p);
    public abstract void displayOnClick(boolean[][] tab);
    public abstract void reload(Plateau p);
    public abstract void win(Plateau p);
}
