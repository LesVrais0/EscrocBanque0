package fr.adaming.managedBean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Carte;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.CarteVisa;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@ManagedBean(name = "mBConseiller")
@SessionScoped
public class ManagedConseiller {

	private Compte cd;
	private Compte ca;
	
	
	private Conseiller conseiller;

	private Client client;

	private List<Client> listeClient;

	private CompteCourant cc;

	private CompteEpargne ce;

	private int iddp;
	
	private int idar;
	
	private Double montant;

	private String type[]={"1"};

	private String type2[]={"1"};
	
	private CarteVisa cv;

	private CarteElectron cel;

	@ManagedProperty(value = "#{clService}")
	private IClientService clientService;

	@ManagedProperty(value = "#{cService}")
	private IConseillerService conseillerService;

	// ---------------------------------Getter Setter
	// Constructeur----------------------------------------------------------------Start

	/**
	 * 
	 */
	public ManagedConseiller() {
		// this.conseillerService=new ConseillerServiceImpl();
		this.client = new Client();
		this.conseiller = new Conseiller();
		this.cc = new CompteCourant();
		this.ce = new CompteEpargne();
		this.cv = new CarteVisa();
		this.cel = new CarteElectron();
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	
	
	/**
	 * @return the type2
	 */
	public String[] getType2() {
		return type2;
	}

	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String[] type2) {
		this.type2 = type2;
	}

	/**
	 * @return the cc
	 */
	public CompteCourant getCc() {
		return cc;
	}

	/**
	 * @param cc
	 *            the cc to set
	 */
	public void setCc(CompteCourant cc) {
		this.cc = cc;
	}

	/**
	 * @return the ce
	 */
	public CompteEpargne getCe() {
		return ce;
	}

	/**
	 * @param ce
	 *            the ce to set
	 */
	public void setCe(CompteEpargne ce) {
		this.ce = ce;
	}

	/**
	 * @return the cv
	 */
	public CarteVisa getCv() {
		return cv;
	}

	/**
	 * @param cv
	 *            the cv to set
	 */
	public void setCv(CarteVisa cv) {
		this.cv = cv;
	}

	/**
	 * @return the cel
	 */
	public CarteElectron getCel() {
		return cel;
	}

	/**
	 * @param cel
	 *            the cel to set
	 */
	public void setCel(CarteElectron cel) {
		this.cel = cel;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
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
	 * @return the iddp
	 */
	public int getIddp() {
		return iddp;
	}

	/**
	 * @param iddp the iddp to set
	 */
	public void setIddp(int iddp) {
		this.iddp = iddp;
	}

	/**
	 * @return the idar
	 */
	public int getIdar() {
		return idar;
	}

	/**
	 * @param idar the idar to set
	 */
	public void setIdar(int idar) {
		this.idar = idar;
	}

	/**
	 * @return the type
	 */
	public String[] getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String[] type) {
		this.type = type;
	}

	// ---------------------------------Getter Setter
	// Constructeur-----------------------------------------------------------------TestEnd

	public Conseiller getConseiller(String nom, String password) {
		return conseiller;
	}

	public String ajouterClient() {

		return conseillerService.ajouterClientService(client, conseiller);

	}

	public String modifierClient() {

		return conseillerService.modifierClientService(client);
	}

	public String supprimerClient() {

		return conseillerService.supprimerClientService(client);

	}

	public void lireClient() {
		client = conseillerService.lireClientService(client);
	}

	public String LoginConseiller() {

		Long i = conseillerService.verifConseilerService(conseiller);

		if (i == 1) {

			Conseiller conseiller1 = conseillerService
					.getConseillerService(conseiller);

			conseiller = conseiller1;

			listeClient = conseillerService.getAllClientsService(conseiller);

			return "succesCo";

		} else {

			return "echecCo";

		}
	}

	public void ajouterCompteCourant() {
		Date date = new Date();
		cc.setDateOuverture(date);
		clientService.ajouterCCService(cc, client);

	}

	public void ajouterCompteEpargne() {
		Date date = new Date();
		ce.setDateOuverture(date);
		clientService.ajouterCEService(ce, client);
	}

	public void faireVirement() {
		System.out.println(type[0]+type2[0]);

		if (type[0].contains("CompteCourant")) {
			cd = new CompteCourant();
			cd.setId(iddp);
			
		} else if (type[0].contains("CompteEpargne")) {
			cd = new CompteEpargne();
			cd.setId(iddp);
		}

		if (type2[0].contains("CompteCourant")) {
			ca = new CompteCourant();
			ca.setId(idar);
		} else if (type2[0].contains("CompteEpargne")) {
			ca = new CompteEpargne();
			ca.setId(idar);
		}
		
		conseillerService.faireVirementService(cd, ca, montant);

	}

}
