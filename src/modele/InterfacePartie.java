package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vue.VueGraphique;

public interface InterfacePartie extends Remote {
	
	public Joueur getJoueur01() throws RemoteException;
	public Joueur getJoueur02() throws RemoteException;
	public void setVueGraphique(VueGraphique vg) throws RemoteException;
	public boolean jouerTour(Joueur j) throws RemoteException;
	public boolean getJoueur1Libre() throws RemoteException;
	public void setJoueur1Libre(boolean b) throws RemoteException;

}
