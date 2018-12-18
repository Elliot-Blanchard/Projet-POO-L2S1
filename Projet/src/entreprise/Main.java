package entreprise;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Vehicule.prixEssence =1.45;
		ArrayList<Salarie> sal = new ArrayList<Salarie>();
		ArrayList<Vehicule> veh = new ArrayList<Vehicule>();
		
		// Création des salariés et ajout à la liste
		sal.add(new Salarie("Louise", 55, 7.4));
		sal.add(new Salarie("Alfred", 80, 7.2));
		sal.add(new Salarie("Camille", 67, 7.5));
		sal.add(new Salarie("Pierre", 62, 7.2));
		
		// Création des véhicules et ajout à la liste
		veh.add(new Velo("Velov", 450));
		veh.add(new Velo("Bicloo", 500));
		veh.add(new Scooter("Piagi", 2000, 150, 6, 35));
		veh.add(new Scooter("Yamama", 3500, 300, 7.5, 50));
		veh.add(new Scooter("Vespo", 2500, 125, 5.5, 30));
		veh.add(new Voiture("Twingo", 50, 4000, 25, 200, 8));
		
		// Création d'une course et test
		Course C = new Course(3, 45, sal, veh);
		C.choixLivreur();
		
	}

}
