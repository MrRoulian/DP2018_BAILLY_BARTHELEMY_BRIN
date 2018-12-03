package modele;

import java.awt.Point;

public class TirUnique implements Tir {

	@Override
	public void tirer(Point position, Grille cible, int puissance) {
		cible.toucher(position,puissance);
	}
	
	public String toString(){
		return "Tir unique";
	}

}
