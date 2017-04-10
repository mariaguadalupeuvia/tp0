package utils;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * abril 2017
 */

@SuppressWarnings("serial")
public class ErrorRecursoNoEncontradoException extends RuntimeException 
{
	public  ErrorRecursoNoEncontradoException()
	{
		super();
	}
	public  ErrorRecursoNoEncontradoException(String mensaje)
	{
		super(mensaje);
		
	}
}
