package modele;

import java.awt.Point;

public abstract class Bateau {

	protected int puissance;
	protected int resistance;
	protected int taille;
	protected Point position;
	protected Orientation orientation;
	protected Tir tir;
	
	public Bateau(int puissance, int resistance, int taille, Point position, Orientation orientation, Tir tir) {
		super();
		this.puissance = puissance;
		this.resistance = resistance;
		this.taille = taille;
		this.position = position;
		this.orientation = orientation;
		this.tir = tir;
	}

	public void tirer(Point position, Grille cible) {
		if (!estCoulé()) {
			tir.tirer(position, cible, puissance);
		}
	}
	
	public void subirFrappe(int puissance) {
		resistance -= puissance;
	}
	
	public boolean estCoulé() {
		return resistance < 0;
	}
}
