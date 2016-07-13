/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
public class Conseiller extends Client {

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 199658589657L;

	/**
	 * 
	 */
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Conseiller(int id, String nom, String prenom, String telephone) {
		super(id, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Conseiller(String nom, String prenom, String telephone) {
		super(nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller [getAdresse()=" + getAdresse() + ", getCodePostal()=" + getCodePostal() + ", getVille()="
				+ getVille() + ", toString()=" + super.toString() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getTelephone()=" + getTelephone() + "]";
	}

	
}
