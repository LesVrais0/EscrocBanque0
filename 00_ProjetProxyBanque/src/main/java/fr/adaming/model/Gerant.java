/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
public class Gerant extends Client{

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 12L;
	
	private String agence;

	/**
	 * @param agence
	 */
	public Gerant() {
		super();
		
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param agence
	 */
	public Gerant(String nom, String prenom, String telephone, String agence) {
		super(nom, prenom, telephone);
		this.agence = agence;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param agence
	 */
	public Gerant(int id, String nom, String prenom, String telephone, String agence) {
		super(id, nom, prenom, telephone);
		this.agence = agence;
	}

	/**
	 * @return the agence
	 */
	public String getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(String agence) {
		this.agence = agence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gerant [agence=" + agence + "]";
	}
	
	
	

	

}