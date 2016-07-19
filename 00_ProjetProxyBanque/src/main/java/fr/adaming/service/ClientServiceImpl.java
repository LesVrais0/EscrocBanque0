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
		clientDao.ajouterCCDao(cc, client);
		
	}

	@Override
	public void ajouterCEService(CompteEpargne ce, Client client) {
		clientDao.ajouterCEDao(ce, client);
		
	}

	@Override
	public void ajouterCarteService(Map<String, Carte> mapCarte,
			Map<String, Compte> mapCompte) {
		
		clientDao.ajouterCarte(mapCarte, mapCompte);
		
	}

}
