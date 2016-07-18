package fr.adaming.dao;

import java.util.HashMap;

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
public class ClientDaoImpl implements IClientDao{


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
		
		String sql = "insert into comptesEpargnes (dateOuverture,solde,comptesEpargne,tauxRemuneration) values(?,?,?)";
		
		Query requete = session.createSQLQuery(sql);
		
		requete.setParameter(0, ce.getDateOuverture());
		requete.setParameter(1, ce.getSolde());
		requete.setParameter(2, client.getId());
		requete.setParameter(3, ce.gettauxRemuneration());
		
		requete.executeUpdate();
		
		session.close();
		}

	@Override
	public void ajouterCarte(HashMap<String, ? extends Carte> mapCarte, HashMap<String, ? extends Compte> mapCompte) {
		
		Session session = sessionFactory.openSession();
		
		if(!mapCarte.get("CarteVisa").equals(null)){
			
			if(!mapCompte.get("CC").equals(null)){
				
				String sql = "insert into cartesvisa (comptesCourantCV) values (?)";
				
				Query requete = session.createSQLQuery(sql);
				
				requete.setParameter(0, mapCompte.get("CC").getId());
				
				requete.executeUpdate();
				
			}else if (!mapCompte.get("CE").equals(null)) {
				
				String sql = "insert into cartesvisa (comptesEpargneCV) values (?)";
				
				Query requete = session.createSQLQuery(sql);
				
				requete.setParameter(0, mapCompte.get("CE").getId());
				
				requete.executeUpdate();
			}
			
		}else if (!mapCarte.get("CarteElectron").equals(null)) {
			
			if(!mapCompte.get("CC").equals(null)){
				
				String sql = "insert into carteselectron (comptesCourantCV) values (?)";
				
				Query requete = session.createSQLQuery(sql);
				
				requete.setParameter(0, mapCompte.get("CC").getId());
				
				requete.executeUpdate();
				
			}else if (!mapCompte.get("CE").equals(null)) {
				
				String sql = "insert into carteselectron (comptesEpargneCV) values (?)";
				
				Query requete = session.createSQLQuery(sql);
				
				requete.setParameter(0, mapCompte.get("CE").getId());
				
				requete.executeUpdate();
				
			}
			
		}else{
			System.out.println("On n'ajoute pas de carte");
		}
	
	}



	

}
