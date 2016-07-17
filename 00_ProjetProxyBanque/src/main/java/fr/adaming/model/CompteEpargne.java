/**
 * 
 */
package fr.adaming.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@Entity(name="compteEpargneEntity")
@Table(name="comptesEpargnes")
public class CompteEpargne extends Compte{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1894651328794561L;
	
	@OneToOne
	@JoinColumn(name = "comptesEpargne", referencedColumnName = "id")
	private Client clients;
	
	@OneToOne(mappedBy="comptesEpargnes", cascade = CascadeType.ALL)
	private CarteVisa cartesVisa;
	
	@OneToOne(mappedBy="comptesEpargnes", cascade = CascadeType.ALL)
	private CarteElectron cartesElectron;
	/**
	 * 
	 */
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(int solde, Date dateOuverture) {
		super(solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(int id, int solde, Date dateOuverture) {
		super(id, solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [getId()=" + getId() + ", getSolde()=" + getSolde() + ", getDateOuverture()="
				+ getDateOuverture() + "]";
	}
	
	

}
