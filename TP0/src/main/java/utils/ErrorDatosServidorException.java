package utils;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * abril 2017
 */

@SuppressWarnings("serial")
public class ErrorDatosServidorException extends RuntimeException
{
	public  ErrorDatosServidorException()
	{
		super();
	}
	public  ErrorDatosServidorException(String mensaje)
	{
		super(mensaje);
	}
}
