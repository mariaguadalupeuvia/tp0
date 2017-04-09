package ui;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import utils.Paleta;
/**
 * Lector de notas VIEW
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

@SuppressWarnings("serial")
public class StudentUpdateWindow extends Dialog<StudentViewModel> 
{ 
	public StudentUpdateWindow(WindowOwner owner) 
	{
		super(owner, new StudentViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Lector de notas");
		GroupPanel grpUpdate = new GroupPanel(mainPanel);
		grpUpdate.setTitle("_COMPLETAR:");

		new Label(grpUpdate).setText("Nombre (*)");
		new TextBox(grpUpdate).setBackground(Paleta.colorEditable()).bindValueToProperty("first_name");
		new Label(grpUpdate).setText("Apellido (*)");
		new TextBox(grpUpdate).setBackground(Paleta.colorEditable()).bindValueToProperty("last_name");
		new Label(grpUpdate).setText("Usuario de Github (*)");
		new TextBox(grpUpdate).setBackground(Paleta.colorEditable()).bindValueToProperty("github_user");

		new Button(grpUpdate).setCaption("Actualizar alumno").onClick(() -> this.getModelObject().actualizarAlumno());
		
		//estetica
		Panel unPanel = new Panel(mainPanel);
		unPanel.setLayout(new HorizontalLayout());
		Panel panelColor = new Panel(unPanel);
		panelColor.setLayout(new HorizontalLayout());
		new Label(panelColor).setText("_(º-º)_").setBackground(Paleta.colorBajo());
		new Label(panelColor).setText("_____").setBackground(Paleta.colorMedioBajo());
		new Label(panelColor).setText("____").setBackground(Paleta.colorMedio());
		new Label(panelColor).setText("___").setBackground(Paleta.colorMedioAlto());
		new Label(panelColor).setText("__").setBackground(Paleta.colorAlto());
		
	}
}
