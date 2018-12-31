package modele;

import java.awt.Point;
import java.io.Serializable;

public abstract class Bateau implements Serializable {

	protected int puissance;
	protected int resistance;
	protected int taille;
	protected Point position;
	protected Orientation orientation;
	protected Tir tir;
	
	public Bateau(int puissance, int resistance, int taille, Point position, Orientation orientation, Tir tir) {
		super();
		this.puissance = 1;
		this.resistance = resistance;
		this.taille = taille;
		this.position = position;
		this.orientation = orientation;
		this.tir = tir;
	}

	public void tirer(Point position, Grille cible) {
		if (!estCoule()) {
			tir.tirer(position, cible, puissance);
		}
	}
	
	public void subirFrappe(int puissance) {
		resistance -= puissance;
	}
	
	public boolean estCoule() {
		return resistance <= 0;
	}

	@Override
	public String toString() {
		return "[point de vie=" + resistance + ", tir=" + tir + "]";
	}	
	
}
