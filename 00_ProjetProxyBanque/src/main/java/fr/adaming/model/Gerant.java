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
@Entity(name = "gerantEntity")
@Table(name = "gerants")
public class Gerant extends Personne {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 12L;
	@Column
	private String agence;
	@Column
	private String password;

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
	 * @param agence
	 * @param password
	 */
	public Gerant(String nom, String prenom, String telephone, String agence, String password) {
		super(nom, prenom, telephone);
		this.agence = agence;
		this.password = password;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param agence
	 * @param password
	 */
	public Gerant(int id, String nom, String prenom, String telephone, String agence, String password) {
		super(id, nom, prenom, telephone);
		this.agence = agence;
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gerant [agence=" + agence + ", password=" + password + ", conseillers=" + conseillers + "]";
	}
	
}