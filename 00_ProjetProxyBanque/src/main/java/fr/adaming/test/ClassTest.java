package fr.adaming.test;

import java.util.Date;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.ConseillerServiceImpl;
import fr.adaming.service.GerantServiceImpl;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IGerantService;

public class ClassTest {
	
	public static void main(String[] args){
		
//		String test ="1er";
//
//		HashMap<String, String> mapCarte = new HashMap<String, String>();
//		
//		mapCarte.put("CarteVisa",test);
//		System.out.println(mapCarte.get("CarteVisa"));
//		
//		test="2eme";
//		System.out.println(mapCarte.get("CarteVisa"));
		

		CompteCourant cc = new CompteCourant( 215.25);
		cc.setSolde(125);
		
		S s = new S();
		
		s.aff(cc);
		
		Date date= new Date();
		System.out.println(date);
		
	}

}
