package exception;

public class TropDeBateauException extends Exception  {
	
	public TropDeBateauException(){
		System.err.println("Trop de bateau par rapport à la taille de la carte");
	}

}
