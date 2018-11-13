package modele;

import java.awt.Point;

import bateaux.Aeroglisseur;
import bateaux.Chasseur;
import bateaux.Croiser;

public class BateauXX implements BateauFactory {
	
	private static BateauXX instance;
	
	private BateauXX() {}
	
	public static BateauXX getInstance() {
		if (instance == null) {
			instance = new BateauXX();
		}
		return instance;
	}

	@Override
	public BateauGros getGrosBateau(Point position, Orientation orientation, Tir tir) {
		return new Croiser(position, orientation, tir);
	}

	@Override
	public BateauMoyen getMoyenBateau(Point position, Orientation orientation, Tir tir) {
		return new Chasseur(position, orientation, tir);
	}

	@Override
	public BateauPetit getPetitBateau(Point position, Orientation orientation, Tir tir) {
		return new Aeroglisseur(position, orientation, tir);
	}

	

}
