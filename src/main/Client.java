package main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import modele.Humain;
import modele.InterfacePartie;
import modele.Joueur;
import vue.VueGraphique;

public class Client {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException, MalformedURLException, UnknownHostException
	{
		//Pour rejoindre un serveur, remplacer le InetAddress.getLocalHost().getHostAddress() par l'adresse ip du sereur
		InterfacePartie p = null;
		
		if (args.length == 1){
			p = (InterfacePartie) Naming.lookup("rmi://" + args[0] + "/Bataille_navale");
		} else if (args.length == 0){
			p = (InterfacePartie) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Bataille_navale");
		} else {
			System.out.println(	"Pour utiliser le client en ligne avec un autre joueur il faut mettre son adresse ip en paramètre\n"+
								"java Client 192.168.43.17 par exemple");
		}
		
		Joueur moi = null;
		Joueur adversaire = null;
		boolean isJoueur1 = false;
		
		if (p.getJoueur1Libre()){
			p.setJoueur1Libre(false);
			isJoueur1=true;
			p.setJoueur1(new Humain(null, 1));
		} else {
			p.setJoueur2(new Humain(null, 2));
			p.setEveryPlayersReady(true);
		}
		
		while(!p.isEveryPlayersReady()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("En attente d'adversaire");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (isJoueur1){
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
