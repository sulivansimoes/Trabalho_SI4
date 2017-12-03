package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastroproduto.FrameInluirProduto;
import br.edu.univas.si.view.cadastroproduto.FramePrincipalProduto;

public class ControllerIncluir {

	private FramePrincipalProduto viewPrincipalProduto;
	private FrameInluirProduto viewIncluirProduto;

	private ProdutoDAO modelProduto;

	public ControllerIncluir(FramePrincipalProduto viewPrincipalProduto) {
		this.viewPrincipalProduto = viewPrincipalProduto;
		viewIncluirProduto = new FrameInluirProduto(this);
		modelProduto = new ProdutoDAO();
	}

	public void initialize() {

		viewIncluirProduto.setVisible(true);
	}

	// Insere registro no banco de dados.
	public void insertProduto(ProdutoTO produto) {
		try {
			modelProduto.insertNewProduto(produto);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
	}

	// Atualiza JTable da view principal
	public void updateViewPrincipal() {
		viewPrincipalProduto.getTabelProduto().getTable().setModel(new ControllerConsulta().searchProdutos());
	}

	public void close() {
		viewIncluirProduto.dispose();
	}
}
