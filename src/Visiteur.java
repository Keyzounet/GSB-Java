import java.sql.Date;
import java.util.ArrayList;


public class Visiteur {
	
	private String idVisiteur;
	private String nomVisiteur;
	private String prenomVisiteur;
	private String adresseVisiteur;
	private String cpVisiteur;
	private String villeVisiteur;
	private Date dateEmbauche;
	private ArrayList <FicheFrais> lesFichesFrais;
	
	public Visiteur (String unId, String unNom, String unPrenom, String uneAdresse, String unCp, String uneVille, Date uneDate) {
		this.idVisiteur = unId;
		this.nomVisiteur = unNom;
		this.prenomVisiteur = unPrenom;
		this.adresseVisiteur = uneAdresse;
		this.cpVisiteur = unCp;
		this.villeVisiteur = uneVille;
		this.dateEmbauche = uneDate;
		this.lesFichesFrais = new ArrayList <FicheFrais>();
	}
	
	public Visiteur (String unId, String unNom) {
		this.idVisiteur = unId;
		this.nomVisiteur = unNom;
	}	
		
	public String getIdVisiteur() {
		return idVisiteur;
	}

	public String getNomVisiteur() {
		return nomVisiteur;
	}

	public String getPrenomVisiteur() {
		return prenomVisiteur;
	}

	public String getAdresseVisiteur() {
		return adresseVisiteur;
	}

	public String getCpVisiteur() {
		return cpVisiteur;
	}

	public String getVilleVisiteur() {
		return villeVisiteur;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public ArrayList<FicheFrais> getLesFichesFrais() {
		return lesFichesFrais;
	}
		
	
	
}
