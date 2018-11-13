package modele;

public interface BateauFactory {
	public BateauGros getGrosBateau();
	public BateauMoyen getMoyenBateau();
	public BateauPetit getPetitBateau();
}
