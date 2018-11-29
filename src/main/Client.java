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
			moi = p.getJoueur01();
			adversaire = p.getJoueur02();
			p.setJoueur1Libre(false);			
		} else {
			moi = p.getJoueur02();
			adversaire = p.getJoueur01();
		}
		
		VueGraphique vg = new VueGraphique(moi,adversaire);
		p.setVueGraphique(vg);
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (p.jouerTour(moi)){
				vg.update(null, null);
			}
		}
		
	}
	
}
