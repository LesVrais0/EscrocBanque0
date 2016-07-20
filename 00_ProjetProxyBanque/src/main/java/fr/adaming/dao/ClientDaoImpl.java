package fr.adaming.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Carte;
import fr.adaming.model.CarteVisa;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

@Repository
@Transactional
public class ClientDaoImpl implements IClientDao {

	// -----------------------SessionFactory------------------------------------
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ----------------------------------------------------------------------------

	@Override
	public void ajouterCCDao(CompteCourant cc, Client client) {

		Session session = sessionFactory.openSession();

		String sql = "insert into comptesCourants (dateOuverture,solde,comptesCourantsClients,decouvertAutorisé) values(?,?,?,?)";

		Query requete = session.createSQLQuery(sql);

		requete.setParameter(0, cc.getDateOuverture());
		requete.setParameter(1, cc.getSolde());
		requete.setParameter(2, client.getId());
		requete.setParameter(3, cc.getDecouvertAutorisé());
		requete.executeUpdate();

		session.close();
	}

	@Override
	public void ajouterCEDao(CompteEpargne ce, Client client) {

		Session session = sessionFactory.openSession();

		String sql = "insert into comptesEpargnes (dateOuverture,solde,comptesEpargne,tauxRemuneration) values(?,?,?,?)";

		Query requete = session.createSQLQuery(sql);

		requete.setParameter(0, ce.getDateOuverture());
		requete.setParameter(1, ce.getSolde());
		requete.setParameter(2, client.getId());
		requete.setParameter(3, ce.gettauxRemuneration());

		requete.executeUpdate();

		session.close();
	}

	public Long verifCCIdClient(Client client){
		
		Session session = sessionFactory.openSession();
		
		String sql = "SELECT COUNT (ce) FROM compteCourantEntity ce where ce.clients.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", client.getId());

		Long i = (Long) requete.uniqueResult();
		
		session.close();
		
		return i;
	
	}
	
	public Long verifCEIdClient(Client client){
		
		Session session = sessionFactory.openSession();
		
		String sql = "SELECT COUNT (ce) FROM compteEpargneEntity ce where ce.clients.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", client.getId());

		Long i = (Long) requete.uniqueResult();
		
		session.close();
		
		return i ;

	}
	
	public CompteCourant getCCClient (Client client){
		
		Session session = sessionFactory.openSession();
		
		String sql = "FROM compteCourantEntity ce WHERE ce.clients.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", client.getId());

		CompteCourant cc = (CompteCourant) requete.uniqueResult();
		
		session.close();
		
		return cc;
		
	}
	
	public CompteEpargne getCEClient (Client client){
		
		Session session = sessionFactory.openSession();
		
		String sql = "FROM compteEpargneEntity ce WHERE ce.clients.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", client.getId());

		CompteEpargne ce = (CompteEpargne) requete.uniqueResult();
		
		session.close();
		
		return ce;
		
	}
	
	public String carteCompteCourant(CompteCourant cc){
		Session session = sessionFactory.openSession();
		
		String sql ="SELECT COUNT (cel) FROM carteElectronEntity cel where cel.comptesCourants.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", cc.getId());

		Long i = (Long) requete.uniqueResult();
		
		if(i==1){
			return "carteElectron";
		}else{
			
			String sql1 ="SELECT COUNT (cv) FROM carteVisaEntity cv where cv.comptesEpargnes.id = :idp";
			
			Query requete1 = session.createQuery(sql1);
			
			requete1.setParameter("idp", cc.getId());

			Long t = (Long) requete1.uniqueResult();
			
			if(t==1){
				return "carteVisa";
			}			
		}
		session.close();
		return "null";
	}
	
	public String carteCompteEpagne(CompteEpargne ce){
		Session session = sessionFactory.openSession();
		
		String sql ="SELECT COUNT (cel) FROM carteElectronEntity cel where cel.comptesEpargnes.id = :idp";
		
		Query requete = session.createQuery(sql);
		
		requete.setParameter("idp", ce.getId());

		Long i = (Long) requete.uniqueResult();
		
		if(i==1){
			return "carteElectron";
		}else{
			
			String sql1 ="SELECT COUNT (cv) FROM carteVisaEntity cv where cv.comptesEpargnes.id = :idp";
			
			Query requete1 = session.createQuery(sql);
			
			requete1.setParameter("idp", ce.getId());

			Long t = (Long) requete1.uniqueResult();
			
			if(t==1){
				return "carteVisa";
			}			
		}
		session.close();
		return "null";
	}
	
	public Long verifClient(Client client){
		
		Session session = sessionFactory.openSession();
		
		String sql1 ="SELECT COUNT (cv) FROM clientEntity cv where cv.id = :idp";
		
		Query requete1 = session.createQuery(sql1);
		
		requete1.setParameter("idp", client.getId());

		Long t = (Long) requete1.uniqueResult();
		return t;
	}
	
	
	@Override
	public void ajouterCarte(Map<String, Carte> mapCarte,
			Map<String, Compte> mapCompte) {

		Session session = sessionFactory.openSession();

		System.out.println("avant la methode");

		for (String st : mapCarte.keySet()) {
			if (st.equals("CarteVisa")) {

				for (String st1 : mapCompte.keySet()) {
					if (st1.equals("CC")) {
						System.out.println("CC+VISA");
						String sql = "insert into cartesvisa (comptesCourantsCV) values (?)";

						Query requete = session.createSQLQuery(sql);

						requete.setParameter(0, mapCompte.get("CC").getId());

						requete.executeUpdate();

					} else if (st1.equals("CE")) {
						// CE + VISA
						String sql = "insert into cartesvisa (comptesEpargneCV) values (?)";

						Query requete = session.createSQLQuery(sql);

						requete.setParameter(0, mapCompte.get("CE").getId());

						requete.executeUpdate();

					}
				}

			} else if (st.equals("CarteElectron")) {
				for (String st1 : mapCompte.keySet()) {
					if (st1.equals("CC")) {
						// CC+Electron
						String sql = "insert into carteselectron (comptesCourantsCE) values (?)";

						Query requete = session.createSQLQuery(sql);

						requete.setParameter(0, mapCompte.get("CC").getId());

						requete.executeUpdate();

					} else if (st1.equals("CE")) {
						// CE+Electron
						String sql = "insert into carteselectrons (comptesEpargneCE) values (?)";

						Query requete = session.createSQLQuery(sql);

						requete.setParameter(0, mapCompte.get("CE").getId());

						requete.executeUpdate();

					}
				}
			}
		}
	}
}
