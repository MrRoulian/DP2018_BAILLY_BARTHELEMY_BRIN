package modele;

import java.awt.Point;

public interface BateauFactory {
	public BateauGros getGrosBateau(Point position, Orientation orientation, Tir tir);
	public BateauMoyen getMoyenBateau(Point position, Orientation orientation, Tir tir);
	public BateauPetit getPetitBateau(Point position, Orientation orientation, Tir tir);
}
