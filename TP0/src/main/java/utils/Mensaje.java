package utils;

import javax.swing.JOptionPane;
/**
 * Lector de notas UTIL
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class Mensaje 
{

	public static void show(int tipo, String mensaje) 
	{
		switch(tipo)
		{
			case 0:
				JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
				break;
			case 1: 
				JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
				break;
			case 2: 
				JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;

		}
	}
}
