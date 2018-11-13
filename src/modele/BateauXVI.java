package modele;

import java.awt.Point;

import bateaux.Barquasse;
import bateaux.Galion;
import bateaux.Sloup;

public class BateauXVI implements BateauFactory{

	@Override
	public BateauGros getGrosBateau(Point position, Orientation orientation, Tir tir) {
		return new Galion(position, orientation, tir);
	}

	@Override
	public BateauMoyen getMoyenBateau(Point position, Orientation orientation, Tir tir) {
		return new Sloup(position, orientation, tir);
	}

	@Override
	public BateauPetit getPetitBateau(Point position, Orientation orientation, Tir tir) {
		return new Barquasse(position, orientation, tir);
	}

}
