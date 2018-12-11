package modele;

import java.awt.Point;

public class TirEnX implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		cible.toucher(position, puissance);
		if (position.x - 1 >= 0 && position.y - 1 >= 0) {
			Point pGauche = new Point(position);
			pGauche.x--;
			pGauche.y--;
			cible.toucher(pGauche, puissance);
		}
		if (position.x + 1 < cible.taille && position.y + 1 < cible.taille) {
			Point pDroite = new Point(position);
			pDroite.x++;
			pDroite.y++;
			cible.toucher(pDroite, puissance);
		}
		if (position.y - 1 >= 0 && position.x + 1 < cible.taille) {
			Point pHaut = new Point(position);
			pHaut.y--;
			pHaut.x++;
			cible.toucher(pHaut, puissance);
		}
		if (position.y + 1 < cible.taille && position.x - 1 >= 0) {
			Point pBas = new Point(position);
			pBas.y++;
			pBas.x--;
			cible.toucher(pBas, puissance);
		}
	}
	
	public String toString(){
		return "Tir en X";
	}

}
