package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public interface IGerantService {
	
	public Gerant getGerantService(Gerant gerant);
	
	public void ajouterConseillerService(Conseiller conseiller, Gerant gerant);
	
	public void modifierConseillerService(Conseiller conseiller);
	
	public void supprimerConseillerService(Conseiller conseiller);
	
	public List<Conseiller> getAllConseiller(Gerant gerant);
	
	public Long verifGerant(Gerant gerant);
	
	public Conseiller getConseillerById(Conseiller conseiller);

}
