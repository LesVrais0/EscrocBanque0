package fr.adaming.model;

import javax.persistence.Transient;

public class Client extends Personne{

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1795212547963852L;
	private String adresse;
	private int codePostal;
	private String ville;
	/**
	 * 
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Client(int id, String nom, String prenom, String telephone) {
		super(id, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Client(String nom, String prenom, String telephone) {
		super(nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
}