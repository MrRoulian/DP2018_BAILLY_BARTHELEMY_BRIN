package main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import exception.TropDeBateauException;
import modele.BateauFactory;
import modele.BateauXVI;
import modele.BateauXX;
import modele.Humain;
import modele.Partie;
import modele.Robot;

public class Serveur {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, TropDeBateauException {
		
		try {

		     UIManager.setLookAndFeel(new 
		javax.swing.plaf.metal.MetalLookAndFeel());

		} catch (UnsupportedLookAndFeelException e) {
		     e.printStackTrace();
		}

		
		String utilisation = "Utilisation : java Serveur <epoque> <taille d'arrène> <nombre de bateau>\nIl faut remplacer époque par 1 pour séléctionner époque XVIe siecle et 2 pour XXe siecle.";
		BateauFactory fact = null;
		int taille = 0;
		int nbBateau = 0;
		if (args.length != 3){
			System.out.println(utilisation);
			System.exit(1);
		} else {
			switch(args[0]){
			case "1":
				fact = BateauXVI.getInstance();
				break;
			case "2":
				fact = BateauXX.getInstance();
				break;
			default:
				System.out.println(utilisation);
				System.exit(1);
				break;
			}
			try{
				taille = Integer.parseInt(args[1]);
				nbBateau = Integer.parseInt(args[2]);
				if (taille < 4){
					System.out.println("Taille min : 4");
					System.exit(1);
				}
				if (nbBateau < 1){
					System.out.println("Nb bateau min : 1");
					System.exit(1);
				}
			} catch (Exception e){
				System.out.println(utilisation);
			}
		}
		
		System.out.println("Constructing server implementation...");
		
		Partie p = new Partie();
		
		System.out.println("Binding server implementation to registry...");
		
		String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Bataille_navale";
		
		Naming.rebind(url, p);
		
		System.out.println("Waiting for invocations from clients...");
		
		while(!p.isEveryPlayersReady()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		p.genererPartieRandom(taille, nbBateau, fact);
		
		while(!p.isEnded()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		System.exit(1);
	}
}
