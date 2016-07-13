package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@Entity(name="clientEntity")
@Table(name="clients")
public class Client extends Personne{

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1795212547963852L;
	@Column
	private String adresse;
	@Column
	private int codePostal;
	@Column
	private String ville;
	/**
	 * 
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 */
	public Client(String nom, String prenom, String telephone, String adresse, int codePostal, String ville) {
		super(nom, prenom, telephone);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 */
	public Client(int id, String nom, String prenom, String telephone, String adresse, int codePostal, String ville) {
		super(id, nom, prenom, telephone);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
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
	
	
	
}