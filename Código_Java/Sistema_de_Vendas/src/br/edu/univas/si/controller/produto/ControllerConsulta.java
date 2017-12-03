package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.consulta.jtables.GridProdutoDAO;
import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.tablemodel.TableModelProduto;
import br.edu.univas.si.model.to.ProdutoTO;

public class ControllerConsulta {

private GridProdutoDAO modelProduto1;
private ProdutoDAO modelProduto2;	
	
	//Popula um TableModelProduto para retornar no JTable
	public TableModelProduto searchProdutos(){
		modelProduto1 = new GridProdutoDAO();
		try {
			return new TableModelProduto(modelProduto1.populateGridProduto());
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Busca produto especifico no banco de acordo com código de barras
	public ProdutoTO searchProduto(String codigoDeBarras){
		modelProduto2 = new ProdutoDAO();
		try {
			return modelProduto2.searchProduto(codigoDeBarras);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
