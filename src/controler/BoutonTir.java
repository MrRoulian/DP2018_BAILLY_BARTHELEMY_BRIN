package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Joueur;
import modele.Partie;

public class BoutonTir implements ActionListener{
	
	private int x,y;
	private Partie p;
	private Joueur j;
	
	public BoutonTir(int x, int y, Partie p, Joueur j) {
		this.x=x;
		this.y=y;
		this.p=p;
		this.j=j;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (p.jouerTour(j, x, y)){
			
			// si je joue contre un robot il faudra faire cette instruction aussi
			p.jouerTour(j.getAdversaire(),0,0);
		}
	}

}
