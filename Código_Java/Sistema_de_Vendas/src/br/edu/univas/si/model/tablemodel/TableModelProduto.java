package br.edu.univas.si.model.tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.ProdutoTO;

/**
 * Summary: Classe cont�m m�todos que montam um Model para o Produto
 * @author: S�livan Sim�es Silva
 */
public class TableModelProduto extends AbstractTableModel {

	private static final long serialVersionUID = 750282736875565952L;
	
	private ArrayList<ProdutoTO> produtos; 
	private String[] colunas = new String[]{"C�digo de Barras","Descri��o","Unidade medida","Pre�o venda"};
	//idice das colunas
	private final int CODIGO_DE_BARRAS = 0;
	private final int DESCRICAO = 1;
	private final int UNIDADE_MEDIDA = 2;
	private final int PRECO_VENDA = 3;
	
	public TableModelProduto(){
		produtos = new ArrayList<ProdutoTO>();
	}
	
	public TableModelProduto(ArrayList<ProdutoTO> listaProdutos){
		produtos = new ArrayList<ProdutoTO>(listaProdutos);
	}
	
	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
			case CODIGO_DE_BARRAS :
				return Long.class;
			case DESCRICAO :
				return String.class;
			case UNIDADE_MEDIDA :
				return String.class;
			case PRECO_VENDA :
				return Float.class;
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProdutoTO p = produtos.get(rowIndex);
		
		switch(columnIndex){
			case CODIGO_DE_BARRAS :
				return p.getCodigoDeBarras();
			case DESCRICAO :
				return p.getDescricao();
			case UNIDADE_MEDIDA :
				return p.getCodigo_unidadeMedida();
			case PRECO_VENDA :
				return p.getPrecoVenda();
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}	
	}
}
