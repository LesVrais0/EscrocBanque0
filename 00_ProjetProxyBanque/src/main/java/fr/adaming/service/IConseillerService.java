package fr.adaming.service;

import java.util.HashMap;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;

public interface IConseillerService {
	
	public String ajouterClientService(Client client);
	
	public void modifierClientService(Client client);
	
	public void supprimerClientService(Client client);
	
	public Client lireClientService(Client client);
	
	public List<Client> getAllClientsService ();
	
	public void faireVirementService(HashMap<String , ? extends Compte> mapCompte, double montant);
	
	public Conseiller getConseillerService(String nom, String password);
}
