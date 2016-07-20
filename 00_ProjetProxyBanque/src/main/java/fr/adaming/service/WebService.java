package fr.adaming.service;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import fr.adaming.model.Varia;

public class WebService {
	
	
	public String webSer(){
		
		Client cli = Client.create();
				System.out.println("1");
				
		WebResource  webRessource = 		
				cli.resource("http://localhost:8181/WebServiceBanque/rest/post") ;
		System.out.println("2");
		
		ClientResponse clientReponse = webRessource.type("application/json").post(ClientResponse.class);
		System.out.println("3");
		
		String output = clientReponse.getEntity(String.class);
		System.out.println("4");
		
		
		return output;
	}
	
	
	
	
	
	
	

}
