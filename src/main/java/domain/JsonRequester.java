package domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.sun.jersey.api.client.ClientResponse;
import static org.junit.Assert.*;
/**
 * Lector de notas MODEL VIEW?
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class JsonRequester 
{
	RequestService requester;	
	
	public JsonRequester()
	{
		this.requester = new RequestService();	
	}

	public JSONObject getJson(String path) throws Exception 
	{
		ClientResponse response = this.requester.getResource(path);
		assertEquals(response.getStatus(), 200);
		String jsonString = response.getEntity(String.class);
		return (JSONObject) JSONValue.parse(jsonString);
	}
	
	public JSONArray getJsonArray(String path, String colectionName) throws Exception 
	{
		ClientResponse response = this.requester.getResource(path);
		assertEquals(response.getStatus(), 200);
		String jsonString = response.getEntity(String.class);
		JSONObject json = (JSONObject) JSONValue.parse(jsonString);
		//System.out.println(jsonString);
		return (JSONArray)json.get(colectionName);
	}
	
	public JSONObject putJson(String path, String resource) throws Exception 
	{
		ClientResponse response = this.requester.putResource(path, resource);
		assertEquals(response.getStatus(), 201);
		String jsonString = response.getEntity(String.class);
		return (JSONObject) JSONValue.parse(jsonString);
	}
	
}
