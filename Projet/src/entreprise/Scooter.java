package entreprise;

public class Scooter extends Vehicule{
	//la cylindrée définit la vitesse et ses émissions de CO2. Sa consommation d'essence définit con coût d'utilisation au km.
	public Scooter(String nom, double prix, double cylindree, double conso, double charge) {
		super(nom, 30+(cylindree/50), prix, cylindree/4, charge, (prix/20000)+(prixEssence*(conso/100)));
	}
}
