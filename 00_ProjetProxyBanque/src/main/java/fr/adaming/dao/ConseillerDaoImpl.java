package fr.adaming.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao {

	// -----------------------SessionFactory------------------------------------
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
		
		String sql ="insert into clients (nom, prenom, telephone, adresse, codePostal, ville) values (?, ?, ?, ?, ?, ?)";
		
		Query requete= session.createSQLQuery(sql);
		
		requete.setParameter(0, client.getNom());
		requete.setParameter(1, client.getPrenom());
		requete.setParameter(2, client.getTelephone());
		requete.setParameter(3, client.getAdresse());
		requete.setParameter(4, client.getCodePostal());
		requete.setParameter(5, client.getVille());
		
		int i = requete.executeUpdate();
		System.out.println("Valeur de i = "+i);
		System.out.println("Le client qu'on essaie de creer");
		System.out.println(client);
		System.out.println("Fin");
		session.close();

	}

	@Override
	@Transactional
	public void modifierClientDao(Client client) {
		
		Session session = sessionFactory.openSession();
		
		String sql = " update clientEntity ce set "
				+ "ce.nom = :nomp , "
				+ "ce.prenom = :prenomp , "
				+ "ce.telephone = :telephonep , "
				+ "ce.adresse = :adressep ,"
				+ "ce.codePostal = :codePostalp , "
				+ "ce.ville = :villep where "
				+ "ce.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", client.getNom());
		requete.setParameter("prenomp", client.getPrenom());
		requete.setParameter("telephonep", client.getTelephone());
		requete.setParameter("adressep", client.getAdresse());
		requete.setParameter("codePostalp", client.getCodePostal());
		requete.setParameter("villep", client.getVille());
		requete.setParameter("idp", client.getId());
		

		int i = requete.executeUpdate();
		System.out.println("Valeur de i = "+i);
		System.out.println("Le client qu'on essaie de modifier");
		System.out.println(client);
		System.out.println("Fin");
		session.close();
	}

	@Override
	@Transactional
	public void supprimerClientDao(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Client lireClientDao(Client client) {
		
		Session session = sessionFactory.openSession();
		
		String sql ="FROM clientEntity ce where ce.nom = :nomp , ce.prenom = :prenomp , ce.ville = :villep";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", client.getNom());
		requete.setParameter("prenomp", client.getPrenom());
		requete.setParameter("villep", client.getVille());
		
		Client cl = (Client) requete.uniqueResult();
		
		return cl;
	}

	@Override
	@Transactional
	public List<Client> getAllClientsDao(Conseiller conseiller) {
		
		Session session = sessionFactory.openSession();
		
		String sql = "FROM clientEntity ce where ce.conseiller_id_fk = :idconseillerp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idconseillerp", conseiller.getId());
		
		List<Client> liste = requete.list();
		
		return liste;
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
