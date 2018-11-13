package bateaux;

import java.awt.Point;

import modele.BateauGros;
import modele.Orientation;
import modele.Tir;

public class Croiser extends BateauGros{

	public Croiser(Point position, Orientation orientation, Tir tir) {
		super(10, 8, position, orientation, tir);
	}

}
