package modele;

import java.awt.Point;
import java.io.Serializable;

public interface Tir extends Serializable {
	public static final int NB_TIR=2;
	
	public void tirer(Point position, Grille cible, int puissance);
}
