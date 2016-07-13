/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@MappedSuperclass
public abstract class Personne implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 11235574L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String telephone;
	/**
	 * 
	 */
	public Personne() {
		super();
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Personne(String nom, String prenom, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public Personne(int id, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + "]";
	}

	
}