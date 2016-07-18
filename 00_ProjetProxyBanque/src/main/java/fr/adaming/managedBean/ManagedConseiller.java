package fr.adaming.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerServiceImpl;
import fr.adaming.service.IConseillerService;

@ManagedBean(name="mBConseiller")
@SessionScoped
public class ManagedConseiller {

	private Conseiller conseiller;

	private Client client;

	private List<Client> listeClient;

	@ManagedProperty(value="#{cService}")//il faut le changer avec ManagedProperty
	private IConseillerService conseillerService;

	// ---------------------------------Getter Setter Constructeur----------------------------------------------------------------Start

	/**
	 * 
	 */
	public ManagedConseiller() {
		//this.conseillerService=new ConseillerServiceImpl();
		this.client=new Client();
		this.conseiller=new Conseiller();
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

	// ---------------------------------Getter Setter Constructeur-----------------------------------------------------------------TestEnd

	public Conseiller getConseiller(String nom, String password) {
		return conseiller;
	}

	public String ajouterClient() {
			
			return conseillerService.ajouterClientService(client);

	}
	
	public String modifierClient(){
		
		return conseillerService.modifierClientService(client);
	}

	public String supprimerClient() {
		
		return conseillerService.supprimerClientService(client);
	
	}
	
	public String LoginConseiller(){
		
		int i = conseillerService.verifConseilerService(conseiller);
		
		if(i==1){
			
			Conseiller conseiller1 = conseillerService.getConseillerService(conseiller);
			
			conseiller = conseiller1;
			
			return "succesCo";
			
		}else{
			
			return "echecCo";
			
		}
	

	}
}
