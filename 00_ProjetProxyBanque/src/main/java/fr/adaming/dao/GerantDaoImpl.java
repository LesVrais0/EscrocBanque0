package fr.adaming.dao;



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
	public Gerant getGerantDao(String nom, String password) {

	}

	@Override
	public void ajouterConseillerDao(Conseiller conseiller) {
		Session session = sessionFactory.openSession();
		session.save(conseiller);
		session.close();
		
		
	}

	@Override
	public void modifierConseillerDao(Conseiller Conseiller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerConseillerDao(Conseiller Conseiller) {
		// TODO Auto-generated method stub
		
	}

}
