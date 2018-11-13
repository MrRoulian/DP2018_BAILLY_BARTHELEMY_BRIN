package modele;

public abstract class Joueur {
	
	protected Joueur adversaire;
	protected Grille grid;
	
	public Joueur(Grille grid){
		this.grid=grid;
	}

	public void setAdversaire(Joueur j){
		this.adversaire = j;
	}
	public abstract void jouerTour();
	
}
