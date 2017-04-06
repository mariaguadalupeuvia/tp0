package ui;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

/**
 * Lector de notas 
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

public class lectorDeNotasApp extends Application
{

	public static void main(String[] args) 
	{
		new lectorDeNotasApp().start();
	}
	
	@Override
	protected Window<?> createMainWindow() 
	{
		return new MainWindow(this);
	}
}