package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Partie {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private BateauFactory bateauFactory;
	
	public Partie() {
		// ----- Recuperation de l'instance de la factory ----- //
		bateauFactory = BateauXX.getInstance();
		
		// ----- Creation des grille ----- //
		// Taille de la grille :
		int taille = 10;
		// Creation de la liste de bateau :
		// Joueur 1 :
		ArrayList<Bateau> listeBateauJ1 = new ArrayList<Bateau>();
		listeBateauJ1.add(bateauFactory.getGrosBateau(new Point(0, 0), Orientation.Est, new TirAleatoire()));
		listeBateauJ1.add(bateauFactory.getMoyenBateau(new Point(0, 1), Orientation.Est, new TirAleatoire()));
		listeBateauJ1.add(bateauFactory.getPetitBateau(new Point(0, 2), Orientation.Est, new TirAleatoire()));
		
		// Joueur 2 :
		ArrayList<Bateau> listeBateauJ2 = new ArrayList<Bateau>();
		listeBateauJ2.add(bateauFactory.getGrosBateau(new Point(0, 0), Orientation.Est, new TirAleatoire()));
		listeBateauJ2.add(bateauFactory.getMoyenBateau(new Point(0, 1), Orientation.Est, new TirAleatoire()));
		listeBateauJ2.add(bateauFactory.getPetitBateau(new Point(0, 2), Orientation.Est, new TirAleatoire()));
		
		// Creation de la grille :
		// Joueur 1 :
		Grille grilleJ1 = new Grille(taille, listeBateauJ1);
		
		// Joueur 2 :
		Grille grilleJ2 = new Grille(taille, listeBateauJ2);
		
		// ----- Creation des joueurs ----- //
		joueur1 = new Humain(grilleJ1);
		joueur2 = new Humain(grilleJ2);
		// ----- Mise en ralation d'afrontement des deux joueurs ----- //
		joueur1.setAdversaire(joueur2);
		joueur2.setAdversaire(joueur1);
	}
	
	

}
