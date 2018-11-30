package modele;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Grille implements Serializable{

	protected int taille;
	protected int[][] grid;
	protected ArrayList<Bateau> bateaux;
	private int idBoat = 1;

	public Grille(int taille, ArrayList<Bateau> boats){
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
	
	public void ajouterBateau(Bateau boat){
		Point positionBateau = boat.position;
		for (int i = 0 ; i < boat.taille ; i++) {
			switch(boat.orientation){
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
		bateaux.add(boat);
		idBoat++;
	}

	public void toucher(Point position, int puissance) {
		if (grid[position.x][position.y] == 0) {
			grid[position.x][position.y] = getNumDansLeau();
		} else if (Math.abs(grid[position.x][position.y]) > 0 && grid[position.x][position.y] != getNumDansLeau()) { //si je tire sur un bateau
			bateaux.get(Math.abs(grid[position.x][position.y]) -1).subirFrappe(puissance); //il subit la frappe
			grid[position.x][position.y] = -1 * Math.abs(grid[position.x][position.y]); //et devient négatif
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
	
	public Bateau getBateau(int numBateau){
		return bateaux.get(numBateau);
	}

}
