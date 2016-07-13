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
@Entity(name="carteElectronEntity")
@Table(name="cartesElectron")
public class CarteElectron extends Carte{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 184185985595656L;
	
	@OneToOne
	@JoinColumn(name = "comptesCourantsCE", referencedColumnName = "id")
	private CompteCourant comptesCourants;
	
	@OneToOne
	@JoinColumn(name = "comptesEpargneCE", referencedColumnName = "id")
	private CompteEpargne comptesEpargnes;
	/**
	 * 
	 */
	public CarteElectron() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public CarteElectron(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	


	
}
