package ui;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import domain.Assignment;
import utils.Paleta;

/**
 * Lector de notas VIEW
 * 
 * @author mariaguadalupeuvia
 *  
 * marzo 2017
 */

@SuppressWarnings("serial")
public class AssignmentsReadWindow extends Dialog<AssignmentViewModel> 
{
	public AssignmentsReadWindow(WindowOwner owner) 
	{
		super(owner, new AssignmentViewModel());
		this.getModelObject().consultarTareas();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Lector de notas");
		GroupPanel grpTareas = new GroupPanel(mainPanel);
		grpTareas.setTitle("_TAREAS:");

		Table<Assignment> table = new Table<Assignment>(grpTareas, Assignment.class);
		table.setNumberVisibleRows(10);
		table.setWidth(450);
		table.bindItemsToProperty("assignments");
		new Column<Assignment>(table).setTitle("Id").setFixedSize(30).bindContentsToProperty("id");
		new Column<Assignment>(table).setTitle("Titulo").setFixedSize(100).bindContentsToProperty("title");
		new Column<Assignment>(table).setTitle("Descripcion                   .").setFixedSize(300).bindContentsToProperty("description");
		
		Column<Assignment> col = new Column<Assignment>(table);
		col.setTitle("Nota").setFixedSize(100).bindContentsToProperty("grade");
		col.bindBackground("state");
		col.bindForeground("fontColor");
		
		new Column<Assignment>(table).setTitle("Fecha").setFixedSize(100).bindContentsToProperty("created_at");
		new Column<Assignment>(table).setTitle("Actualizacion").setFixedSize(100).bindContentsToProperty("updated_at");
		
		//estetica
		Panel unPanel = new Panel(mainPanel);
		unPanel.setLayout(new HorizontalLayout());
		
		Panel panelColor = new Panel(unPanel);
		panelColor.setLayout(new HorizontalLayout());
		new Label(panelColor).setText("____(º-º)____").setBackground(Paleta.colorBajo());
		new Label(panelColor).setText("____________").setBackground(Paleta.colorMedioBajo());
		new Label(panelColor).setText("___________").setBackground(Paleta.colorMedio());
		new Label(panelColor).setText("__________").setBackground(Paleta.colorMedioAlto());
		new Label(panelColor).setText("_________").setBackground(Paleta.colorAlto());
		
		
	}

}
