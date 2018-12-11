package modele;

import java.awt.Point;

public class TirTordu implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		switch((int)(Math.random()*8)){
		case 0:case 1:case 2:case 3:
			cible.toucher(position, puissance);
			break;
		case 4:
			if (position.x - 1 >= 0) {
				Point pGauche = new Point(position);
				pGauche.x--;
				cible.toucher(pGauche, puissance);
			}
			break;
		case 5:
			if (position.x + 1 < cible.taille) {
				Point pDroite = new Point(position);
				pDroite.x++;
				cible.toucher(pDroite, puissance);
			}
			break;
		case 6:
			if (position.y - 1 >= 0) {
				Point pHaut = new Point(position);
				pHaut.y--;
				cible.toucher(pHaut, puissance);
			}
			break;
		case 7:
			if (position.y + 1 < cible.taille) {
				Point pBas = new Point(position);
				pBas.y++;
				cible.toucher(pBas, puissance);
			}
			break;		
		}
	}


	@Override
	public String toString(){
		return "Tir tordu";		
	}

}
