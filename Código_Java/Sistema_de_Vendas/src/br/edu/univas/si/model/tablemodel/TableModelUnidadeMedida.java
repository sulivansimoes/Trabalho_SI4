package br.edu.univas.si.model.tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.UnidadeMedidaTO;

public class TableModelUnidadeMedida extends AbstractTableModel{
	
	private static final long serialVersionUID = 5849317991729478705L;
	
	private ArrayList<UnidadeMedidaTO> unidadeMedida;
	private String[] colunas = new String[]{"Código","Descrição"};
	
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
	
	//Retorna Usuario da linha especificada
	public UnidadeMedidaTO getUnidadeMedida(int indiceLinha){
		return unidadeMedida.get(indiceLinha);
	}
	
	//Adiciona o usuario especificado no model
	public void addUnidadeMedida(UnidadeMedidaTO unidade){
		unidadeMedida.add(unidade);
		
		//Pega a quantidade de registros e subtrai 1 para achar o último índice.
	    int ultimoIndice = getRowCount() - 1;
		 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
		
	public void removeUnidadeMedida(int indiceLinha){
		//Remove  o registro
		unidadeMedida.remove(indiceLinha);
		
		//Notifica mudança ao model
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
		
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDeUnidadesDeMedida(ArrayList<UnidadeMedidaTO> listaUnidadeMedida) {
	    // Pega o tamanho antigo da tabela, que servirá
	    // como índice para o primeiro dos novos registros
	    int indice = getRowCount();
		 
	    // Adiciona os registros.
	    unidadeMedida.addAll(listaUnidadeMedida);
		 
		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + unidadeMedida.size());
	}
		
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista.
	    unidadeMedida.clear();
		 
	    // Notifica a mudança.
	    fireTableDataChanged();
	}
}
