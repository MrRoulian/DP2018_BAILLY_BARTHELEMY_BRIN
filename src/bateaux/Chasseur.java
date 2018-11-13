package bateaux;

import java.awt.Point;

import modele.BateauMoyen;
import modele.Orientation;
import modele.Tir;

public class Chasseur extends BateauMoyen {

	public Chasseur(Point position, Orientation orientation, Tir tir) {
		super(7, 5, position, orientation, tir);
	}

}
