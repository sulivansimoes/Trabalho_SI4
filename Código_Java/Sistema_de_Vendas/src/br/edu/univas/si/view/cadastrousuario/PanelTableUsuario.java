package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.controller.usuario.ControllerConsulta;
import br.edu.univas.si.view.util.MyColor;

public class PanelTableUsuario extends JPanel {

	private static final long serialVersionUID = 466838327716312031L;
	
	private JTable tableUsuario;
	private JScrollPane scroll;
	
	public PanelTableUsuario(){
		setLayout(new BorderLayout());
		initialize();
	}
	
	private void  initialize(){
		add(getScroll());
	}
	
	private JTable getTableUsuario() {
		if(tableUsuario==null){
			tableUsuario = new JTable();
			tableUsuario.setModel(new ControllerConsulta().searchUsuario());
			tableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableUsuario.getTableHeader().setBackground(MyColor.DEEP_SKY_BLUE);
		}
		return tableUsuario;
	}
	private JScrollPane getScroll() {
		if(scroll==null){
			scroll = new JScrollPane(getTableUsuario());
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scroll;
	}
	
	public JTable getTable(){
		return getTableUsuario();
	}
}
