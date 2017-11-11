package br.edu.univas.si.view.cadastrounidademedida;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.model.dao.consulta.jtables.GridUnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.view.util.MyColor;

public class PanelTableUnidadeMedida extends JPanel {

	private static final long serialVersionUID = 6444281616435672861L;

	private JTable tableUnidadeMedida;
	private TableModelUnidadeMedida tableModelUnidadeMedida;
	private JScrollPane scroll;

	public PanelTableUnidadeMedida() {
		initialize();
	}
	
	private void initialize(){
		add(getScroll());
	}

	private JTable getTableUnidadeMedida() {
		if(tableUnidadeMedida==null){
			tableUnidadeMedida = new JTable();
			tableUnidadeMedida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableUnidadeMedida.getTableHeader().setBackground(MyColor.DEEP_SKY_BLUE);
			tableUnidadeMedida.setModel(getTableModelUnidadeMedida());
		}
		return tableUnidadeMedida;
	}

	private TableModelUnidadeMedida getTableModelUnidadeMedida(){
		if(tableModelUnidadeMedida==null){
			GridUnidadeMedidaDAO data = new GridUnidadeMedidaDAO();
				try {
					tableModelUnidadeMedida= new TableModelUnidadeMedida(data.populateGridUnidadeMedida());
				} catch (UnidadeMedidaException e) {
					e.printStackTrace();
				}
		}
		return tableModelUnidadeMedida;
	}

	private JScrollPane getScroll() {
		if(scroll==null){
			scroll = new JScrollPane(getTableUnidadeMedida());
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scroll;
	}
}
