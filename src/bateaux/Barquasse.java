package bateaux;

import java.awt.Point;

import modele.BateauPetit;
import modele.Orientation;
import modele.Tir;

public class Barquasse extends BateauPetit {

	public Barquasse(Point position, Orientation orientation, Tir tir) {
		super(1, 1, position, orientation, tir);
	}

}
