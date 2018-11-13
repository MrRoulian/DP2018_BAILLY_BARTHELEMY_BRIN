package bateaux;

import java.awt.Point;

import modele.BateauMoyen;
import modele.Orientation;
import modele.Tir;

public class Sloup extends BateauMoyen {

	public Sloup(Point position, Orientation orientation, Tir tir) {
		super(3, 2, position, orientation, tir);
	}

}
