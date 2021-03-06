package fr.adaming.service;

import java.util.HashMap;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;

public interface IConseillerService {
	
	public String ajouterClientService(Client client, Conseiller conseiller);
	
	public String modifierClientService(Client client);
	
	public String supprimerClientService(Client client);
	
	public Client lireClientService(Client client);
	
	public List<Client> getAllClientsService (Conseiller conseiller);
	
	public void faireVirementService(Compte a,Compte b, double montant);
	
	public Conseiller getConseillerService(Conseiller conseiller);
	
	public Long verifConseilerService(Conseiller conseiller);
	
	public Client getClientById(Client client);
}
