package fr.adaming.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

@Transactional
@Repository
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
		
		String sql ="insert into agents (nom,prenom,telephone,password,gerant_id_fk) values (?,?,?,?,?)";
		
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
		
		String sql ="update conseillerEntity ce set"
				+ "ce.nom = :nomp , "
				+ "ce.prenom = :prenomp , "
				+ "ce.telephone = :telephonep , "
				+ "ce.password = :passwordp where"
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

		String requete = "DELETE FROM conseillers where id=?";

		Query query = session.createSQLQuery(requete);

		query.setParameter(0, conseiller.getId());

		session.close();
		
	}

	@Override
	public List<Conseiller> getAllConseiller(Gerant gerant) {
		// TODO Auto-generated method stub
		return null;
	}

}
