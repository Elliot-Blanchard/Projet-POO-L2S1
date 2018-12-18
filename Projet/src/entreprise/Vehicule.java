package entreprise;

public abstract class Vehicule {
	private String nom;
	private double vitesse, prix, t_co2, charge, coutUti;
	public static double prixEssence;
	
	/**
	 * Constructeur de la classe abstraite Véhicule
	 * @param n String : Nom du véhicule
	 * @param v double : Vitesse en km/h
	 * @param p double : prix en €
	 * @param t double : taux d'émission de CO2
	 * @param ch double : charge utile en kg
	 * @param cu double : coût d'utilisation par km en € 
	 */
	public Vehicule(String n, double v, double p, double t, double ch, double cu) {
		this.nom = n;
		this.vitesse = v;
		this.prix = p;
		this.t_co2 = t;
		this.charge = ch;
		this.coutUti = cu;
	}
	
	//	Getters
		
	public String getNom() {
	return this.nom;
	}
	public double getVitesse() {
	return this.vitesse;
	}
	public double getCharge() {
	return this.charge;
	}
	public double getPrix() {
	return this.prix;
	}
	public double getT_co2() {
	return this.t_co2;
	}
	public double getCoutUti() {
	return this.coutUti;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Vehicule) {
			Vehicule V = (Vehicule)obj;
			if(this.nom == V.getNom() && this.vitesse == V.getVitesse() && this.prix == V.getPrix() && this.t_co2 == V.getT_co2() && this.charge == V.getCharge() && this.coutUti == V.getCoutUti()) {
				return true;
			}
		}
		return false;
	}
}
