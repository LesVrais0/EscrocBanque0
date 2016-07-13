package fr.adaming.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;

public class ConseillerDaoImpl implements IConseillerDao {

	// -----------------------Session
	// Factory------------------------------------
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ----------------------------------------------------------------------------

	@Override
	@Transactional
	public void ajouterClientDao(Client client) {
		Session session = sessionFactory.openSession();
		
		session.save(client);
		
		session.close();

	}

	@Override
	@Transactional
	public void modifierClientDao(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void supprimerClientDao(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Client lireClientDao(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Client> getAllClientsDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void faireVirementDao(HashMap<String, ? extends Compte> mapCompte,
			double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Conseiller getConseillerDao(String nom, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
