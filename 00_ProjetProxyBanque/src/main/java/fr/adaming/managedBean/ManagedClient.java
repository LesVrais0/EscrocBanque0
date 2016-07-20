package fr.adaming.managedBean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Carte;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.CarteVisa;
import fr.adaming.model.Client;
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

	private String[] carte = { "Carte" };

	private String[] compte = { "Compte" };

	private CarteElectron cel;

	private CarteVisa cv;

	private CompteEpargne ce;

	private CompteCourant cc;

	private String carteCC;

	private String carteCE;

	private Client client;

	private int idtempo;

	@ManagedProperty(value = "#{clService}")
	private IClientService clientService;

	@ManagedProperty(value = "#{cService}")
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
		this.client = new Client();
	}

	/**
	 * @return the carteCC
	 */
	public String getCarteCC() {
		return carteCC;
	}

	/**
	 * @param carteCC
	 *            the carteCC to set
	 */
	public void setCarteCC(String carteCC) {
		this.carteCC = carteCC;
	}

	/**
	 * @return the carteCE
	 */
	public String getCarteCE() {
		return carteCE;
	}

	/**
	 * @param carteCE
	 *            the carteCE to set
	 */
	public void setCarteCE(String carteCE) {
		this.carteCE = carteCE;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the carte
	 */
	public String[] getCarte() {
		return carte;
	}

	/**
	 * @param carte
	 *            the carte to set
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
	 * @return the cel
	 */
	public CarteElectron getCel() {
		return cel;
	}

	/**
	 * @param cel the cel to set
	 */
	public void setCel(CarteElectron cel) {
		this.cel = cel;
	}

	/**
	 * @return the cv
	 */
	public CarteVisa getCv() {
		return cv;
	}

	/**
	 * @param cv the cv to set
	 */
	public void setCv(CarteVisa cv) {
		this.cv = cv;
	}

	/**
	 * @return the ce
	 */
	public CompteEpargne getCe() {
		return ce;
	}

	/**
	 * @param ce the ce to set
	 */
	public void setCe(CompteEpargne ce) {
		this.ce = ce;
	}

	/**
	 * @return the cc
	 */
	public CompteCourant getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(CompteCourant cc) {
		this.cc = cc;
	}

	/**
	 * @param compte
	 *            the compte to set
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
	 * @param idtempo
	 *            the idtempo to set
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
	 * @param clientService
	 *            the clientService to set
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
	 * @param conseillerService
	 *            the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public String ajouterCarte() {

		System.out
				.println("Type de carte"
						+ carte[0]
						+ "---------------------------------------------------------------------------------------------------------");
		Map<String, Carte> mapCarte = new HashMap<String, Carte>();
		if (carte[0].contains("Visa")) {
			mapCarte.put("CarteVisa", cv);
		} else if (carte[0].contains("Electron")) {
			mapCarte.put("CarteElectron", cel);
			System.out.println("care electron" + carte);
		}
		System.out
				.println("Type de compte"
						+ compte[0]
						+ "==========================================================================================================");
		Map<String, Compte> mapCompte = new HashMap<String, Compte>();
		if (compte[0].contains("Epargne")) {
			ce.setId(idtempo);
			mapCompte.put("CE", ce);
		} else if (compte[0].contains("Courant")) {
			cc.setId(idtempo);
			mapCompte.put("CC", cc);
		}

		System.out
				.println("AVANT METHODE DAO======================================================================");

		clientService.ajouterCarteService(mapCarte, mapCompte);

		System.out
				.println("ARPES METHODE DAO==============================================================================");
		
		return "succes";
	}

	public void touteInfoClient() {

		System.out.println(clientService.verifClient(client));
		
		if(clientService.verifClient(client)==1){
			
		client = conseillerService.getClientById(client);

		if(client.getId()!=0){
			
		if (clientService.verifCCIdClient(client) == 1) {

			cc = clientService.getCCClient(client);

			carteCC = clientService.carteCompteCourant(cc);
		} else {
			cc = null;
		}

		if (clientService.verifCEIdClient(client) == 1) {

			ce = clientService.getCEClient(client);

			carteCE = clientService.carteCompteEpagne(ce);
		} else {
			ce = null;
		}
		}
		}
	}

}
