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
@Entity(name="compteCourantEntity")
@Table(name="comptesCourants")
public class CompteCourant extends Compte{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 185255363L;
	
	@OneToOne
	@JoinColumn(name = "comptesCourantsClients", referencedColumnName = "id")
	private Client clients;
	
	@OneToOne(mappedBy="CompteCourantCarteVisa", cascade = CascadeType.ALL)
	private CarteVisa cartesVisa;
	
	@OneToOne(mappedBy="CompteCourantCarteElectron", cascade = CascadeType.ALL)
	private CarteElectron cartesElectron;
	
	/**
	 * 
	 */
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteCourant(int solde, Date dateOuverture) {
		super(solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteCourant(int id, int solde, Date dateOuverture) {
		super(id, solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteCourant [getId()=" + getId() + ", getSolde()=" + getSolde() + ", getDateOuverture()="
				+ getDateOuverture() + "]";
	}


}
