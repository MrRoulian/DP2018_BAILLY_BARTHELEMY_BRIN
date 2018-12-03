package main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import modele.InterfacePartie;
import modele.Joueur;
import vue.VueGraphique;

public class Client {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException, MalformedURLException, UnknownHostException
	{		
		InterfacePartie p = (InterfacePartie) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Bataille_navale");
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
			
			//Mets à jour l'affichage
			vg.update();
		}
		
	}
	
}
