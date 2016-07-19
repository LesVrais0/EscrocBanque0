package fr.adaming.dao;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;


public interface IGerantDao {

	public Gerant getGerantDao(Gerant gerant);
	
	public void ajouterConseillerDao(Conseiller Conseiller,Gerant gerant);
	
	public void modifierConseillerDao(Conseiller Conseiller);
	
	public void supprimerConseillerDao(Conseiller Conseiller);
	
}
