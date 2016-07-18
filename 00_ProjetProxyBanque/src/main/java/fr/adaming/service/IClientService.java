package fr.adaming.service;

import java.util.HashMap;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

public interface IClientService {

	public void ajouterCCService(CompteCourant cc, Client client);
	
	public void ajouterCEService(CompteEpargne ce, Client client);
	
	public void ajouterCarteService(HashMap<String , ? extends Carte> mapCarte,HashMap<String , ? extends Compte> mapCompte);

	
}
