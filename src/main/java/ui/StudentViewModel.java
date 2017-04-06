package ui;

import java.util.ArrayList;
import java.util.Collection;
import org.uqbar.commons.utils.Observable;
import domain.Assignment;
import domain.JsonRequester;
import utils.Mensaje;
import org.json.simple.JSONArray;
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
	private Collection<Assignment> assignments = new ArrayList<Assignment>();
	private JsonRequester studentRequester = new JsonRequester();
	
	public void actualizarAlumno() 
	{
		if(validarCampos())
		{
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
		else
		{
			Mensaje.show(2, "Completar todos los campos obligatorios indicados con (*)");
		}
	}

	public void consultarAlumno() 
	{
		try 
		{
			setAtributos(studentRequester.getJson("student"));
		} 
		catch (Exception e) 
		{
			Mensaje.show(2, "No se obtuvo una respuesta satisfactoria al consultar los datos del alumno");
			e.printStackTrace();
		}
	}
	
	public void consultarTareas() 
	{
		try 
		{   
			setAssignments(studentRequester.getJsonArray("student/assignments", "assignments"));
		} 
		catch (Exception e) 
		{
			Mensaje.show(2, "No se obtuvo una respuesta satisfactoria al consultar las tareas del alumno");
			e.printStackTrace();
		}
	}
	
	// Auxiliares-----------------------------------------------	
	private void agregarTareaConNota(JSONArray jsonGradesArray, JSONArray jsonAsignmentsArray, int i)
	{
		   for (int j=0; j<jsonGradesArray.size(); j++)
		   { 
			   Assignment assign = new Assignment();
			   assign.setDescription((String) ((JSONObject) jsonAsignmentsArray.get(i)).get("description"));
		       assign.setId((Long)((JSONObject) jsonAsignmentsArray.get(i)).get("id"));
		       assign.setTitle((String)((JSONObject) jsonAsignmentsArray.get(i)).get("title"));
		   
			   assign.setGrade((String)((JSONObject) jsonGradesArray.get(j)).get("grade"));
		       assign.setCreated_at((String)((JSONObject) jsonGradesArray.get(j)).get("created_at"));
		       assign.setUpdated_at((String)((JSONObject) jsonGradesArray.get(j)).get("updated_at"));
		    
			   assignments.add(assign);   
		   }
	}
	
	private void agregarTareaSinNota(JSONArray jsonAsignmentsArray, int i)
	{
		Assignment assign = new Assignment();
	    assign.setDescription((String) ((JSONObject) jsonAsignmentsArray.get(i)).get("description"));
        assign.setId((Long)((JSONObject) jsonAsignmentsArray.get(i)).get("id"));
        assign.setTitle((String)((JSONObject) jsonAsignmentsArray.get(i)).get("title"));
        assignments.add(assign);  
	}

	private String armarJsonString()
	{
		return "{\"first_name\":\"" + first_name + "\",\"last_name\":\""+ last_name +"\",\"github_user\":\""+ github_user +"\"}";
	}
	
	private void setAssignments(JSONArray jsonAsignmentsArray)
	{    
		assignments.clear();
		JSONArray jsonGradesArray;
		
		if (jsonAsignmentsArray != null) 
		{ 
		   for (int i=0; i<jsonAsignmentsArray.size(); i++)
		   { 
			    jsonGradesArray = (JSONArray)((JSONObject) jsonAsignmentsArray.get(i)).get("grades");
			    
				if ((jsonGradesArray != null) && !(jsonGradesArray.isEmpty()))
				{ 
					agregarTareaConNota(jsonGradesArray, jsonAsignmentsArray, i);
				}
				else
				{
					agregarTareaSinNota(jsonAsignmentsArray, i);
				}
		   } 
		}  
	}
	
	private void setAtributos(JSONObject jsonObject)
    {
		setCode((String) jsonObject.get("code"));
		setFirst_name((String) jsonObject.get("first_name"));
		setLast_name((String) jsonObject.get("last_name"));
		setGithub_user((String) jsonObject.get("github_user"));
	}
	
	private Boolean validarCampos()
	{
		return ((first_name != null) && (last_name != null) && (github_user != null) && (first_name != "") && (last_name != "") && (github_user != ""));
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
	public Collection<Assignment> getAssignments() 
	{
		return assignments;
	}
	public void setAssignments(Collection<Assignment> assignments) 
	{
		this.assignments = assignments;
	}

}
