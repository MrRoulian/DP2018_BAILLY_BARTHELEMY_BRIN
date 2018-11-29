package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

public class Partie extends Observable implements InterfacePartie {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private BateauFactory bateauFactory;
	
	public Partie(){
		// ----- Recuperation de l'instance de la factory ----- //
		bateauFactory = BateauXX.getInstance();
		
		// ----- Creation des grille ----- //
		// Taille de la grille :
		int taille = 10;
		// Creation de la liste de bateau :
		// Joueur 1 :
		ArrayList<Bateau> listeBateauJ1 = new ArrayList<Bateau>();
		listeBateauJ1.add(bateauFactory.getGrosBateau(new Point(0, 0), Orientation.Est, new TirCroix()));
		listeBateauJ1.add(bateauFactory.getMoyenBateau(new Point(0, 1), Orientation.Est, new TirCroix()));
		listeBateauJ1.add(bateauFactory.getPetitBateau(new Point(0, 2), Orientation.Est, new TirCroix()));
		
		// Joueur 2 :
		ArrayList<Bateau> listeBateauJ2 = new ArrayList<Bateau>();
		listeBateauJ2.add(bateauFactory.getGrosBateau(new Point(0, 7), Orientation.Est, new TirCroix()));
		listeBateauJ2.add(bateauFactory.getMoyenBateau(new Point(0, 8), Orientation.Est, new TirCroix()));
		listeBateauJ2.add(bateauFactory.getPetitBateau(new Point(0, 9), Orientation.Est, new TirCroix()));
		
		// Creation de la grille :
		// Joueur 1 :
		Grille grilleJ1 = new Grille(taille, listeBateauJ1);
		
		// Joueur 2 :
		Grille grilleJ2 = new Grille(taille, listeBateauJ2);		
		
		// ----- Creation des joueurs ----- //
		joueur1 = new Humain(grilleJ1);
		joueur2 = new Robot(grilleJ2);
		// ----- Mise en ralation d'afrontement des deux joueurs ----- //
		joueur1.setAdversaire(joueur2);
		joueur2.setAdversaire(joueur1);
	}
	
	public void lancerPartie() {
		while (true) {
			joueur1.jouerTour();
			this.setChanged();
			this.notifyObservers();
			
			joueur2.jouerTour();
			this.setChanged();
			this.notifyObservers();
			
		}
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	@Override
	public Grille getGridJoueur1() {
		return joueur1.grid;
	}
	
	

}
