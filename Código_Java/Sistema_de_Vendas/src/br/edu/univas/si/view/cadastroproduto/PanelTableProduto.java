package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.controller.produto.ControllerConsulta;
import br.edu.univas.si.view.util.MyColor;

/**
 * Summary: Classe cont�m m�todos responsaveis por Montar um JTable e coloca-lo em um JScrollPane utilizando o Model do Produto.
 * @author: S�livan Sim�es Silva
 */
public class PanelTableProduto extends JPanel{

	private static final long serialVersionUID = 1745847296748018092L;
	
	private JTable tableProduto;
	private JScrollPane scroll;
	
	
	public PanelTableProduto(){
		initialize();
	}
	
	private void initialize(){
		setLayout(new  BorderLayout());
		add(getScroll());
	}
	
	public JTable getTableProduto(){
		
		if(tableProduto==null){
			tableProduto = new JTable();
			tableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableProduto.getTableHeader().setBackground(MyColor.SKY_BLUE2);
			tableProduto.setModel(new ControllerConsulta().searchProdutos());
		}
		return tableProduto;
	}
	
	private JScrollPane getScroll() {
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
