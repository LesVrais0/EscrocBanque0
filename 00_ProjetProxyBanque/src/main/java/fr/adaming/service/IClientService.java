package fr.adaming.service;

import java.util.HashMap;
import java.util.Map;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

public interface IClientService {

	public void ajouterCCService(CompteCourant cc, Client client);
	
	public void ajouterCEService(CompteEpargne ce, Client client);
	
	public void ajouterCarteService(Map<String , Carte> mapCarte,Map<String , Compte> mapCompte);

	public Long verifCCIdClient(Client client);
	
	public Long verifCEIdClient(Client client);
	
	public CompteCourant getCCClient (Client client);
	
	public CompteEpargne getCEClient (Client client);
	
	public String carteCompteCourant(CompteCourant cc);
	
	public String carteCompteEpagne(CompteEpargne ce);

	
}
