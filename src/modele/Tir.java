package modele;

import java.awt.Point;
import java.io.Serializable;

public interface Tir extends Serializable {
	
	public void tirer(Point position, Grille cible, int puissance);
	public String toString();
}
