package modele;

import java.awt.Point;

public abstract class Bateau {

	protected int puissance;
	protected int resistance;
	protected int taille;
	protected Point position;
	protected Orientation orientation;
	protected Tir tir;
	
	public void tirer(Point position) {
		//TODO
	}
}
