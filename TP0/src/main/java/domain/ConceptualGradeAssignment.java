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

public class ConceptualGradeAssignment extends Assignment 
{
	public void validarNota(String grade) 
	{
		validarNotaYCambiarColor(grade);
	}
	
     private void validarNotaYCambiarColor(String grade)
	{
		switch(grade)
		{
			case "M":
				setState(Paleta.colorMal());
				break;
			case "R":
				setState(Paleta.colorRegular());
				break;
			case "B":
				setState(Paleta.colorBien());
				break;
			default:
				setGrade(grade + "(error)");
				throw new ErrorDatosServidorException("Error en los datos recibidos del servidor: la nota recibida no corresponde con la escala actual: M, R o B");
		}
		setGrade(grade);
	}
}
