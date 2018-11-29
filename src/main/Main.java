package main;

import java.rmi.RemoteException;

import modele.Partie;
import vue.VueGraphique;

public class Main {
	public static void main(String[] args) throws RemoteException{
		Partie p = new Partie();
		
		VueGraphique vg = new VueGraphique(p.getJoueur1(),p.getJoueur2(),p);
		
		p.setVueGraphique(vg);
	
		//p.lancerPartie();
	}
}
