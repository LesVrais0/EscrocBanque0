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
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
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
	public void ajouterClientDao(Client client, Conseiller conseiller) {
		Session session = sessionFactory.openSession();
		
		String sql ="insert into clients (nom, prenom, telephone, adresse, codePostal, ville,conseiller_id_fk) values (?, ?, ?, ?, ?, ?,?)";
		
		Query requete= session.createSQLQuery(sql);
		
		requete.setParameter(0, client.getNom());
		requete.setParameter(1, client.getPrenom());
		requete.setParameter(2, client.getTelephone());
		requete.setParameter(3, client.getAdresse());
		requete.setParameter(4, client.getCodePostal());
		requete.setParameter(5, client.getVille());
		requete.setParameter(6, conseiller.getId());
		
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
		Session session = sessionFactory.openSession();

		String requete = "DELETE FROM clients where id=?";

		Query query = session.createSQLQuery(requete);

		query.setParameter(0, client.getId());

		session.close();
	}

	@Override
	@Transactional
	public Client lireClientDao(Client client) {
		
		Session session = sessionFactory.openSession();
		
		String sql ="FROM clientEntity ce where ce.nom = :nomp and ce.prenom = :prenomp and ce.ville = :villep";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", client.getNom());
		requete.setParameter("prenomp", client.getPrenom());
		requete.setParameter("villep", client.getVille());
		
		Client cl = (Client) requete.uniqueResult();
		
		session.close();
		
		return cl;
	}

	@Override
	@Transactional
	public List<Client> getAllClientsDao(Conseiller conseiller) {
		
		Session session = sessionFactory.openSession();
		
		String sql = "FROM clientEntity ce where ce.conseillers.id = :idp ";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", conseiller.getId());
		
		List<Client> liste = requete.list();
		
		session.close();
		
		return liste;
	}

	@Override
	@Transactional
	public void faireVirementDao(Compte a, Compte b, double montant) {
		System.out.println(a.getId()+b.getId());
		Session session = sessionFactory.openSession();
		String sql, sql1;
		Double a1 ,b1;
		
		if(a.getClass().toString().contains("CompteCourant")){
			
			Query reqsoldea1 = session.createQuery("FROM compteCourantEntity c where c.id = :idp");
			reqsoldea1.setParameter("idp", a.getId());
			
			CompteCourant cc1 = (CompteCourant) reqsoldea1.uniqueResult();
			a1 = cc1.getSolde() - montant;
			
			sql="update compteCourantEntity c set c.solde = :soldepa where c.id= :idpa";
				
		}else{
			
			Query reqsoldea2 = session.createQuery("FROM compteEpargneEntity c where c.id = :idp");
			reqsoldea2.setParameter("idp", a.getId());
			
			CompteEpargne cc1 = (CompteEpargne) reqsoldea2.uniqueResult();
			a1 = cc1.getSolde() - montant;
			
			sql="update compteEpargneEntity c set c.solde = :soldepa where c.id= :idpa";
		}
			
		if(b.getClass().toString().contains("CompteCourant")){
			
			Query reqsoldea3 = session.createQuery("FROM compteCourantEntity c where c.id = :idp");
			reqsoldea3.setParameter("idp", b.getId());
			
			CompteCourant cc2 = (CompteCourant) reqsoldea3.uniqueResult();
			System.out.println(cc2);
			b1 = cc2.getSolde() - montant;
		
			
			sql1="update compteCourantEntity c set c.solde = :soldepb where c.id= :idpb";
				
		}else{
			
			Query reqsoldea4 = session.createQuery("FROM compteEpargneEntity c where c.id = :idp");
			reqsoldea4.setParameter("idp", b.getId());
			
			CompteEpargne cc2 = (CompteEpargne) reqsoldea4.uniqueResult();
			b1 = cc2.getSolde() - montant;
			
			sql1="update compteEpargneEntity c set c.solde = :soldepb where c.id= :idpb";
		}
		
		
		Query req = session.createQuery(sql);
		req.setDouble("soldepa",a1);
		req.setParameter("idpa", a.getId());
		
		Query req1 = session.createQuery(sql1);
		req1.setDouble("soldepb",b1);
		req1.setParameter("idpb", b.getId());
		
		req.executeUpdate();
		req1.executeUpdate();

	}

	@Override
	@Transactional
	public Conseiller getConseillerDao(Conseiller conseiller) {
		
		Session session = sessionFactory.openSession();
		
		String sql = "FROM conseillerEntity ce WHERE ce.nom = :nomp and ce.password = :passwordp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", conseiller.getNom());
		requete.setParameter("passwordp", conseiller.getPassword());

		Conseiller cl = (Conseiller) requete.uniqueResult();
		
		session.close();
		
		return cl;
		
		
		
		
	}

	@Override
	public Long verifConseillerDao(Conseiller conseiller) {
		
		Session session = sessionFactory.openSession();
		
		String sql1 ="SELECT COUNT (ce) FROM conseillerEntity ce where ce.nom = :nomp and ce.password = :passwordp";
		
		Query requete1 =session.createQuery(sql1);
		
		requete1.setParameter("nomp", conseiller.getNom());
		requete1.setParameter("passwordp", conseiller.getPassword());
		
		Long i = (Long) requete1.uniqueResult();
		
		session.close();
		
		return i;
	}

}
