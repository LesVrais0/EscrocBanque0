package fr.adaming.managedBean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Carte;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.CarteVisa;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@ManagedBean(name = "mBClient")
@SessionScoped
public class ManagedClient {

	private String[] carte ={"Carte"};

	private String[] compte={"Compte"};

	private CarteElectron cel;

	private CarteVisa cv;

	private CompteEpargne ce;

	private CompteCourant cc;

	private int idtempo;

	@ManagedProperty(value = "#{clService}")
	private IClientService clientService;
	
	@ManagedProperty(value="#{cService}")
	private IConseillerService conseillerService;

	/**
	 * 
	 */
	public ManagedClient() {
		super();
		this.cc = new CompteCourant();
		this.ce = new CompteEpargne();
		this.cv = new CarteVisa();
		this.cel = new CarteElectron();
	}


	/**
	 * @return the carte
	 */
	public String[] getCarte() {
		return carte;
	}


	/**
	 * @param carte the carte to set
	 */
	public void setCarte(String[] carte) {
		this.carte = carte;
	}


	/**
	 * @return the compte
	 */
	public String[] getCompte() {
		return compte;
	}


	/**
	 * @param compte the compte to set
	 */
	public void setCompte(String[] compte) {
		this.compte = compte;
	}


	/**
	 * @return the idtempo
	 */
	public int getIdtempo() {
		return idtempo;
	}


	/**
	 * @param idtempo the idtempo to set
	 */
	public void setIdtempo(int idtempo) {
		this.idtempo = idtempo;
	}


	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}


	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	

	/**
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}


	/**
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}


	public void ajouterCarte() {
		
		System.out.println("Type de carte"+carte[0]+"---------------------------------------------------------------------------------------------------------");
		Map<String, Carte> mapCarte = new HashMap<String, Carte>();
		if (carte[0].contains("Visa")) {
			mapCarte.put("CarteVisa", cv);
		} else if (carte[0].contains("Electron")) {
			mapCarte.put("CarteElectron", cel);
			System.out.println("care electron"+carte);
		}
		System.out.println("Type de compte"+compte[0]+"==========================================================================================================");
		Map<String, Compte> mapCompte = new HashMap<String, Compte>();
		if (compte[0].contains("Epargne")) {
			ce.setId(idtempo);
			mapCompte.put("CE", ce);
		} else if (compte[0].contains("Courant")) {
			cc.setId(idtempo);
			mapCompte.put("CC", cc);
		}


		System.out.println("AVANT METHODE DAO======================================================================");
		
		clientService.ajouterCarteService(mapCarte, mapCompte);

		System.out.println("ARPES METHODE DAO==============================================================================");
	}

}
