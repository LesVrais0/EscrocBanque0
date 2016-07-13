/**
 * 
 */
package fr.adaming.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@Entity(name = "conseillerEntity")
@Table(name = "conseillers")
public class Conseiller extends Personne {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 199658589657L;
	@Column
	private String password;

	@ManyToOne()
	@JoinColumn(name = "gerant_id_fk", referencedColumnName = "id")
	private Gerant gerants;

	@OneToMany(mappedBy = "conseillers")
	private List<Client> clients;

	/**
	 * 
	 */
	public Conseiller() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param password
	 */
	public Conseiller(String nom, String prenom, String telephone, String password) {
		super(nom, prenom, telephone);
		this.password = password;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param password
	 */
	public Conseiller(int id, String nom, String prenom, String telephone, String password) {
		super(id, nom, prenom, telephone);
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller [password=" + password + "]";
	}

}
