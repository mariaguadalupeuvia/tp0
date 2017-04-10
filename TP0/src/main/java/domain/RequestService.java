package domain;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import utils.Config;
import utils.ErrorRecursoNoEncontradoException;
/**
 * Lector de notas MODEL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class RequestService 
{
	private static final String RESOURCE = Config.property("RESOURCE");
	private Client client;
	private String token;

	public RequestService() 
	{
		this.client = Client.create();
		this.token = Config.property("TOKEN");
	}
	
	public ClientResponse getResource(String path) 
	{
		try
		{
			ClientResponse response = this.client.resource(RESOURCE).path(path)
					.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			return response;
		}
		catch(Exception e)
		{
			throw new ErrorRecursoNoEncontradoException();
		}
	}
	
	public ClientResponse putResource(String path, String jsonString) 
	{
		try
		{
	       WebResource recurso = this.client.resource(RESOURCE).path(path);
	       WebResource.Builder builder = recurso.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON);
	       ClientResponse response = builder.put(ClientResponse.class, jsonString);
	       return response;
		}
		catch(Exception e)
		{
			throw new ErrorRecursoNoEncontradoException();
		}
	}
	
}
  