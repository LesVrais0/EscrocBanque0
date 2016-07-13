package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public class GerantServiceImpl implements IGerantService {

	@Autowired
	IGerantDao gerantDao;
	
	@Override
	public Gerant getGerantService(String nom, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterConseillerService(Conseiller Conseiller) {
		gerantDao.ajouterConseillerDao(Conseiller);
	}

	@Override
	public void modifierConseillerService(Conseiller Conseiller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerConseillerService(Conseiller Conseiller) {
		// TODO Auto-generated method stub
		
	}

}
