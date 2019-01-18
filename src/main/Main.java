package main;

import java.rmi.RemoteException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import exception.TropDeBateauException;
import modele.BateauXX;
import modele.Humain;
import modele.Partie;
import modele.Robot;
import vue.VueGraphique;

public class Main {
	//est obseléte depuis le RMI, sert juste pour les tests
	public static void main(String[] args) throws RemoteException, TropDeBateauException{
		try {

		     UIManager.setLookAndFeel(new 
		javax.swing.plaf.metal.MetalLookAndFeel());

		} catch (UnsupportedLookAndFeelException e) {
		     e.printStackTrace();
		}

		
		Partie p = new Partie(new Humain(null,1),new Robot(null,2),BateauXX.getInstance());
		
		VueGraphique vg = new VueGraphique(p.getJoueur1(),p.getJoueur2(),p);
		
		p.setVueGraphique(vg);
	
		//p.lancerPartie();
	}
}
