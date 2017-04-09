package utils;

import java.awt.Color;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class Paleta 
{
	//color informativo
	public static Color colorNoEditable()
	{
		return new Color(210,215,240);
	}
	public static Color colorEditable()
	{
		return new Color(255, 255, 255);
	}
	
	public static Color colorMal()
	{
		return new Color(255, 150, 150);
	}
	
	public static Color colorRegular()
	{
		return new Color(150,255,255);
	}
	
	public static Color colorBien()
	{
		return new Color(200, 255, 150);
	}
	
	public static Color colorErrorDatosServidor()
	{
		return new Color(200, 200, 200);
	}
	
	public static Color colorFontErrorDatosServidor()
	{
		return new Color(255, 50, 50);
	}
	
	
	//estetica
	public static Color colorBajo()
	{
		return new Color(0, 255, 0);
	}
	public static Color colorMedioBajo()
	{
		return new Color(50, 255, 100);
	}
	public static Color colorMedio()
	{
		return new Color(90, 255, 150);
	}
	public static Color colorMedioAlto()
	{
		return new Color(170, 255, 200);
	}
	public static Color colorAlto()
	{
		return new Color(250, 255, 250);
	}


}
