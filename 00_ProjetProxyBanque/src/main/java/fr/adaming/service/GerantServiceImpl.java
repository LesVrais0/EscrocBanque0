package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.GerantDaoImpl;
import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

@Service("gerantService")
public class GerantServiceImpl implements IGerantService {

	@Autowired
	IGerantDao gerantDao;

	@Override
	public Gerant getGerantService(Gerant gerant) {
		return gerantDao.getGerantDao(gerant);
	}

	@Override
	public void ajouterConseillerService(Conseiller conseiller, Gerant gerant) {
		gerantDao.ajouterConseillerDao(conseiller, gerant);
		
	}

	@Override
	public void modifierConseillerService(Conseiller conseiller) {
		gerantDao.modifierConseillerDao(conseiller);
		
	}

	@Override
	public void supprimerConseillerService(Conseiller conseiller) {
		gerantDao.supprimerConseillerDao(conseiller);
		
	}

	@Override
	public List<Conseiller> getAllConseiller(Gerant gerant) {
		
		return gerantDao.getAllConseiller(gerant);
	}

	@Override
	public Long verifGerant(Gerant gerant) {
		
		return gerantDao.verifGerant(gerant);
	}
	


}
