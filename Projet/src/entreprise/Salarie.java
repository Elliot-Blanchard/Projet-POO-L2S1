package entreprise;

public class Salarie {
	
	private String nom;
	private double poids, salaire, charge;
	
	public Salarie(String nom, double poids, double salaire) {
		this.nom = nom;
		this.poids = poids;
		this.salaire = salaire;
		this.charge = poids/8;
	}
	
	//	Getters
	
	public String getNom() {
		return this.nom;
	}
	public double getPoids() {
		return this.poids;
	}
	public double getSalaire() {
		return this.salaire;
	}
	public double getCharge() {
		return this.charge;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Salarie) {
			Salarie S = (Salarie)obj;
			if(this.nom == S.getNom() && this.poids == S.getPoids() && this.salaire == S.getSalaire() && this.charge == S.getCharge()) {
				return true;
			}
		}
		return false;
	}
}
