package modele;

import java.awt.Point;

public class TirImprobable implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		cible.toucher(position, puissance);
		
		if (position.x - 1 >= 0 && position.y - 1 >= 0 && Math.random()<=0.25) {
			Point pGauche = new Point(position);
			pGauche.x--;
			pGauche.y--;
			cible.toucher(pGauche, puissance);
		}
		if (position.x + 1 < cible.taille && position.y + 1 < cible.taille && Math.random()<=0.25) {
			Point pDroite = new Point(position);
			pDroite.x++;
			pDroite.y++;
			cible.toucher(pDroite, puissance);
		}
		if (position.y - 1 >= 0 && position.x + 1 < cible.taille && Math.random()<=0.25) {
			Point pHaut = new Point(position);
			pHaut.y--;
			pHaut.x++;
			cible.toucher(pHaut, puissance);
		}
		if (position.y + 1 < cible.taille && position.x - 1 >= 0 && Math.random()<=0.25) {
			Point pBas = new Point(position);
			pBas.y++;
			pBas.x--;
			cible.toucher(pBas, puissance);
		}
		if (position.x - 1 >= 0 && Math.random()<=0.25) {
			Point pGauche = new Point(position);
			pGauche.x--;
			cible.toucher(pGauche, puissance);
		}
		if (position.x + 1 < cible.taille && Math.random()<=0.25) {
			Point pDroite = new Point(position);
			pDroite.x++;
			cible.toucher(pDroite, puissance);
		}
		if (position.y - 1 >= 0 && Math.random()<=0.25) {
			Point pHaut = new Point(position);
			pHaut.y--;
			cible.toucher(pHaut, puissance);
		}
		if (position.y + 1 < cible.taille && Math.random()<=0.25) {
			Point pBas = new Point(position);
			pBas.y++;
			cible.toucher(pBas, puissance);
		}

	}
	
	@Override
	public String toString(){
		return "Tir improbable";		
	}

}
