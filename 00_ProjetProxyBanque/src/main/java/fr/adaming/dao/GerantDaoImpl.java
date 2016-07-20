package fr.adaming.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;


@Repository
@Transactional
public class GerantDaoImpl implements IGerantDao {
	
	// -----------------------SessionFactory------------------------------------
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ----------------------------------------------------------------------------

	@Override
	public Gerant getGerantDao(Gerant gerant) {
		Session session = sessionFactory.openSession();
		
		String sql = "FROM gerantEntity ge WHERE ge.nom = :nomp and ge.password = :passwordp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", gerant.getNom());
		requete.setParameter("passwordp", gerant.getPassword());

		Gerant cl = (Gerant) requete.uniqueResult();
		
		session.close();
		
		return cl;
	}

	@Override
	public void ajouterConseillerDao(Conseiller conseiller, Gerant gerant) {
		Session session = sessionFactory.openSession();
		
		String sql ="insert into conseillers (nom,prenom,telephone,password,gerant_id_fk) values (?,?,?,?,?)";
		
		Query requete = session.createSQLQuery(sql);
		
		requete.setParameter(0, conseiller.getNom());
		requete.setParameter(1, conseiller.getPrenom());
		requete.setParameter(2, conseiller.getTelephone());
		requete.setParameter(3, conseiller.getPassword());
		requete.setParameter(4, gerant.getId() );
		
		requete.executeUpdate();
		
		session.close();
		
	}

	@Override
	public void modifierConseillerDao(Conseiller conseiller) {
			Session session = sessionFactory.openSession();
		
		String sql ="update conseillerEntity ce set "
				+ "ce.nom = :nomp , "
				+ "ce.prenom = :prenomp , "
				+ "ce.telephone = :telephonep , "
				+ "ce.password = :passwordp where "
				+ "ce.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("nomp", conseiller.getNom());
		requete.setParameter("prenomp", conseiller.getPrenom());
		requete.setParameter("telephonep", conseiller.getTelephone());
		requete.setParameter("passwordp", conseiller.getPassword());
		requete.setParameter("idp", conseiller.getId());
		
		requete.executeUpdate();
		session.close();
		
	}

	@Override
	public void supprimerConseillerDao(Conseiller conseiller) {
		Session session = sessionFactory.openSession();

		String requete = "DELETE FROM conseillerEntity c where c.id= :idp";

		Query query = session.createQuery(requete);

		query.setParameter("idp", conseiller.getId());
		
		query.executeUpdate();
		
		session.close();
		
	}

	@Override
	public List<Conseiller> getAllConseiller(Gerant gerant) {
		Session session = sessionFactory.openSession();
		
		String sql = "FROM conseillerEntity ce where ce.gerants.id= :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", gerant.getId());
		
		List<Conseiller> liste = requete.list();
		
		session.close();
		
		return liste;
	}

	
	
	
	
	
	
	@Override
	public Long verifGerant(Gerant gerant) {
		
		Session session = sessionFactory.openSession();
		
		String sql1 ="SELECT COUNT (ce) FROM gerantEntity ce where ce.nom = :nomp and ce.password = :passwordp";
		
		Query requete1 =session.createQuery(sql1);
		
		requete1.setParameter("nomp", gerant.getNom());
		requete1.setParameter("passwordp", gerant.getPassword());
		
		Long i = (Long) requete1.uniqueResult();
		
		session.close();
		
		return i;
	}

	@Override
	public Conseiller getConseillerById(Conseiller conseiller) {
		Session session = sessionFactory.openSession();
		
		String sql = "FROM conseillerEntity ce WHERE ce.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", conseiller.getId());

		Conseiller cl = (Conseiller) requete.uniqueResult();
		
		session.close();
		
		return cl;
	}

}
