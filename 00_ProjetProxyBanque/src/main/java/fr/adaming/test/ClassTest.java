package fr.adaming.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.ConseillerServiceImpl;
import fr.adaming.service.GerantServiceImpl;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IGerantService;

public class ClassTest {
	
	public static void main(String[] args){
		
		IGerantService ge = new GerantServiceImpl();
		
		IConseillerService cs = new ConseillerServiceImpl();
		
		//Gerant ges = new Gerant("nom", "prenom", "telephone", "agence", "password");
		
		Conseiller css = new Conseiller("nom", "prenom", "telephone", "password");
		
		Client cl = new Client("nom", "prenom", "telephone", "adresse", 44100, "ville");
		
		ge.ajouterConseillerService(css);
		
		cs.ajouterClientService(cl);

		
		
	}

}
