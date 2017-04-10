package domain;

import utils.ErrorDatosServidorException;
import utils.Paleta;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * abril 2017
 */

public class NumericGradeAssignment extends Assignment 
{
	@Override
	public void validarNota(String grade) 
	{
		Integer nota = Integer.parseInt(getGrade());
		
		if (nota < 0) 
		{
			setGrade(grade + "(error)");
			cambiarColorDatosInvalidos();
			throw new ErrorDatosServidorException("Error en los datos recibidos del servidor: no se permiten notas negativas");
		}
		if (nota > 10) 
		{
			setGrade(grade + "(error)");
			cambiarColorDatosInvalidos();
			throw new ErrorDatosServidorException("Error en los datos recibidos del servidor: no se permiten notas superiores a 10");
		}
		
		setGrade(grade);
		setColorDeEstado(nota);	
	}
	
	private void setColorDeEstado(Integer grade)
	{
		if(grade < 6)//desaprobado
		{
			setState(Paleta.colorMal());
			return;
		}
		if((grade >= 6) && (grade < 8))//aprobado
		{
			setState(Paleta.colorRegular());
			return;
		}
		if(grade > 8)//bien
		{
			setState(Paleta.colorBien());
			return;
		}
	}
}
