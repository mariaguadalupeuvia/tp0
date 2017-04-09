package test;

import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.ClientResponse;
import static org.junit.Assert.*;
import domain.RequestService;

/**
 * Lector de notas TEST
 * 
 * @author mariaguadalupeuvia
 *  
 * abril 2017
 */

public class RequestServiceTest 
{
	 RequestService requester;
     //faltaria armar test para validar que las notas tengan los valores esperados: M, R, B o numeros del 1 al 10
	 
	    @Before
	    public void setUp() throws Exception 
	    {
	        this.requester = new RequestService();
	    }

	    @Test
	    public void obtenerAlumno() throws Exception 
	    {//deberia funcionar ok devolviendo un student
	        ClientResponse response = this.requester.getResource("student");
	        assertEquals(response.getStatus(), 200);
	        String json = response.getEntity(String.class);
	        assertTrue(json.contains("first_name"));
	        assertTrue(json.contains("last_name"));
	        assertTrue(json.contains("code"));
	        assertTrue(json.contains("github_user"));
	    }
	    
	    @Test
	    public void obtenerRecursoQueNoEspero() throws Exception 
	    {//deberia romper al no reconocer una estructura de student valida
	        ClientResponse response = this.requester.getResource("student");
	        assertEquals(response.getStatus(), 200);
	        String json = response.getEntity(String.class);
	        assertFalse(json.contains("first_name"));
	        assertFalse(json.contains("last_name"));
	        assertFalse(json.contains("code"));
	        assertFalse(json.contains("github_user"));
	    }
	    @Test
	    public void obtenerRecursoQueNoExiste() throws Exception 
	    {//deberia romper al no encontrar el recurso pedido
	        ClientResponse response = this.requester.getResource("cualquiera");
	        assertEquals(response.getStatus(), 200);
	    }
	    @Test
	    public void obtener404NotFound() throws Exception 
	    {//deberia devolver 404 
	        ClientResponse response = this.requester.getResource("cualquiera");
	        assertEquals(response.getStatus(), 404);
	    }
	    @Test
	    public void obtenerTareas() throws Exception 
	    {//deberia funcionar ok devolviendo una lista de assignments
	        ClientResponse response = this.requester.getResource("student/assignments");
	        assertEquals(response.getStatus(), 200);
	        String json = response.getEntity(String.class);
	        assertTrue(json.contains("assignments"));
	        assertTrue(json.contains("grades"));
	        assertTrue(json.contains("id"));
	        assertTrue(json.contains("title"));
	        assertTrue(json.contains("description"));
	      //System.out.println(json);
	    }
	    @Test
	    public void obtenerNotas() throws Exception 
	    {//deberia funcionar ok cuando encuentre notas cargadas en alguna tarea
	        ClientResponse response = this.requester.getResource("student/assignments");
	        assertEquals(response.getStatus(), 200);
	        String json = response.getEntity(String.class);
	        assertTrue(json.contains("grades"));
	        assertTrue(json.contains("value"));
	        assertTrue(json.contains("created_at"));
	        assertTrue(json.contains("updated_at"));
	    }
	    @Test
	    public void putAlumnoBien() throws Exception 
	    {//deberia funcionar ok
	        ClientResponse response = this.requester.putResource("student","{\"first_name\":\"maria\",\"last_name\":\"uviña\",\"github_user\":\"alguno\"}");
	        assertEquals(response.getStatus(), 201);
	    }
	    @Test
	    public void putRecursoSinEstructura() throws Exception 
	    {//deberia romper
	        ClientResponse response = this.requester.putResource("student","xxx");
	        assertEquals(response.getStatus(), 201);
	    }

}
