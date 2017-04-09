package ui;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.math.NumberUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.uqbar.commons.utils.Observable;

import domain.Assignment;
import domain.ConceptualGradeAssignment;
import domain.JsonRequester;
import domain.NumericGradeAssignment;

/**
 * Lector de notas VIEW MODEL
 * 
 * @author mariaguadalupeuvia
 *  
 *  abril 2017
 */

@Observable
public class AssignmentViewModel 
{
	private Collection<Assignment> assignments = new ArrayList<Assignment>();
	private JsonRequester assignmentRequester = new JsonRequester();
	
	public void consultarTareas() 
	{
		JSONArray jsonAsignmentsArray = assignmentRequester.getJsonArray("student/assignments", "assignments");
		if (jsonAsignmentsArray != null) 
		{ 
			setAssignments(jsonAsignmentsArray);
		}  
	}
	
	
	// Auxiliares-----------------------------------------------	
		private void agregarTareaConNota(JSONArray jsonGradesArray, JSONObject unaTarea)
		{
		   for (int j=0; j<jsonGradesArray.size(); j++)
		   { 
			   JSONObject unaNota = (JSONObject) jsonGradesArray.get(j);
			   Assignment assign;
			 
			   if (NumberUtils.isNumber((String) unaNota.get("grade")))
			   {
				   assign =  new NumericGradeAssignment();
			   }
			   else
			   {
				   assign = new ConceptualGradeAssignment();
			   }

			   assign.setDescription((String) unaTarea.get("description"));
		       assign.setId((Long) unaTarea.get("id"));
		       assign.setTitle((String) unaTarea.get("title"));
		       
			   assign.setGrade((String) unaNota.get("grade"));
		       assign.setCreated_at((String) unaNota.get("created_at"));
		       assign.setUpdated_at((String) unaNota.get("updated_at"));
		 	       
			   assignments.add(assign);  
		   }
		}
		
		private void agregarTareaSinNota(JSONObject tarea)
		{
			Assignment assign = new Assignment();
		    assign.setDescription((String) tarea.get("description"));
	        assign.setId((Long) tarea.get("id"));
	        assign.setTitle((String) tarea.get("title"));
	        assignments.add(assign);  
		}
		
		private void setAssignments(JSONArray jsonAsignmentsArray)
		{    
			assignments.clear();
			JSONArray jsonGradesArray;
			
		    for (int i=0; i<jsonAsignmentsArray.size(); i++)
		    { 
			    jsonGradesArray = (JSONArray)((JSONObject) jsonAsignmentsArray.get(i)).get("grades");
			    
				if ((jsonGradesArray != null) && !(jsonGradesArray.isEmpty()))
				{ 
					agregarTareaConNota(jsonGradesArray, (JSONObject) jsonAsignmentsArray.get(i));
				}
				else
				{
					agregarTareaSinNota((JSONObject) jsonAsignmentsArray.get(i));
				}
		    } 
		}
		
		//Accessors----------------------------------------
		
		public Collection<Assignment> getAssignments() 
		{
			return assignments;
		}
		
		public void setAssignments(Collection<Assignment> assignments) 
		{
			this.assignments = assignments;
		}
}
