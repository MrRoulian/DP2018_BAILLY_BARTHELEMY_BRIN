package main;

import modele.Partie;
import vue.VueGraphique;

public class Main {
	public static void main(String[] args) {
		Partie p = new Partie();
		VueGraphique vg = new VueGraphique(p,p.getJoueur1());
		//VueGraphique vg2 = new VueGraphique(p,p.getJoueur2());
		
		p.addObserver(vg);
		//p.addObserver(vg2);
		
		//p.lancerPartie();
	}
}
