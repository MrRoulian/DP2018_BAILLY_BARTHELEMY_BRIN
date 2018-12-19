package bateaux;

import java.awt.Point;

import modele.BateauGros;
import modele.Orientation;
import modele.Tir;

public class Galion extends BateauGros {

	public Galion(Point position, Orientation orientation, Tir tir) {
		super(4, 5, position, orientation, tir);
	}

	@Override
	public String toString() {
		return "Galion : "+super.toString();
	}

}
