package modele;

import java.rmi.Remote;

public interface InterfacePartie extends Remote {
	
	public Grille getGridJoueur1();

}
