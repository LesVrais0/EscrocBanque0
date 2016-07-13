/**
 * 
 */
package fr.adaming.model;

/**
 * @author INTI-0288
 *
 */
public class Agence {

	private int id;
	private String ville;
	private String dateOuverture;
	/**
	 * 
	 */
	public Agence() {
		super();
	}
	/**
	 * @param ville
	 * @param dateOuverture
	 */
	public Agence(String ville, String dateOuverture) {
		super();
		this.ville = ville;
		this.dateOuverture = dateOuverture;
	}
	/**
	 * @param id
	 * @param ville
	 * @param dateOuverture
	 */
	public Agence(int id, String ville, String dateOuverture) {
		super();
		this.id = id;
		this.ville = ville;
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
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the dateOuverture
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * @param dateOuverture the dateOuverture to set
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence [id=" + id + ", ville=" + ville + ", dateOuverture=" + dateOuverture + "]";
	}
	
	
	
}
