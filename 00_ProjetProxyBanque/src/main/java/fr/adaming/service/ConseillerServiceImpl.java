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
	@Transactional
	public String ajouterClientService(Client client) {
		
		conseillerDao.ajouterClientDao(client);
		return "succes";
	}

	@Override
	@Transactional
	public String modifierClientService(Client client) {
		
		conseillerDao.modifierClientDao(client);
		return "succes";
		
	}

	@Override
	@Transactional
	public void supprimerClientService(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Client lireClientService(Client client) {
		
		return conseillerDao.lireClientDao(client);
	}

	@Override
	@Transactional
	public List<Client> getAllClientsService(Conseiller conseiller) {

		return conseillerDao.getAllClientsDao(conseiller);
	}

	@Override
	@Transactional
	public void faireVirementService(
			HashMap<String, ? extends Compte> mapCompte, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Conseiller getConseillerService(String nom, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
