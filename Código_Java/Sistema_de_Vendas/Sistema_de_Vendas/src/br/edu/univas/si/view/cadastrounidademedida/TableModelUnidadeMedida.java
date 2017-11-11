package br.edu.univas.si.view.cadastrounidademedida;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.UnidadeMedidaTO;

public class TableModelUnidadeMedida extends AbstractTableModel{
	
	private static final long serialVersionUID = 5849317991729478705L;
	
	private ArrayList<UnidadeMedidaTO> unidadeMedida;
	private String[] colunas = new String[]{"C�digo","Descri��o"};
	
	//Constantes refente aos indices das colunas.
	private final int CODIGO = 0;
	private final int DESCRICAO = 1;
	
	public TableModelUnidadeMedida() {
		unidadeMedida = new ArrayList<UnidadeMedidaTO>();
	}
	
	public TableModelUnidadeMedida(ArrayList<UnidadeMedidaTO> listaUnidadeMedida){
		unidadeMedida = new ArrayList<UnidadeMedidaTO>(listaUnidadeMedida);
	}
	
	@Override
	public int getRowCount() {
		return unidadeMedida.size();
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
			case CODIGO :
				return String.class;
			case DESCRICAO :
				return String.class;
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
		
			UnidadeMedidaTO unidade = unidadeMedida.get(rowIndex);
			switch(columnIndex){
				case CODIGO :
					return unidade.getCodigo();
				case DESCRICAO :
					return unidade.getDescricao();
				default :
					throw new IndexOutOfBoundsException("columnIndex out of bounds");
			}
	}

}
