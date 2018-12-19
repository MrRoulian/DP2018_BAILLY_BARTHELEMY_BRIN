package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vue.VueGraphique;

public interface InterfacePartie extends Remote {
	
	public Joueur getJoueur1() throws RemoteException;
	public Joueur getJoueur2() throws RemoteException;
	public void setVueGraphique(VueGraphique vg) throws RemoteException;
	public boolean jouerTour(Joueur j) throws RemoteException;
	public boolean getJoueur1Libre() throws RemoteException;
	public void setJoueur1Libre(boolean b) throws RemoteException;
	public Joueur getJoueurCourant() throws RemoteException;
	public boolean isEveryPlayersReady() throws RemoteException;
	public void setEveryPlayersReady(boolean allReady) throws RemoteException;
	public void setJoueur1(Joueur j) throws RemoteException;
	public void setJoueur2(Joueur j) throws RemoteException;
	public boolean isEnded() throws RemoteException;
	

}
