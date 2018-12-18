package entreprise;
import java.util.ArrayList;

public class Course {
	private double dist;
	private ArrayList<Livreur> livreurs;
	
	/**
	 * Constructeur de la classe Course
	 * @param poids 	double : poids de l'objet à livrer
	 * @param dist		double : distance à parcourir en km
	 * @param salaries	ArrayList : Liste des salariés disponibles pour la course
	 * @param vehicules ArrayList : Liste des véhicules disponibles pour la course
	 */
	public Course(double poids, double dist, ArrayList<Salarie> salaries, ArrayList<Vehicule> vehicules) { 
		// poids n'est pas enregistré car il ne sert qu'à définir la liste des livreurs possibles.
		this.dist = dist;
		livreurs = new ArrayList<Livreur>();
		for (Salarie S : salaries) {
			for (Vehicule V : vehicules) {
				// Vérifie si la course est possible avec la charge utile du livreur choisi, et peut être accomplie en moins d'1 heure.
				if((S.getCharge() >= poids || V.getCharge() >= poids) && (dist/V.getVitesse()) <= 1){
					livreurs.add(new Livreur(V, S));
				}
			}
		}
	}
	
	/**
	 * Renvoie le coût d'une course avec un livreur passé en paramètre.
	 * @param l Livreur
	 * @return un double représentant le prix de la course pour le livreur l
	 */
	private double prixCourse(Livreur l) {
		// On considère que le livreur est payé en nombre entier d'heures, arrondi au nombre supérieur.
		return l.getV().getCoutUti()*dist + 2 * l.getS().getSalaire()*( Math.ceil(2*dist/l.getV().getVitesse())); 
	}
	
	
	/**
	 * Fonction principale de la classe, qui renvoie la liste des livreurs choisis selon les conditions de l'énoncé.
	 * @return un ArrayList de livreurs dont la course est optimale et les émissions de CO2 sont minimales
	 */
	public ArrayList<Livreur> choixLivreur() {
		
		this.livreurs = optimiser();
		
		ArrayList<Livreur> nvLiv = new ArrayList<Livreur>();
		for(Livreur L1 : livreurs) {
			if(triCO2(L1)) {
				nvLiv.add(L1);
			}
		}
		livreurs = nvLiv;
		for(Livreur L : livreurs) {
			System.out.println(L.getS().getNom() + " " + L.getV().getNom() + " " + prixCourse(L));
		}
		return livreurs;
		
	}
	
	/**
	 * Optimise la liste des livreurs de l'objet Course.
	 * @return un ArrayList des livreurs dont la course est optimale (pas pire qu'un autre Livreur). 
	 */
	private ArrayList<Livreur> optimiser() {
		ArrayList<Livreur> nvLivreurs = new ArrayList<Livreur>();
		for(Livreur L : livreurs) {
			if(pasPire(L)) {
				nvLivreurs.add(L);
			}
		}
		return nvLivreurs;
	}
	
	/**
	 * Vérifie que le livreur L n'est pas pire qu'un autre pour cette course.
	 * @param L Le livreur à comparer.
	 * @return un booléen, vrai si le livreur n'est pas pire qu'un autre.
	 */
	private boolean pasPire(Livreur L) {
		for(Livreur L2: livreurs) {
			if(comparer(L,L2)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Compare deux livreurs, l1 et l2, et renvoie true si si l1 est "pire" que l2.
	 * @param l1 un livreur
	 * @param l2 autre livreur
	 * @return Renvoie un booléen vérifiant si l1 est "pire" que L2
	 */
	private boolean comparer(Livreur l1, Livreur l2) {
		// La condition a été simplifiée pour n'avoir que deux parties.
		if (l1.getV().getT_co2() >  l2.getV().getT_co2() && prixCourse(l1) >=  prixCourse(l2) ||
			l1.getV().getT_co2() >= l2.getV().getT_co2() && prixCourse(l1) >  prixCourse(l2)) { // Pas besoin d'utiliser la distance pour le taux de CO2, toutes les courses font la même distance
			return true;
		} else {
			return false;
		}
	}
	 /**
	  * compare les émissions de C02 du livreur L avec celles des autres livreurs de la liste. 
	  * @param L le livreur à tester
	  * @return Retourne false si le livreur L émet autant ou moins de CO2 que tous les autres dans la liste.
	  */
	// 
	private boolean triCO2(Livreur L) {
		for(Livreur L2: livreurs) {
			if(L.getV().getT_co2() > L2.getV().getT_co2()) {
				return false;
			}
		}
		return true;
	}	
}