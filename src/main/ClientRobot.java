package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

import modele.InterfacePartie;
import modele.Joueur;

public class ClientRobot {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry();
		System.out.print("RMI registry bindings: ");
		String[] e = registry.list();
		for (int i=0; i<e.length; i++)
			System.out.println(e[i]);
		
		InterfacePartie p = (InterfacePartie) registry.lookup("Bataille_navale");
		Joueur moi = null;

		if (p.getJoueur1Libre()){
			moi = p.getJoueur1();
			p.setJoueur1Libre(false);			
		} else {
			moi = p.getJoueur2();
		}
		
		Joueur moiCourrant = null;
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if (moi.equals(p.getJoueur1())){
				moiCourrant = p.getJoueur1();
			} else {
				moiCourrant = p.getJoueur2();
			}
			
			
			//Si j'ai pu jouer mon tour
			p.jouerTour(moiCourrant);
		}
		
	}
	
}
