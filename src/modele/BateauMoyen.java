package modele;

import java.awt.Point;

public class BateauMoyen extends Bateau {

	public BateauMoyen(int puissance, int resistance, Point position, Orientation orientation, Tir tir) {
		super(puissance, 2, 2, position, orientation, tir);
	}

}
