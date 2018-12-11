package modele;

import java.awt.Point;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Joueur implements Serializable{
	
	protected Grille grid;
	protected int id;
	protected int numBateauSelectionne;
	protected Point ciblePourTirer;
	
	public Joueur(Grille grid, int id){
		this.grid=grid;
		this.id = id;
		this.numBateauSelectionne = 0;
	}
	
	public abstract boolean jouerTour(Joueur adversaire);
	
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
	
	public int getNumBateauSelectionne(){
		return numBateauSelectionne;
	}

	public void setNumBateauSelectionne(int numBateau) {
		this.numBateauSelectionne = numBateau;		
	}

	public Point getCiblePourTirer() {
		return ciblePourTirer;
	}

	public void setCiblePourTirer(Point ciblePourTier) {
		this.ciblePourTirer = ciblePourTier;
	}
	
	public int getId(){
		return id;
	}
	
	public String toString(){
		return "Joueur " + id;
	}

	public void setGrid(Grille grille) {
		this.grid=grille;		
	}
	
}
