/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

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
public abstract class Carte implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1123L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/**
	 * 
	 */
	public Carte() {
		super();
	}

	/**
	 * @param id
	 */
	public Carte(int id) {
		super();
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carte [id=" + id + "]";
	}
	
	

}
