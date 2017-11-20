package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastroproduto.FrameInluirProduto;

public class ControllerIncluir {

	private FrameInluirProduto viewIncluirProduto;
	private ProdutoDAO modelProduto;
	
	public ControllerIncluir() {
		viewIncluirProduto = new FrameInluirProduto(this);
		modelProduto = new ProdutoDAO();
	}
	
	public void initialize(){
		viewIncluirProduto.setVisible(true);
	}
	
	public void insertProduto(ProdutoTO produto){
		try {
			modelProduto.insertNewProduto(produto);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
	}
}
