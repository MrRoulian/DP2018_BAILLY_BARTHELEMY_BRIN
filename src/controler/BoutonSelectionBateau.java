package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Partie;

public class BoutonSelectionBateau implements ActionListener {

	private int numBateau;
	private Partie p;

	public BoutonSelectionBateau(int numBateau, Partie p) {
		this.numBateau = numBateau;
		this.p=p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.getJoueurCourant().setNumBateauSelectionne(numBateau);	
	}

}
