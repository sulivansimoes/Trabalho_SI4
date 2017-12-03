package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastroproduto.FrameExcluirProduto;
import br.edu.univas.si.view.cadastroproduto.FramePrincipalProduto;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerExcluir {

	FrameExcluirProduto viewExcluirProduto;
	ProdutoDAO modelProduto;
	FramePrincipalProduto viewPrincipalProduto;
	
	public ControllerExcluir(FramePrincipalProduto viewPrincipalProduto) {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewExcluirProduto = new FrameExcluirProduto(this);
		this.viewPrincipalProduto = viewPrincipalProduto;
		modelProduto = new ProdutoDAO();
	}
	
	public void initialize(){
		viewExcluirProduto.setVisible(true);
	}
	
	//Deleta registro do banco da dados.
	public void deleteProduto(String codigoBarras ){
		try {
			modelProduto.deleteProduto(codigoBarras);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
	}
	
	//Popula panel com informações da linha que o usuario está posicionado.
	public void populatePanel(ProdutoTO produto){
		viewExcluirProduto.getPanelProduto().getTextFieldCodigoDeBarras().setText(String.valueOf(produto.getCodigoDeBarras()));
		viewExcluirProduto.getPanelProduto().getTextFieldDescricao().setText(produto.getDescricao());
		viewExcluirProduto.getPanelProduto().getTextFieldCodigoUnidadeMedida().setText(produto.getCodigo_unidadeMedida());
		viewExcluirProduto.getPanelProduto().getTextFieldQuantidade().setText(String.valueOf(produto.getQuantidade()));
		viewExcluirProduto.getPanelProduto().getTextFieldPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));
	}
	
	//Atualiza JTable
	public void updateViewPrincipal(){
		viewPrincipalProduto.getTabelProduto().getTable().setModel(new ControllerConsulta().searchProdutos());
	}
	
	public void close(){
		viewExcluirProduto.dispose();
	}
}
