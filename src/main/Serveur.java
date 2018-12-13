package main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import modele.BateauXX;
import modele.Humain;
import modele.Partie;
import modele.Robot;

public class Serveur {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException {
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

		p.genererPartieRandom(10, 6, BateauXX.getInstance());
	}
}
