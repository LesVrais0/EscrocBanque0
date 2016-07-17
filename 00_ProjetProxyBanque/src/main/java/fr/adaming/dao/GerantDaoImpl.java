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
		// TODO Auto-generated method stub
			return null;
	}

	@Override
	public void ajouterConseillerDao(Conseiller conseiller) {
		
		System.out.println("dao gerant");
		Session session = sessionFactory.openSession();
		System.out.println("dao gerant2");
		session.save(conseiller);
		System.out.println("dao gerant3");
		session.close();
		
		
	}

	@Override
	public void modifierConseillerDao(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerConseillerDao(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}

}
