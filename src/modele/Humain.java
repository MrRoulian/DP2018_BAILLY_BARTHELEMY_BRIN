package modele;

import java.awt.Point;
import java.util.Scanner;

public class Humain extends Joueur {

	public Humain(Grille grid) {
		super(grid);
	}

	@Override
	public void jouerTour() {
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
		
		
		this.grid.bateaux.get(bateau - 1).tirer(new Point(x, y), this.adversaire.grid);
		
		this.grid.afficherGrilleJoueur();
		this.adversaire.grid.afficherGrilleAdversaire();
	}

}