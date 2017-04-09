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
	protected void setColorDeEstado()
	{
		Integer grade = Integer.parseInt(getGrade());
		
		if (grade < 0) 
		{
			throw new ErrorDatosServidorException("Error en los datos recibidos del servidor: no se permiten notas negativas");
		}
			
		if (grade > 10) 
		{
			throw new ErrorDatosServidorException("Error en los datos recibidos del servidor: no se permiten notas superiores a 10");
		}
		
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
