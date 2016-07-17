package fr.adaming.service;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public interface IGerantService {
	
	public Gerant getGerantService(String nom, String password);
	
	public void ajouterConseillerService(Conseiller conseiller);
	
	public void modifierConseillerService(Conseiller conseiller);
	
	public void supprimerConseillerService(Conseiller conseiller);

}
