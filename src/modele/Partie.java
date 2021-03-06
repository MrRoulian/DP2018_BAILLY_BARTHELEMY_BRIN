package modele;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import exception.TropDeBateauException;
import vue.VueGraphique;

public class Partie extends UnicastRemoteObject implements InterfacePartie {

	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurCourant;
	private BateauFactory bateauFactory;
	private transient VueGraphique vg;
	private boolean joueur1Libre = true;
	protected boolean everyPlayersReady;
	protected boolean isEnded = false;
	
	public Partie() throws RemoteException{
		
	}

	public Partie(Joueur j1, Joueur j2, BateauFactory factory) throws RemoteException, TropDeBateauException{
		// ----- Recuperation de l'instance de la factory ----- //
		bateauFactory = factory;

		// ----- Creation des grille ----- //
		// Taille de la grille :
		int taille = 10;
		
		this.joueur1 = j1;
		this.joueur2 = j2;
		genererPartieRandom(taille, 10, bateauFactory);

		/*
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
		joueur1 = new Robot(grilleJ1,1);
		joueur2 = new Robot(grilleJ2,2);

		//----Set du joueur courant ----//
		joueurCourant = joueur1;
		 */
	}

	public void lancerPartie() {
		while (true) {
			joueur1.jouerTour(joueur2);
			vg.update();

			joueur2.jouerTour(joueur1);
			vg.update();
		}
	}

	public void genererPartieRandom(int taille, int nbBateaux, BateauFactory epoque) throws TropDeBateauException{
		boolean ok = false;
		Point p = null;
		Orientation orient = null;
		Tir tir = null;

		// Creation de la grille :
		// Joueur 1 :
		Grille grilleJ1 = new Grille(taille, new ArrayList<Bateau>());

		// Joueur 2 :
		Grille grilleJ2 = new Grille(taille, new ArrayList<Bateau>());

		int compteur = 0;
		int varDebug = 1000;
		for (int i = 0 ; i < nbBateaux ; i++){
			ok = false;
			//switch sur la taille du bateau, petit moyen ou grand
			switch ((int)(Math.random()*3)){
			case 0:
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					orient = getRandomOrientation();
					tir = getRandomTir();
					ok = calculerListePointCorrect(p,orient,taille,4,grilleJ1);
					compteur++;
				}
				compteur = 0;
				grilleJ1.ajouterBateau(epoque.getGrosBateau(p, orient, tir));
				ok = false;
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					ok = calculerListePointCorrect(p,orient,taille,4,grilleJ2);
					compteur++;
				}
				compteur = 0;
				grilleJ2.ajouterBateau(epoque.getGrosBateau(p, orient, tir));
				
				break;
			case 1:
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					orient = getRandomOrientation();
					tir = getRandomTir();
					ok = calculerListePointCorrect(p,orient,taille,2,grilleJ1);
					compteur++;
				}
				compteur = 0;
				grilleJ1.ajouterBateau(epoque.getMoyenBateau(p, orient, tir));
				ok = false;
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					ok = calculerListePointCorrect(p,orient,taille,2,grilleJ2);
					compteur++;
				}
				compteur = 0;
				grilleJ2.ajouterBateau(epoque.getMoyenBateau(p, orient, tir));
				break;
			case 2:
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					orient = getRandomOrientation();
					tir = getRandomTir();
					ok = calculerListePointCorrect(p,orient,taille,1,grilleJ1);
					compteur++;
				}
				compteur = 0;
				grilleJ1.ajouterBateau(epoque.getPetitBateau(p, orient, tir));
				ok = false;
				while(!ok){
					//si on arrive pas a placer le bateau au bout de la varDebug eme fois on arrete d'essayer de placer
					if (compteur >= varDebug){ throw new TropDeBateauException(); }
					p = new Point((int)(Math.random()*taille),(int)(Math.random()*taille));
					ok = calculerListePointCorrect(p,orient,taille,1,grilleJ2);
					compteur++;
				}
				compteur = 0;
				grilleJ2.ajouterBateau(epoque.getPetitBateau(p, orient, tir));
				break;
			}
		}

		// ----- Creation des joueurs ----- //
		joueur1.setGrid(grilleJ1);
		joueur2.setGrid(grilleJ2);

		//----Set du joueur courant ----//
		joueurCourant = joueur1;
	}

	private boolean calculerListePointCorrect(Point p, Orientation orient, int tailleMap, int tailleBateau, Grille grilleDuJoueur) {
		switch (orient){
		case Nord:
			for (int i = 0 ; i <= tailleBateau ; i++ ){
				if (p.y - i < 0 || grilleDuJoueur.getCase(p.x, p.y-i) != 0){
					return false;
				}
			}
			break;
		case Sud:
			for (int i = 0 ; i <= tailleBateau ; i++ ){
				if (p.y + i >= tailleMap || grilleDuJoueur.getCase(p.x, p.y+i) != 0){
					return false;
				}
			}
			break;
		case Est:
			for (int i = 0 ; i <= tailleBateau ; i++ ){
				if (p.x + i >= tailleMap || grilleDuJoueur.getCase(p.x+i, p.y) != 0){
					return false;
				}
			}
			break;
		case Ouest:
			for (int i = 0 ; i <= tailleBateau ; i++ ){
				if (p.x - i < 0 || grilleDuJoueur.getCase(p.x-i, p.y) != 0){
					return false;
				}
			}
			break;
		}
		return true;
	}

	private Tir getRandomTir() {
		switch((int)(Math.random()*6)){
		case 0:
			return new TirEnX();
		case 1:
			return new TirCroix();
		case 2:
			return new TirImprobable();
		case 3:
			return new TirTordu();
		case 4:
			return new TirUnique();
		case 5:
			return new TirEnLigne();
		default :
			return new TirUnique();
		}
	}

	public boolean jouerTour(Joueur j) {
		Joueur adversaire = j.equals(joueur1)?joueur2:joueur1;

		//si ce n'est pas au joueur de jouer on arrete la methode
		if (!j.equals(joueurCourant)){
			return false;
		}

		if (joueur2.aPerdu()) {
			System.out.println("Victoire du joueur 1");
			isEnded=true;
			return false;
		}

		if (joueur1.aPerdu()) {
			System.out.println("Victoire du joueur 2");
			isEnded=true;
			return false;
		}		

		if (j.jouerTour(adversaire)) {
			joueurCourant = adversaire;
			return true;
		}
		return false;
	}	


	public Orientation getRandomOrientation(){
		switch((int)(Math.random()*4)){
		case 0:
			return Orientation.Nord;
		case 1:
			return Orientation.Sud;
		case 2:
			return Orientation.Est;
		case 3:
			return Orientation.Ouest;
		default:
			return Orientation.Nord;
		}
	}

	@Override
	public boolean isEveryPlayersReady() {
		return everyPlayersReady;
	}

	@Override
	public void setEveryPlayersReady(boolean everyPlayersReady) {
		this.everyPlayersReady = everyPlayersReady;
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
	
	@Override
	public void setJoueur1(Joueur j) throws RemoteException {
		this.joueur1 = j;		
	}

	@Override
	public void setJoueur2(Joueur j) throws RemoteException {
		this.joueur2 = j;		
	}

	@Override
	public boolean isEnded() throws RemoteException {
		return isEnded;
	}

}
