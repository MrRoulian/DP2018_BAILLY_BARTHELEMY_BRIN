package modele;

import java.awt.Point;
import java.io.Serializable;
import java.util.Scanner;

public class Humain extends Joueur implements Serializable {

	public Humain(Grille grid, int id) {
		super(grid,id);
	}

	@Override
	public void jouerTour(Joueur adversaire) {
		
		/*this.grid.afficherGrilleJoueur();
		adversaire.grid.afficherGrilleAdversaire();*/
		
		int x,y,bateau;
		Scanner sc = new Scanner(System.in);
		System.out.println("Selection du bateau qui tire");
		bateau = sc.nextInt();
		while (bateau - 1 < 0 || bateau - 1 > grid.bateaux.size() || grid.bateaux.get(bateau - 1).estCoulé()) {
			if (bateau - 1 < 0 || bateau - 1 > grid.bateaux.size()) {
				System.err.println("Le bateau " + bateau + " n'existe pas");
			} else {
				System.err.println("Le bateau " + bateau + " est coulé il ne peux pas tirer");
			}
			System.out.println("Selection du bateau qui tire");
			bateau = sc.nextInt();
		}

		System.out.println("Selection du tir :");
		System.out.print("x: ");
		x = sc.nextInt();
		System.out.print("y: ");
		y = sc.nextInt();
		System.out.println("Tir en : (" + x + "," + y + ")");

		this.grid.bateaux.get(bateau - 1).tirer(new Point(x, y), adversaire.grid);		
	}

}