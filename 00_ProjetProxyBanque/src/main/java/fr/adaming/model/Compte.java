package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Compte implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 179L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private int solde;
	@Column
	private Date dateOuverture;
	/**
	 * 
	 */
	public Compte() {
		super();
	}
	
	/**
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(int solde, Date dateOuverture) {
		super();
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		
		
	}
	/**
	 * @param id
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(int id, int solde, Date dateOuverture) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
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
	 * @return the solde
	 */
	public int getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(int solde) {
		this.solde = solde;
	}
	/**
	 * @return the dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * @param dateOuverture the dateOuverture to set
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [id=" + id + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", getId()=" + getId()
				+ ", getSolde()=" + getSolde() + ", getDateOuverture()=" + getDateOuverture() + "]";
	}
	
	
	
	
	
}