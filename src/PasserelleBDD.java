import java.sql.*;
import java.util.ArrayList;
/**
 * Classe regroupant les fonctions liées à  la base de données
 * 
 * @author mac-kevin
 *
 */
public class PasserelleBDD {

	public static Comptable objetSessionComptable = null;

	public PasserelleBDD() {

	}

	private static Connection connexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//con.close(); // Fermeture de la connexion
		return con;
	}

	public static ArrayList <Visiteur> afficherVisiteurs() {
		Connection con = connexion();
		Statement st;
		ResultSet rs = null;
		Visiteur leVisiteur;
		
		String id, nom;
		
		ArrayList <Visiteur> lesVisiteurs = new ArrayList <Visiteur>();

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM visiteur");
			while (rs.next()) {
				id = rs.getString(1);
				nom = rs.getString(2);
				leVisiteur = new Visiteur(id, nom);
				lesVisiteurs.add(leVisiteur);
			}
			rs.close() ;   // Permet de libérer la mémoire utilisée.


		} catch(Exception erreur) {
			System.out.println(erreur);
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return lesVisiteurs;
	}

	public static String seConnecter(String unLogin, String unMdp) {
		Connection con = connexion();
		Statement st;
		ResultSet rs = null;
		ArrayList <Visiteur> lesVisiteurs;
		Comptable leComptable = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT comptable.id, comptable.nom, comptable.prenom, comptable.login, comptable.mdp FROM comptable WHERE comptable.login= '" + unLogin + "' AND comptable.mdp= '" + unMdp + "' ;");

			if (rs.next()) {
				String id = rs.getString(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String login = rs.getString(4);
				String mdp = rs.getString(5);
				lesVisiteurs = afficherVisiteurs();
				leComptable = new Comptable(id, login, mdp, nom, prenom, lesVisiteurs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		objetSessionComptable  = leComptable;

		if (estConnecte()) 
			return "Connexion réussie !";
		else 
			return "Connexion échouée !";
	}

	public static boolean estConnecte() {
		return objetSessionComptable != null;
	}

	public static void majEtatFicheFrais(String idVisiteur, String mois, String etat) {
		Connection con = connexion();
		Statement st;

		try {
			st = con.createStatement();
			st.executeUpdate("UPDATE ficheFrais SET idEtat = '" + etat + "', dateModif = '" + PasserelleFct.dateJour() + "' where fichefrais.idvisiteur = '" + idVisiteur + "' and fichefrais.mois = '" + mois + "'");
		} catch(Exception erreur) {
			System.out.println(erreur);
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
//	public FicheFrais getLesInfosFicheFrais(String idVisiteur, String mois) {
//		Connection con = connexion();
//		Statement st;
//		ResultSet rs = null;
//		
//		String idVisiteur, mois, nbJustificatifs, dateModif, idEtat;
//		int montantValide;
//		
//		try {
//			st = con.createStatement();
//			rs = st.executeQuery("SELECT ficheFrais.idVisiteur, ficheFrais.mois, ficheFrais.nbJustificatifs, ficheFrais.montantValide, ficheFrais.dateModif, ficheFrais.idEtat FROM  fichefrais INNER JOIN Etat on ficheFrais.idEtat = Etat.id WHERE fichefrais.idvisiteur ='" + idVisiteur + "' and fichefrais.mois = '" + mois + "'");
//			if (rs.next()) {
//				idVisiteur = rs.getString(1);
//				 = rs.getString(2);
//				leVisiteur = new Visiteur(id, nom);
//				lesVisiteurs.add(leVisiteur);
//			}
//			rs.close() ;   // Permet de libérer la mémoire utilisée.
//
//
//		} catch(Exception erreur) {
//			System.out.println(erreur);
//		}
//
//		try {
//			con.close();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		return lesVisiteurs;
//	}
//	
//	
//	public function getLesInfosFicheFrais($idVisiteur,$mois){
//		$req = "select ficheFrais.idEtat as idEtat, ficheFrais.dateModif as dateModif, ficheFrais.nbJustificatifs as nbJustificatifs, 
//			ficheFrais.montantValide as montantValide, etat.libelle as libEtat from  fichefrais inner join Etat on ficheFrais.idEtat = Etat.id 
//			where fichefrais.idvisiteur ='$idVisiteur' and fichefrais.mois = '$mois'";
//		$res = PdoGsb::$monPdo->query($req);
//		$laLigne = $res->fetch();
//		return $laLigne;
//	}
	
//	public static String dernierMoisSaisi(String idVisiteur) {
//		
//	}
//	
//	public function dernierMoisSaisi($idVisiteur){
//		$req = "select max(mois) as dernierMois from fichefrais where fichefrais.idvisiteur = '$idVisiteur'";
//		$res = PdoGsb::$monPdo->query($req);
//		$laLigne = $res->fetch();
//		$dernierMois = $laLigne['dernierMois'];
//		return $dernierMois;
//	}



}
