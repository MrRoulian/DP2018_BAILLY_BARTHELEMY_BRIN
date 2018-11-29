package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

import modele.InterfacePartie;
import modele.Joueur;
import vue.VueGraphique;

public class Client {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry();
		System.out.print("RMI registry bindings: ");
		String[] e = registry.list();
		for (int i=0; i<e.length; i++)
			System.out.println(e[i]);
		
		InterfacePartie p = (InterfacePartie) registry.lookup("Bataille_navale");
		Joueur moi = null;
		Joueur adversaire = null;

		if (p.getJoueur1Libre()){
			moi = p.getJoueur1();
			adversaire = p.getJoueur2();
			p.setJoueur1Libre(false);			
		} else {
			moi = p.getJoueur2();
			adversaire = p.getJoueur1();
		}
		
		VueGraphique vg = new VueGraphique(moi,adversaire,p);
		
		Joueur moiCourrant = null;
		Joueur adversaireCourrant = null;
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if (moi.equals(p.getJoueur1())){
				moiCourrant = p.getJoueur1();
				adversaireCourrant = p.getJoueur2();
			} else {
				moiCourrant = p.getJoueur2();
				adversaireCourrant = p.getJoueur1();
			}			

			//je mets a jour les joueurs de la vue
			vg.updateJoueur(moiCourrant, adversaireCourrant);
			moiCourrant.setNumBateauSelectionne(moi.getNumBateauSelectionne());
			moiCourrant.setCiblePourTirer(moi.getCiblePourTirer());
			
			//Si j'ai pu jouer mon tour
			if (p.jouerTour(moiCourrant)){				
				moi.setCiblePourTirer(null);	
			}
			
			//Mets � jour l'affichage
			vg.update();
		}
		
	}
	
}
