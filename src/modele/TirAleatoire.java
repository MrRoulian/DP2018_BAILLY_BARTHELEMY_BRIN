package modele;

import java.awt.Point;

public class TirAleatoire implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		position.x = (int) (Math.random() * cible.taille);
		position.y = (int) (Math.random() * cible.taille);
		cible.toucher(position,puissance);
	}

}
