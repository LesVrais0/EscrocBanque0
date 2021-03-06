/**
 * 
 */
package fr.adaming.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	
	private int tauxRemuneration = 3;

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * @param tauxRemuneration
	 */
	public CompteEpargne(int tauxRemunerationneration) {
		super();
	}

	/**
	 * @return the tauxRemuneration
	 */
	public int gettauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * @param tauxRemu the tauxRemu to set
	 */
	public void settauxRemuneration(int tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + "]";
	}
	
	
}
