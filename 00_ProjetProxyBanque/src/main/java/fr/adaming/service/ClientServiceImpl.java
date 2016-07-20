package fr.adaming.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

@Service("clService")
public class ClientServiceImpl implements IClientService{

	@Autowired
	private IClientDao clientDao;
	
	
	
	/**
	 * @return the clientDao
	 */
	public IClientDao getClientDao() {
		return clientDao;
	}

	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void ajouterCCService(CompteCourant cc, Client client) {
		
		if(clientDao.verifCCIdClient(client)==0){
		clientDao.ajouterCCDao(cc, client);}
		
	}

	@Override
	public void ajouterCEService(CompteEpargne ce, Client client) {
		if(clientDao.verifCEIdClient(client)==0){
		clientDao.ajouterCEDao(ce, client);}
		
	}

	@Override
	public void ajouterCarteService(Map<String, Carte> mapCarte,
			Map<String, Compte> mapCompte) {
		
		clientDao.ajouterCarte(mapCarte, mapCompte);
		
	}

	@Override
	public Long verifCCIdClient(Client client) {
		
		return clientDao.verifCCIdClient(client);
	}

	@Override
	public Long verifCEIdClient(Client client) {
		
		return clientDao.verifCEIdClient(client);
	}

	@Override
	public CompteCourant getCCClient(Client client) {
		
		return clientDao.getCCClient(client);
	}

	@Override
	public CompteEpargne getCEClient(Client client) {
		
		return clientDao.getCEClient(client);
	}

	@Override
	public String carteCompteCourant(CompteCourant cc) {
		
		return clientDao.carteCompteCourant(cc);
	}

	@Override
	public String carteCompteEpagne(CompteEpargne ce) {
		
		return clientDao.carteCompteEpagne(ce);
	}

}
