package entreprise;

public class Voiture extends Vehicule {
	// Exemple d'un nouveau type de véhicule.
	public Voiture(String nom, double vitesse, double prix, double t_CO2, double charge, double consoEssence) {
		super(nom, vitesse, prix, t_CO2, charge, prix/15000 + prixEssence*(consoEssence/100));
	}
}
