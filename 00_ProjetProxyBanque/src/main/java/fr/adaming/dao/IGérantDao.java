package fr.adaming.dao;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;


public interface IGérantDao {

	public Gerant getGerantDao(String nom, String password);
	
	public void ajouterConseillerDao(Conseiller Conseiller);
	
	public void modifierConseillerDao(Conseiller Conseiller);
	
	public void supprimerConseillerDao(Conseiller Conseiller);
	
}
