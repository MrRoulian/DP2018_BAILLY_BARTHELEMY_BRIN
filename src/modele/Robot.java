package modele;

import java.awt.Point;
import java.io.Serializable;

public class Robot extends Joueur implements Serializable {

	public Robot(Grille grid, int id) {
		super(grid,id);
	}

	@Override
	public boolean jouerTour(Joueur adversaire) {
		int x,y,bateau;
		bateau = (int) (Math.random() * grid.bateaux.size());
		while (grid.bateaux.get(bateau).estCoule()) {
			bateau = (int) (Math.random() * grid.bateaux.size());
		}
		Point p=trouverBateauEndomage(adversaire);
		if(p!=null) {
			x = p.x;
			y = p.y;
		}else{
			do {
			x = (int) (Math.random() * grid.taille);
			y = (int) (Math.random() * grid.taille);
			}while(adversaire.grid.grid[x][y]<0 && adversaire.grid.grid[x][y]!=grid.getNumDansLeau());
		}

		System.out.println("tir du bateau " + (bateau+1) + " du joueur avec l'id " + id + " au point " + new Point(x, y));
		
		this.grid.bateaux.get(bateau).tirer(new Point(x, y), adversaire.grid);
		
//		this.grid.afficherGrilleJoueur();
//		this.adversaire.grid.afficherGrilleAdversaire();
		
		return true;
	}
	
	public Point trouverBateauEndomage(Joueur adversaire) {
		int num=grid.getNumDansLeau();
		for (int i = 0 ; i < grid.taille ; i++){
			for (int j = 0 ; j < grid.taille ; j++){
				if(adversaire.grid.grid[i][j]<0 && adversaire.grid.grid[i][j]!=num) {
					int idBoat=((adversaire.grid.grid[i][j])*-1)-1;
					Bateau b=adversaire.grid.bateaux.get(idBoat);
					if(!b.estCoule()) {
						if(j>=1) {
							if(adversaire.grid.grid[i][j-1]>=0 && adversaire.grid.grid[i][j-1]!=num) {
								return new Point(i, j-1);
							}	
						}
						if(j<adversaire.grid.taille-1) {
							if(adversaire.grid.grid[i][j+1]>=0 && adversaire.grid.grid[i][j+1]!=num) {
								return new Point(i, j+1);
							}
						}

						if(i>=1) {
							if(adversaire.grid.grid[i-1][j]>=0 && adversaire.grid.grid[i-1][j]!=num) {
								return new Point(i-1, j);
							}
						}

						if(i<adversaire.grid.taille-1) {
							if(adversaire.grid.grid[i+1][j]>=0 && adversaire.grid.grid[i+1][j]!=num) {
								return new Point(i+1, j);
							}
						}
					}
				}
			}
		}
		return null;
	}

}
