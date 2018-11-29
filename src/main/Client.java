package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

import modele.Partie;

public class Client {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry();
		System.out.print("RMI registry bindings: ");
		String[] e = registry.list();
		for (int i=0; i<e.length; i++)
			System.out.println(e[i]);
		
		Partie p = (Partie) registry.lookup("Bataille_navale");
		
		System.out.println("Voilà la grille du joueur1" + p.getGridJoueur1());
	}
	
}
