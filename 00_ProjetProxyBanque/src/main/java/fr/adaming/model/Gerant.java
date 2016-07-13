/**
 * 
 */
package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@Entity(name="gerantEntity")
@Table(name="gerants")
public class Gerant extends Conseiller{

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 12L;
	@Column
	private String agence;

	@OneToMany(mappedBy="gerants")
	private List<Conseiller> conseillers;
	/**
	 * 
	 */
	public Gerant() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param password
	 * @param agence
	 */
	public Gerant(String nom, String prenom, String telephone, String password, String agence) {
		super(nom, prenom, telephone, password);
		this.agence = agence;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param password
	 * @param agence
	 */
	public Gerant(int id, String nom, String prenom, String telephone, String password, String agence) {
		super(id, nom, prenom, telephone, password);
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