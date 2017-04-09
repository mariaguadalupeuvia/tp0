package domain;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import utils.Config;
import utils.ErrorServidorNoEncontradoException;
import utils.Mensaje;
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
		catch(NullPointerException e)
		{
			Mensaje.show(0, "\nNo se pudo conectar con el servidor '" + RESOURCE + "',\n\ncompruebe su acceso a internet, si el error persiste contacte con un admin \n\n");
			throw new ErrorServidorNoEncontradoException();
		}
	}
	
	public ClientResponse putResource(String path, String jsonString) 
	{
       WebResource recurso = this.client.resource(RESOURCE).path(path);
       WebResource.Builder builder = recurso.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON);
       ClientResponse response = builder.put(ClientResponse.class, jsonString);
       return response;
	}
	
}
  