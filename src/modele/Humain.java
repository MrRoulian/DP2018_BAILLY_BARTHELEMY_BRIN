package modele;

import java.io.Serializable;

public class Humain extends Joueur implements Serializable {

	public Humain(Grille grid, int id) {
		super(grid,id);
	}

	/*@Override
	public void jouerTour(Joueur adversaire) {
		
		//this.grid.afficherGrilleJoueur();
		//adversaire.grid.afficherGrilleAdversaire();
		
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
	}*/
	
	@Override
	public boolean jouerTour(Joueur adversaire) {
		
		if (this.ciblePourTirer == null){
			return false;
		}
		
 		if (numBateauSelectionne - 1 < 0 || numBateauSelectionne - 1 > grid.bateaux.size()) {
			System.err.println("Le bateau " + numBateauSelectionne + " n'existe pas");
			return false;
		} else if (grid.bateaux.get(numBateauSelectionne - 1).estCoulé()){
			System.err.println("Le bateau " + numBateauSelectionne + " est coulé il ne peux pas tirer");
			return false;
		}

		System.out.println("tir de " + numBateauSelectionne + " du joueur avec l'id " + id + " au point " + ciblePourTirer);
		
 		this.grid.bateaux.get(numBateauSelectionne - 1).tirer(ciblePourTirer, adversaire.grid);
 		//ne fonctionne pas pour une raison inconnue alors je le refais dans le client
 		this.ciblePourTirer = null;
 		
		return true;
	}

}