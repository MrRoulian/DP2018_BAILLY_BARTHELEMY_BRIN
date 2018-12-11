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

public class ClientRobot {
	
	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException, MalformedURLException, UnknownHostException
	{

		InterfacePartie p = (InterfacePartie) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Bataille_navale");
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
			
			p.jouerTour(moiCourrant);
		}
		
	}
	
}
