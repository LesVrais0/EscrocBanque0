/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Entity;
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
