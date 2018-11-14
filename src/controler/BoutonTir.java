package controler;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Joueur;
import modele.Partie;

public class BoutonTir implements ActionListener{
	
	private int x,y;
	private Joueur joueur;
	
	public BoutonTir(int x, int y, Joueur joueur) {
		this.x=x;
		this.y=y;
		this.joueur=joueur;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		joueur.getGrille().toucher(new Point(x, y), 1);
	}

}
