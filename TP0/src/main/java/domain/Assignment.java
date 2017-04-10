package domain;

import java.awt.Color;

import org.apache.commons.lang.NotImplementedException;
import org.uqbar.commons.utils.Observable;
import utils.Paleta;

/**
 * Lector de notas MODEL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

@Observable
public class Assignment 
{
	private Long id;
	private String title;
	private String description;
	private String grade;
	private String created_at;
	private String updated_at;
	
	private Color state;
	private Color fontColor;
	
	public void validarNota(String grade)  
	{
		throw new NotImplementedException("En construccion. La operacion solicitada no ha sido implementada todavia");
	}
	
	protected void cambiarColorDatosInvalidos()
	{
		setFontColor(Paleta.colorFontErrorDatosServidor());
		setState(Paleta.colorErrorDatosServidor());
	}

	//Accessors----------------------------------------
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getCreated_at() 
	{
		return created_at;
	}
	public void setCreated_at(String created_at) 
	{
		this.created_at = created_at;
	}
	public String getUpdated_at() 
	{
		return updated_at;
	}
	public void setUpdated_at(String updated_at) 
	{
		this.updated_at = updated_at;
	}
	public String getGrade() 
	{
		return grade;
	}
	public void setGrade(String grade) 
	{
		this.grade = grade;
	}
	
	public Color getState() 
	{
		return state;
	}
	public void setState(Color state) 
	{
		this.state = state;
	}
	public Color getFontColor() 
	{
		return fontColor;
	}
	public void setFontColor(Color fontColor) 
	{
		this.fontColor = fontColor;
	} 
	
}
