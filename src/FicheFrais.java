import java.sql.Date;


public class FicheFrais {
	private String idVisiteur;
	private String mois;
	private int nbJustificatif;
	private float montantValide;
	private Date dateModif;
	private String idEtat;
	private String libelleEtat;
	
	public FicheFrais (String unId, String unMois, int unNbJustificatif, float unMontantValide,
			Date uneDate, String unIdEtat, String unLibelleEtat) {
		this.idVisiteur = unId;
		this.mois = unMois;
		this.nbJustificatif = unNbJustificatif;
		this.montantValide = unMontantValide;
		this.dateModif = uneDate;
		this.idEtat = unIdEtat;
		this.libelleEtat = unLibelleEtat;
	}

	
	public String getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getNbJustificatif() {
		return nbJustificatif;
	}

	public void setNbJustificatif(int nbJustificatif) {
		this.nbJustificatif = nbJustificatif;
	}

	public float getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(float montantValide) {
		this.montantValide = montantValide;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	public String getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	
	
	
}
