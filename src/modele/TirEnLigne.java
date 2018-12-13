package modele;

import java.awt.Point;

public class TirEnLigne implements Tir {
	
	private int sens = 0;

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		sens = (int)(Math.random()*2);
		cible.toucher(position, puissance);
		if (sens == 0){		//Horizontal
			if (position.x - 1 >= 0) {
				Point pGauche = new Point(position);
				pGauche.x--;
				cible.toucher(pGauche, puissance);
			}
			if (position.x - 2 >= 0) {
				Point pGauche = new Point(position);
				pGauche.x--;
				pGauche.x--;
				cible.toucher(pGauche, puissance);
			}
			if (position.x + 1 < cible.taille) {
				Point pDroite = new Point(position);
				pDroite.x++;
				cible.toucher(pDroite, puissance);
			}
			if (position.x + 2 < cible.taille) {
				Point pDroite = new Point(position);
				pDroite.x++;
				pDroite.x++;
				cible.toucher(pDroite, puissance);
			}			
		} else {		//Vertical
			if (position.y - 1 >= 0) {
				Point pGauche = new Point(position);
				pGauche.y--;
				cible.toucher(pGauche, puissance);
			}
			if (position.y - 2 >= 0) {
				Point pGauche = new Point(position);
				pGauche.y--;
				pGauche.y--;
				cible.toucher(pGauche, puissance);
			}
			if (position.y + 1 < cible.taille) {
				Point pDroite = new Point(position);
				pDroite.y++;
				cible.toucher(pDroite, puissance);
			}
			if (position.y + 2 < cible.taille) {
				Point pDroite = new Point(position);
				pDroite.y++;
				pDroite.y++;
				cible.toucher(pDroite, puissance);
			}			
		}
	}
	
	public String toString(){
		return sens==0?"Tir en ligne horizontal":"Tir en ligne vertical";
	}

}
