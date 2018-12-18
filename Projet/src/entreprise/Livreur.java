package entreprise;

// La classe Livreur représente un couple salarié/véhicule. Elle est utilisée pour simplifier les méthodes dans la classe Course.
public class Livreur {
	private Vehicule v;
	private Salarie s;
	public Livreur(Vehicule V, Salarie S) {
		v = V;
		s = S;
	}
	
	//	Getters
	
	public Vehicule getV() {
		return v;
	}
	public Salarie getS() {
		return s;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Livreur) {
			Livreur L = (Livreur)obj;
			return (this.v.equals(L.getV()) && this.s.equals(L.getS()));
		}else {
			return false;
		}
	}
	
	
}
