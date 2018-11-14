package modele;

import java.awt.Point;

public class TirCroix implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		cible.toucher(position, puissance);
		if (position.x - 1 >= 0) {
			Point pGauche = new Point(position);
			pGauche.x--;
			cible.toucher(pGauche, puissance);
		}
		if (position.x + 1 < cible.taille) {
			Point pDroite = new Point(position);
			pDroite.x++;
			cible.toucher(pDroite, puissance);
		}
		if (position.y - 1 >= 0) {
			Point pHaut = new Point(position);
			pHaut.y--;
			cible.toucher(pHaut, puissance);
		}
		if (position.y + 1 < cible.taille) {
			Point pBas = new Point(position);
			pBas.y++;
			cible.toucher(pBas, puissance);
		}
	}
	
}
