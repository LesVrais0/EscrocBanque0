package fr.adaming.dao;

import java.util.HashMap;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;


public interface IConseillerDao {
	
	public void ajouterClientDao(Client client, Conseiller conseiller);
	
	public void modifierClientDao(Client client);
	
	public void supprimerClientDao(Client client);
	
	public Client lireClientDao(Client client);
	
	public List<Client> getAllClientsDao (Conseiller conseiller);
	
	public void faireVirementDao(Compte a, Compte b, double montant);
	
	public Conseiller getConseillerDao(Conseiller conseiller);
	
	public Long verifConseillerDao(Conseiller conseiller);
	
	public Client getClientById(Client client);
	
	

}
