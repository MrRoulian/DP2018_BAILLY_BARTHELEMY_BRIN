package controler;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import modele.InterfacePartie;
import modele.Joueur;

public class BoutonTir implements ActionListener{

	private int x,y;
	private InterfacePartie p;
	private Joueur j;

	public BoutonTir(int x, int y, InterfacePartie p, Joueur j) {
		this.x=x;
		this.y=y;
		this.p=p;
		//Le joueur j ici est le joueur a l'initialisation de la map, il a tout ses boats full life
		this.j= j;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			//Si c'est ton tour, que t'as deja selectionne un bateau et que celui ci n'est pas coule tu peux selectionner la ou tu veux tirer
			if (j.getNumBateauSelectionne()>0 && j.equals(p.getJoueurCourant())){
				if (!(j.equals(p.getJoueur1())?p.getJoueur1():p.getJoueur2()).getGrille().getBateau(j.getNumBateauSelectionne()-1).estCoule()){
					j.setCiblePourTirer(new Point(x,y));
				} else {
					System.err.println("Le bateau " + j.getNumBateauSelectionne() + " est coule, vous ne pouvez plus tirer avec.");
				}
								
			}
			
		} catch (RemoteException e) {
			//Si on arrive ici, c'est surement que la partie est termine
		}
	}

}