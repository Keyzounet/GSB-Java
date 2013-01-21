import java.util.ArrayList;


public class Comptable {
	private String idComptable;
	private String loginComptable ;
	private String mdpComptable ;
	private String nomComptable;
	private String prenomComptable;
	private ArrayList <Visiteur> lesVisiteurs;
	
	public Comptable (String unId, String unLogin, String unMdp, String unNom, String unPrenom, ArrayList <Visiteur> laListeVisiteurs ) {
		this.idComptable = unId;
		this.loginComptable = unLogin;
		this.mdpComptable = unMdp;
		this.nomComptable = unNom;
		this.prenomComptable = unPrenom;
		this.lesVisiteurs = laListeVisiteurs;
	} 
	public String getLoginComptable() {
		return loginComptable;
	}
	public String getMdpComptable() {
		return mdpComptable;
	}
	public ArrayList<Visiteur> getLesVisiteurs() {
		return lesVisiteurs;
	}
	public Comptable getComptable() {
		return this;
	}
	public String getIdComptable() {
		return this.idComptable;
	}

	public String getNomComptable() {
		return this.nomComptable;
	}

	public String getPrenomComptable() {
		return this.prenomComptable;
	}
}
