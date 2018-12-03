package modele;

import java.awt.Point;

public class BateauPetit extends Bateau {

	public BateauPetit(int puissance, int resistance, Point position, Orientation orientation, Tir tir) {
		super(puissance, 1, 1, position, orientation, tir);
	}

}
