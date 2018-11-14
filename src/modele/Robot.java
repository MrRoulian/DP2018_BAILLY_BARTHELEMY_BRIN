package modele;

import java.awt.Point;

public class Robot extends Joueur {

	public Robot(Grille grid) {
		super(grid);
	}

	@Override
	public void jouerTour() {
		int x,y,bateau;
		bateau = (int) (Math.random() * grid.bateaux.size());
		while (grid.bateaux.get(bateau).estCoulé()) {
			bateau = (int) (Math.random() * grid.bateaux.size());
		}
		x = (int) (Math.random() * grid.taille);
		y = (int) (Math.random() * grid.taille);
		
		
		this.grid.bateaux.get(bateau).tirer(new Point(x, y), this.adversaire.grid);
		
//		this.grid.afficherGrilleJoueur();
//		this.adversaire.grid.afficherGrilleAdversaire();
	}

}
