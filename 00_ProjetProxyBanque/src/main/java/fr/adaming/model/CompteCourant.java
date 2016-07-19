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
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "comptesCourantsClients", referencedColumnName = "id")
	private Client clients;
	
	@OneToOne(mappedBy="comptesCourants", cascade = CascadeType.ALL)
	private CarteVisa cartesVisa;
	
	@OneToOne(mappedBy="comptesCourants", cascade = CascadeType.ALL)
	private CarteElectron cartesElectron;
	
	private Double decouvertAutorisé = 1000.00;

	/**
	 * 
	 */
	public CompteCourant() {
		super();
	}
	

	/**
	 * @param decouvertAutorisé
	 */
	public CompteCourant(Double decouvertAutorisé) {
		super();
		this.decouvertAutorisé = decouvertAutorisé;
	}

	/**
	 * @return the decouvertAutorisé
	 */
	public Double getDecouvertAutorisé() {
		return decouvertAutorisé;
	}

	/**
	 * @param decouvertAutorisé the decouvertAutorisé to set
	 */
	public void setDecouvertAutorisé(Double decouvertAutorisé) {
		this.decouvertAutorisé = decouvertAutorisé;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteCourant [decouvertAutorisé=" + decouvertAutorisé + "]";
	}
	
	

}
