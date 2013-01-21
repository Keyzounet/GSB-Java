import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Fenetre unAccueilComptable = new Fenetre();
		
		ArrayList <Visiteur> lesVisiteurs = PasserelleBDD.afficherVisiteurs();
		for (int i = 0; i < lesVisiteurs.size(); i++) {
			System.out.println(lesVisiteurs.get(i).getIdVisiteur());
			System.out.println(lesVisiteurs.get(i).getNomVisiteur());
			System.out.println("");
			
		}
		System.out.println(PasserelleFct.dateJour());
		System.out.println(PasserelleFct.dateJour());
		
		


	}

}
