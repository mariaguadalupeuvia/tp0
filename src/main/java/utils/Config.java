package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class Config 
{
	public static String property(String nombre)
	{
		try 
		{
			FileInputStream file = new FileInputStream("config.properties");
			Properties props = new Properties();
			props.load(file);
			String prop = props.getProperty(nombre);
			return prop;
		} 
		catch (IOException e) 
		{
			Mensaje.show(0, "Se produjo un error al intentar cargar archivo de configuracion");
			e.printStackTrace();
		}

		return null;
	}
}
