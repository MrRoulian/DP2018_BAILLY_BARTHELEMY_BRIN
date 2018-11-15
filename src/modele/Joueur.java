package modele;

public abstract class Joueur {
	
	protected Joueur adversaire;
	protected Grille grid;
	protected int numBateauSelectionne;
	
	public Joueur(Grille grid){
		this.grid=grid;
	}

	public void setAdversaire(Joueur j){
		this.adversaire = j;
	}
	
	public abstract void jouerTour();
	public abstract boolean jouerTour(int numBateau, int x, int y);
	
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
	
	public int getNumBateauSelectionne(){
		return numBateauSelectionne;
	}
	
	public void setNumBateauSelectionne(int numBateau){
		this.numBateauSelectionne = numBateau;
	}

	
}
