package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.GerantDaoImpl;
import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

public class GerantServiceImpl implements IGerantService {

	//@Autowired
	IGerantDao gerantDao = new GerantDaoImpl();

	@Override
	public Gerant getGerantService(Gerant gerant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterConseillerService(Conseiller conseiller, Gerant gerant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierConseillerService(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerConseillerService(Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}
	


}
