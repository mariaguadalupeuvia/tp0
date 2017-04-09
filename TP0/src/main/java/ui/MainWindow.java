package ui;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.GroupPanel;
import utils.Paleta;
/**
 * Lector de notas VIEW
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

@SuppressWarnings("serial")
public class MainWindow extends SimpleWindow<StudentViewModel> 
{
	public MainWindow(WindowOwner parent) 
	{
		super(parent, new StudentViewModel());
	}
	
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Lector de notas");
		mainPanel.setLayout(new VerticalLayout());
		this.getModelObject().consultarAlumno();

		Panel unPanel = new Panel(mainPanel);
		unPanel.setLayout(new HorizontalLayout());
		
		//estetica
		Panel panelColor = new Panel(unPanel);
		panelColor.setLayout(new VerticalLayout());
		new Label(panelColor).setText("(º-º)").setBackground(Paleta.colorBajo());
		new Label(panelColor).setText("___").setBackground(Paleta.colorMedioBajo());
		new Label(panelColor).setText("___").setBackground(Paleta.colorMedio());
		new Label(panelColor).setText("___").setBackground(Paleta.colorMedioAlto());
		new Label(panelColor).setText("___").setBackground(Paleta.colorAlto());
		
		//controles 
		GroupPanel grpAlumno = new GroupPanel(unPanel);
		grpAlumno.setTitle("__ALUMNO:");
		grpAlumno.setLayout(new HorizontalLayout());
		Panel panel1 = new Panel(grpAlumno);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(grpAlumno);
		panel2.setLayout(new VerticalLayout());
		
		new Label(panel1).setText("Nombre                 .");
		new Label(panel1).setText("Apellido                .");
		new Label(panel1).setText("Usuario de Github");
		new Label(panel1).setText("Codigo                  .");
		
		new Label(panel2).setBackground(Paleta.colorNoEditable()).bindValueToProperty("first_name");
		new Label(panel2).setBackground(Paleta.colorNoEditable()).bindValueToProperty("last_name");
		new Label(panel2).setBackground(Paleta.colorNoEditable()).bindValueToProperty("github_user");
		new Label(panel2).setBackground(Paleta.colorNoEditable()).bindValueToProperty("code");
	}
	
	@Override
	protected void addActions(Panel panelActions) 
	{
		new Button(panelActions)
			.setCaption("Refrescar datos")
			.onClick(() -> this.getModelObject().consultarAlumno());
		
		new Button(panelActions)
			.setCaption("Actualizar datos")
			.onClick(this::createUpdateWindow);
		
		new Button(panelActions)
			.setCaption("Consultar tareas")
			.onClick(this::createReadAssignmentsWindow);
	}
	
	public void createUpdateWindow() 
	{
		Dialog<?> dialog = new StudentUpdateWindow(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}
	
	public void createReadAssignmentsWindow() 
	{
		Dialog<?> dialog = new AssignmentsReadWindow(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}
}
