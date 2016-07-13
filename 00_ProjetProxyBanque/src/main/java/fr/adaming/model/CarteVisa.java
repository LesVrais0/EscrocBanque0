/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author INTI-0288
 *
 */
@Entity(name="carteVisaEntity")
@Table(name="cartesVisa")
public class CarteVisa extends Carte{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 18945613254897L;
	
	@OneToOne
	@JoinColumn(name = "comptesCourantsCV", referencedColumnName = "id")
	private CompteCourant comptesCourants;
	
	@OneToOne
	@JoinColumn(name = "comptesEpargneCV", referencedColumnName = "id")
	private CompteEpargne comptesEpargnes;
	/**
	 * 
	 */
	public CarteVisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public CarteVisa(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	
}
