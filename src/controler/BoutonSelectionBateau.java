package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Joueur;
import modele.Partie;

public class BoutonSelectionBateau implements ActionListener {

	private int numBateau;
	private Joueur joueur;

	public BoutonSelectionBateau(int numBateau, Joueur joueur) {
		this.numBateau = numBateau;
		this.joueur=joueur;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		joueur.setNumBateauSelectionne(numBateau);	
	}

}
