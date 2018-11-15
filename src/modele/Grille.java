package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Grille {

	protected int taille;
	protected int[][] grid;
	protected ArrayList<Bateau> bateaux;

	public Grille(int taille, ArrayList<Bateau> boats){
		int idBoat = 1;
		Point positionBateau;
		bateaux = boats;
		grid = new int[taille][taille];
		this.taille = taille;
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				grid[j][i] = 0;
			}
		}
		for (Bateau bateau : boats) {
			positionBateau = bateau.position;
			for (int i = 0 ; i < bateau.taille ; i++) {
				switch(bateau.orientation){
				case Nord:
					grid[positionBateau.x][positionBateau.y-i] = idBoat;
					break;
				case Est:
					grid[positionBateau.x+i][positionBateau.y] = idBoat;
					break;
				case Sud:
					grid[positionBateau.x][positionBateau.y+i] = idBoat;
					break;
				case Ouest:
					grid[positionBateau.x-i][positionBateau.y] = idBoat;
					break;
				}
			}
			idBoat++;
		}
	}

	public void toucher(Point position, int puissance) {
		if (grid[position.x][position.y] == 0) {
			grid[position.x][position.y] = -1 * (bateaux.size() + 1);
		} else if (grid[position.x][position.y] > 0) {
			bateaux.get(grid[position.x][position.y] -1).subirFrappe(puissance);
			grid[position.x][position.y] = -1 * grid[position.x][position.y];
		} 
	}

	public void afficherGrilleJoueur(){
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				System.out.print(grid[j][i]+"\t");
			}
			System.out.println("\n");
		}
		System.out.println();
	}

	public void afficherGrilleAdversaire(){
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				if (grid[j][i] < 0) {
					System.out.print(grid[j][i]+"\t");
				} else {
					System.out.print("0\t");					
				}					
			}
			System.out.println("\n");
		}
	}
	
	public int getCase(int x, int y){
		return grid[x][y];
	}
	
	public int getNumDansLeau(){
		return (bateaux.size()+1)*-1;
	}

}
