package main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import modele.Partie;

public class Serveur {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		System.out.println("Constructing server implementation...");
		
		Partie p = new Partie();
		
		System.out.println("Binding server implementation to registry...");
		
		Registry registry= LocateRegistry.getRegistry();
		registry.bind("Bataille_navale", p);
		
		System.out.println("Waiting for invocations from clients...");
	}
}
