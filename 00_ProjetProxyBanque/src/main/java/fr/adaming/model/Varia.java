package fr.adaming.model;

public class Varia {

private String chaine;
	
	private double rdm;

	/**
	 * @return the chaine
	 */
	public String getChaine() {
		return chaine;
	}

	/**
	 * @param chaine the chaine to set
	 */
	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	/**
	 * @return the rdm
	 */
	public double getRdm() {
		return rdm;
	}

	/**
	 * @param rdm the rdm to set
	 */
	public void setRdm(double rdm) {
		this.rdm = rdm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "webrest [chaine=" + chaine + ", rdm=" + rdm + "]";
	}
	
	
}
