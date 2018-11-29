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
		this.j=j;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			//Si c'est ton tour, que t'as déjà selectionné un bateau et que celui ci n'est pas coulé tu peux selectionner la ou tu veux tirer
			if (j.getNumBateauSelectionne()>0 && j.equals(p.getJoueurCourant()) && !j.getGrille().getBateau(j.getNumBateauSelectionne()-1).estCoulé()){
				j.setCiblePourTirer(new Point(x,y));				
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}