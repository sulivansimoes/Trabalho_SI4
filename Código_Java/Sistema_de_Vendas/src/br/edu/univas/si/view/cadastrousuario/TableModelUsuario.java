package br.edu.univas.si.view.cadastrousuario;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.UsuarioTO;

public class TableModelUsuario extends AbstractTableModel {

	private static final long serialVersionUID = 8563314903799562271L;
	
	private ArrayList<UsuarioTO> usuarios;
	private String[] colunas = new String[]{"Cpf","Nome","Acesso Administrador","Acesso Caixa"};
	
	//Constantes referente aos indices das colunas
	private final int CPF = 0;
	private final int NOME = 1;
	private final int ADMINISTRADOR = 2;
	private final int CAIXA = 3;
	
	public TableModelUsuario(){
		usuarios = new ArrayList<UsuarioTO>();
	}
	
	public TableModelUsuario(ArrayList<UsuarioTO> listUsuarios){
		usuarios = new ArrayList<UsuarioTO>(listUsuarios);
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
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
			case CPF :
				return Long.class;
			case NOME :
				return String.class;
			case ADMINISTRADOR : case CAIXA :
				return Boolean.class;
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
		UsuarioTO usuario = usuarios.get(rowIndex);
		
		switch(columnIndex){
			case CPF :
				return usuario.getCpf();
			case NOME :
				return usuario.getNome();
			case ADMINISTRADOR :
				return  usuario.isGerente();
			case CAIXA :
				return usuario.isCaixa();
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	//Retorna Usuario da linha especificada
	public UsuarioTO getUsuario(int indiceLinha){
		return usuarios.get(indiceLinha);
	}
	
	//Adiciona o usuario especificado no model
	public void addUsuario(UsuarioTO usuario){
		usuarios.add(usuario);
		
		//Pega a quantidade de registros e subtrai 1 para achar o último índice.
	    int ultimoIndice = getRowCount() - 1;
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void removeUsuario(int indiceLinha){
		//Remove  o registro
		usuarios.remove(indiceLinha);
		
		//Notifica mudança ao model
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDeUsuarios(ArrayList<UsuarioTO> listaUsuarios) {
	    // Pega o tamanho antigo da tabela, que servirá
	    // como índice para o primeiro dos novos registros
	    int indice = getRowCount();
	 
	    // Adiciona os registros.
	    usuarios.addAll(listaUsuarios);
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(indice, indice + usuarios.size());
	}
	
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista de sócios.
	    usuarios.clear();
	 
	    // Notifica a mudança.
	    fireTableDataChanged();
	}

}
