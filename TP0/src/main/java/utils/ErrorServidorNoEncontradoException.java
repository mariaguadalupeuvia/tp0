package utils;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * abril 2017
 */

@SuppressWarnings("serial")
public class ErrorServidorNoEncontradoException extends RuntimeException 
{
	public  ErrorServidorNoEncontradoException()
	{
		super();
	}
	public  ErrorServidorNoEncontradoException(String mensaje)
	{
		super(mensaje);
		
	}
}
