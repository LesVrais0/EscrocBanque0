package fr.adaming.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;

@Service("cService")
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	private IConseillerDao conseillerDao;
	
	@Override
	public String ajouterClientService(Client client, Conseiller conseiller) {
		
		conseillerDao.ajouterClientDao(client,conseiller);
		return "succes";
	}

	@Override
	public String modifierClientService(Client client) {
		
		conseillerDao.modifierClientDao(client);
		return "succes";
		
	}

	@Override
	public String supprimerClientService(Client client) {
		conseillerDao.supprimerClientDao(client);
		return "succes";
	}

	@Override
	public Client lireClientService(Client client) {
		
		return conseillerDao.lireClientDao(client);
	}

	@Override
	public List<Client> getAllClientsService(Conseiller conseiller) {

		return conseillerDao.getAllClientsDao(conseiller);
	}

	@Override
	public void faireVirementService(Compte a,Compte b, double montant) {
		conseillerDao.faireVirementDao(a, b, montant);
		
	}

	@Override
	public Conseiller getConseillerService(Conseiller conseiller) {
		
		return conseillerDao.getConseillerDao(conseiller);
		
	}

	@Override
	public Long verifConseilerService(Conseiller conseiller) {

		return conseillerDao.verifConseillerDao(conseiller);
	}

	@Override
	public Client getClientById(Client client) {
		return conseillerDao.getClientById(client);
	}
	
	

}
