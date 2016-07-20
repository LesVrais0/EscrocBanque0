package fr.adaming.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IGerantService;

@ManagedBean(name ="mBGerant")
@SessionScoped
public class ManagedGerant {
	
	private List<Conseiller> listeCon;
	
	private Gerant gerant;
	
	private Conseiller conseiller;
	
	@ManagedProperty(value="#{gerantService}")
	private IGerantService gerantService;
	
	@ManagedProperty(value = "#{clService}")
	private IClientService clientService;

	@ManagedProperty(value = "#{cService}")
	private IConseillerService conseillerService;

	/**
	 * 
	 */
	public ManagedGerant() {
		this.gerant = new Gerant();
		this.conseiller = new Conseiller();
		this.listeCon = new ArrayList<Conseiller>();
	}

	/**
	 * @return the listeCon
	 */
	public List<Conseiller> getListeCon() {
		return listeCon;
	}

	/**
	 * @param listeCon the listeCon to set
	 */
	public void setListeCon(List<Conseiller> listeCon) {
		this.listeCon = listeCon;
	}

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	
	

	/**
	 * @return the gerantService
	 */
	public IGerantService getGerantService() {
		return gerantService;
	}

	/**
	 * @param gerantService the gerantService to set
	 */
	public void setGerantService(IGerantService gerantService) {
		this.gerantService = gerantService;
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
	
	//=====================================================================================

	public void getAllConseiller(){
		listeCon = gerantService.getAllConseiller(gerant);
	}
	
	public String ajouterConseiller(){
		gerantService.ajouterConseillerService(conseiller, gerant);
		listeCon = gerantService.getAllConseiller(gerant);
		return "succesGerant";
	}
	
	public String modiferConseiller(){
		System.out.println(conseiller.getId()+conseiller.getNom());
		gerantService.modifierConseillerService(conseiller);
		listeCon = gerantService.getAllConseiller(gerant);
		return "succesGerant";
	}
	
	public String supprimerConseiller(){
		gerantService.supprimerConseillerService(conseiller);
		listeCon = gerantService.getAllConseiller(gerant);
		return "succesGerant";
	}
	
	public String seConnecter(){
		
		Long i = gerantService.verifGerant(gerant);
		
		if(i==1){
		gerant = gerantService.getGerantService(gerant);
		listeCon = gerantService.getAllConseiller(gerant);
		return "succesGerant";
		}else{
			return "echecGerant";
		}
	}
	
	public void conseillerById(){
		
		conseiller = gerantService.getConseillerById(conseiller);
	}
}
