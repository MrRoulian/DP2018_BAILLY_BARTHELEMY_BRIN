package bateaux;

import java.awt.Point;

import modele.BateauPetit;
import modele.Orientation;
import modele.Tir;

public class Aeroglisseur extends BateauPetit {

	public Aeroglisseur(Point position, Orientation orientation, Tir tir) {
		super(1, 2, position, orientation, tir);
	}

}
