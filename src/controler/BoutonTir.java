package controler;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Joueur;
import modele.Partie;

public class BoutonTir implements ActionListener{
	
	private int x,y;
	private Partie p;
	
	public BoutonTir(int x, int y, Partie p) {
		this.x=x;
		this.y=y;
		this.p=p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (p.jouerTourJoueurCourant(p.getJoueurCourant().getNumBateauSelectionne(), x, y)){
			// le robot joue en random
			p.jouerTourJoueurCourant(0,0,0);
		}
	}

}
