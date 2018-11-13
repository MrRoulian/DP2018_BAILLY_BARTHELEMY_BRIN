package modele;

public abstract class Joueur {
	
	protected Joueur adversaire;

	public abstract void setAdversaire(Joueur j);
	public abstract void jouerTour();
	
}
