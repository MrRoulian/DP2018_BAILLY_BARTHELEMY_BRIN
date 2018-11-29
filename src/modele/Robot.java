package modele;

import java.awt.Point;
import java.io.Serializable;

public class Robot extends Joueur implements Serializable {

	public Robot(Grille grid, int id) {
		super(grid,id);
	}

	@Override
	public void jouerTour(Joueur adversaire) {
		int x,y,bateau;
		bateau = (int) (Math.random() * grid.bateaux.size());
		while (grid.bateaux.get(bateau).estCoulé()) {
			bateau = (int) (Math.random() * grid.bateaux.size());
		}
		x = (int) (Math.random() * grid.taille);
		y = (int) (Math.random() * grid.taille);
		
		
		this.grid.bateaux.get(bateau).tirer(new Point(x, y), adversaire.grid);
		
//		this.grid.afficherGrilleJoueur();
//		this.adversaire.grid.afficherGrilleAdversaire();
	}

}
