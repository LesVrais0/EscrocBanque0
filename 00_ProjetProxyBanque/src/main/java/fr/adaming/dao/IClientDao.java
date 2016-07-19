package fr.adaming.dao;

import java.util.HashMap;
import java.util.Map;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

public interface IClientDao {
	
	public void ajouterCCDao(CompteCourant cc, Client client);
	
	public void ajouterCEDao(CompteEpargne ce, Client client);
	
	public void ajouterCarte(Map<String , Carte> mapCarte,Map<String , Compte> mapCompte);

}
