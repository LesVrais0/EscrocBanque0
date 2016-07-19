package fr.adaming.service;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public interface IGerantService {
	
	public Gerant getGerantService(Gerant gerant);
	
	public void ajouterConseillerService(Conseiller conseiller, Gerant gerant);
	
	public void modifierConseillerService(Conseiller conseiller);
	
	public void supprimerConseillerService(Conseiller conseiller);

}
