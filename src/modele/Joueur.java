package modele;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Joueur implements Serializable{
	
	protected Grille grid;
	private int id;
	
	public Joueur(Grille grid, int id){
		this.grid=grid;
		this.id = id;
	}

	/*public void setAdversaire(Joueur j){
		this.adversaire = j;
	}*/
	
	public abstract void jouerTour(Joueur adversaire);
	
	public boolean aPerdu() {
		boolean perdu = true;
		for (Bateau bateau : grid.bateaux) {
			if (!bateau.estCoulé()) {
				perdu = false; 
				break;
			}
		}
		return perdu;
	}

	public int getTailleGrid() {
		return grid.taille;
	}
	
	public Grille getGrille(){
		return grid;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
