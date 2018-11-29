package modele;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vue.VueGraphique;

public class Partie extends UnicastRemoteObject implements InterfacePartie {

	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurCourant;
	private BateauFactory bateauFactory;
	private transient VueGraphique vg;
	private boolean joueur1Libre = true;

	public Partie() throws RemoteException{
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
		joueur1 = new Humain(grilleJ1,1);
		joueur2 = new Robot(grilleJ2,2);

		//----Set du joueur courant ----//
		joueurCourant = joueur1;
	}

	public void lancerPartie() {
		while (true) {
			joueur1.jouerTour(joueur2);
			vg.update();

			joueur2.jouerTour(joueur1);
			vg.update();
		}
	}

	
	/*@Override
	public boolean jouerTour(Joueur j){
		Joueur adversaire = j.equals(joueur1)?joueur2:joueur1;

		if (j.aPerdu()) {
			System.out.println("Victoire du joueur 1");
			vg.update(null, null);
			return false;
		}

		if (adversaire.aPerdu()) {
			System.out.println("Victoire du joueur 2");
			vg.update(null, null);
			return false;
		}


		if (j.equals(joueurCourant)){
			j.jouerTour(adversaire);
			joueurCourant = adversaire;
			vg.update(null, null);
			return true;
		}
		return false;
	}*/

	//Jouer tour en graphique
	public boolean jouerTour(Joueur j) {
		Joueur adversaire = j.equals(joueur1)?joueur2:joueur1;
		
		//si ce n'est pas au joueur de jouer on arrête la méthode
		if (!j.equals(joueurCourant)){
			return false;
		}

		if (joueur2.aPerdu()) {
			System.out.println("Victoire du joueur 1");
			return false;
		}

		if (joueur1.aPerdu()) {
			System.out.println("Victoire du joueur 2");
			return false;
		}		

		if (j.jouerTour(adversaire)) {
			joueurCourant = adversaire;
			return true;
		}
		return false;
	}

	@Override
	public Joueur getJoueur1() {
		return joueur1;
	}

	@Override
	public Joueur getJoueur2() {
		return joueur2;
	}
	
	@Override
	public Joueur getJoueurCourant(){
		return joueurCourant;
	}

	@Override
	public void setVueGraphique(VueGraphique vg) {
		this.vg=vg;
	}

	@Override
	public boolean getJoueur1Libre() throws RemoteException {
		return joueur1Libre;
	}

	@Override
	public void setJoueur1Libre(boolean b) throws RemoteException {
		joueur1Libre = b;		
	}



}
