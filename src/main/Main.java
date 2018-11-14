package main;

import modele.Partie;
import vue.VueGraphique;

public class Main {
	public static void main(String[] args) {
		Partie p = new Partie();
		VueGraphique vg = new VueGraphique(p);
		p.addObserver(vg);
		
		p.lancerPartie();
	}
}
