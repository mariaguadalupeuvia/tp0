package ui;

import org.uqbar.commons.utils.Observable;
import domain.JsonRequester;
import utils.Mensaje;
import org.json.simple.JSONObject;

/**
 * Lector de notas VIEW MODEL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

@Observable
public class StudentViewModel 
{
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	private JsonRequester studentRequester = new JsonRequester();
	
	public void actualizarAlumno() 
	{
		if(!esValido())
		{
			return;
		}

		String jsonString = armarJsonString(); 
		try 
		{
			setAtributos(studentRequester.putJson("student", jsonString));
			Mensaje.show(2, "Se actualizaron los datos del alumno con exito");
		} 
		catch (Exception e) 
		{
			Mensaje.show(1, "Se produjo un error al intentar actualizar los datos del alumno");
			e.printStackTrace();
		}
	}
	
	public void consultarAlumno() 
	{
		try 
		{
			setAtributos(studentRequester.getJson("student"));
		} 
//		catch(UnknownHostException e)
//		{
//			Mensaje.show(2, "No se pudo conectar con el servidor remoto notitas.herokuapp.com, compruebe su acceso a internet");
//			e.printStackTrace();
//		}
		catch (Exception e) 
		{
			Mensaje.show(2, "No se obtuvo una respuesta satisfactoria al consultar los datos del alumno");
			e.printStackTrace();
		}
	}
	

	// Auxiliares-----------------------------------------------	
	private String armarJsonString()
	{
		return "{\"first_name\":\"" + first_name + "\",\"last_name\":\""+ last_name +"\",\"github_user\":\""+ github_user +"\"}";
	}
		
	private Boolean esValido()
	{
		if (validarCamposVacios())
		{
			if(validarSoloLetras(first_name) && validarSoloLetras(last_name))
			{
				return true;
			}
			else
			{
				Mensaje.show(2, "Completar nombre y apellido unicamente con letras");
			}
		}
		else
		{
			Mensaje.show(2, "Completar todos los campos obligatorios indicados con (*)");
		}
		return false;
	}
	
	private void setAtributos(JSONObject alumno)
    {
		setCode((String) alumno.get("code"));
		setFirst_name((String) alumno.get("first_name"));
		setLast_name((String) alumno.get("last_name"));
		setGithub_user((String) alumno.get("github_user"));
	}
	
	private Boolean validarCamposVacios()
	{
		return ((first_name != null) && (last_name != null) && (github_user != null) && (first_name != "") && (last_name != "") && (github_user != ""));
	}
	
	private Boolean validarSoloLetras(String unString)
	{
		return unString.matches("([a-z]|[A-Z]|\\s)+");
	}
	
	
	// Accessors----------------------------------------------------------
	public String getCode() 
	{
		return code;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	public String getFirst_name() 
	{
		return first_name;
	}
	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
	}
	public String getLast_name() 
	{
		return last_name;
	}
	public void setLast_name(String last_name) 
	{
		this.last_name = last_name;
	}
	public String getGithub_user() 
	{
		return github_user;
	}
	public void setGithub_user(String github_user) 
	{
		this.github_user = github_user;
	}
}
