package br.edu.univas.si.view.realizarvenda;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.model.tablemodel.TableModelProduto;
import br.edu.univas.si.view.util.MyColor;

public class PanelTableProdutos extends JPanel{

	private static final long serialVersionUID = 6432614191273395332L;
	
	private JTable tableProduto;
	private JScrollPane scroll;
	
	public PanelTableProdutos() {
		setLayout(new BorderLayout());
		initialize();
	}

	private void initialize() {
		add(getScroll());
	}
	
	private JTable getTableProduto(){
		if(tableProduto==null){
			tableProduto = new JTable();
			tableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableProduto.getTableHeader().setBackground(MyColor.DEEP_SKY_BLUE);
			tableProduto.setModel(new TableModelProduto());
		}
		return tableProduto;
	}
	
	private JScrollPane getScroll(){
		if(scroll==null){
			scroll = new JScrollPane(getTableProduto());
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scroll;
	}
	
	public JTable getTable(){
		return getTableProduto();
	}
}
