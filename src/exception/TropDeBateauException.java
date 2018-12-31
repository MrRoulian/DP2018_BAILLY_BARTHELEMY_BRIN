package exception;

public class TropDeBateauException extends Exception  {
	
	public TropDeBateauException(){
		System.err.println("Trop de bateau par rapport a la taille de la carte");
	}

}
