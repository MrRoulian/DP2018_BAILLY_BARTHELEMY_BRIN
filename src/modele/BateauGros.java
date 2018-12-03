package modele;

import java.awt.Point;

public abstract class BateauGros extends Bateau{

	public BateauGros(int puissance, int resistance, Point position, Orientation orientation, Tir tir) {
		super(puissance, 4, 4, position, orientation, tir);
	}

}
