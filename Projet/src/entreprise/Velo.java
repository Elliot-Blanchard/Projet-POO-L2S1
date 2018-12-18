package entreprise;

public class Velo extends Vehicule{
	public Velo(String nom, double prix) {
		super(nom, 15, prix, 0, 0, prix/30000); //vitesse moyenne = 15 km/h, pas de carburant ni d'emissions de Co2
	}

}