package test;

import java.awt.Point;
import java.util.ArrayList;

import modele.Bateau;
import modele.BateauXVI;
import modele.Grille;
import modele.Orientation;
import modele.TirUnique;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Bateau> bateaux = new ArrayList<>();
		bateaux.add(BateauXVI.getInstance().getPetitBateau(new Point(0,0), Orientation.Sud, new TirUnique()));
		bateaux.add(BateauXVI.getInstance().getGrosBateau(new Point(5,3), Orientation.Est, new TirUnique()));
		bateaux.add(BateauXVI.getInstance().getMoyenBateau(new Point(2,7), Orientation.Est, new TirUnique()));
		
		Grille grid = new Grille(10,bateaux);
		
		grid.afficherGrilleJoueur();
		grid.afficherGrilleAdversaire();

	}

}
