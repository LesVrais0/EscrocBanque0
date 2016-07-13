package fr.adaming.service;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public interface IGerantService {
	
	public Gerant getGerantService(String nom, String password);
	
	public void ajouterConseillerService(Conseiller Conseiller);
	
	public void modifierConseillerService(Conseiller Conseiller);
	
	public void supprimerConseillerService(Conseiller Conseiller);

}
