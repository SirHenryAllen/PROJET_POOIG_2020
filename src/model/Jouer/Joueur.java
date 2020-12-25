package model.Jouer;

import java.io.Serializable;

public class Joueur implements Serializable {
    private static final long serialVersionUID = 3913462105332499632L;
    private final String nom;
    private int niveau;

    public Joueur(String nom) {
       this.nom = nom;
       this.niveau = 0;
    }

    public void setNiveau(final int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return this.nom;
    }
    public int getNiveau() {
        return this.niveau;
    }
}
