package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.processes.ProdutoDAO;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastroproduto.FrameAlterarProduto;
import br.edu.univas.si.view.cadastroproduto.FramePrincipalProduto;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerAlterar {

	private FrameAlterarProduto viewAlterarProduto;
	private ProdutoDAO modelProduto;
	private FramePrincipalProduto viewPrincipalrProduto;
	
	public ControllerAlterar(FramePrincipalProduto viewPrincipalrProduto){
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewAlterarProduto = new FrameAlterarProduto(this);
		this.viewPrincipalrProduto = viewPrincipalrProduto;
		modelProduto = new ProdutoDAO();
	}
	
	public void initialize(){
		viewAlterarProduto.setVisible(true);
	}
	
	//Atualiza produto no banco..
	public void updateProduto(ProdutoTO produto){
		try {
			modelProduto.updateProduto(produto);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
	}
	
	//Pega informações da linha e popula panel
	public void populatePanel(ProdutoTO produto){
		viewAlterarProduto.getPanelProduto().getTextFieldCodigoDeBarras().setText(String.valueOf(produto.getCodigoDeBarras()));
		viewAlterarProduto.getPanelProduto().getTextFieldDescricao().setText(produto.getDescricao());
		viewAlterarProduto.getPanelProduto().getTextFieldCodigoUnidadeMedida().setText(produto.getCodigo_unidadeMedida());
		viewAlterarProduto.getPanelProduto().getTextFieldQuantidade().setText(String.valueOf(produto.getQuantidade()));
		viewAlterarProduto.getPanelProduto().getTextFieldPrecoVenda().setText(String.valueOf(produto.getPrecoVenda()));
	}
	
	//Atualiza JTable da viewPrincipal
	public void updateViewPrincipal(){
		viewPrincipalrProduto.getTabelProduto().getTable().setModel(new ControllerConsulta().searchProdutos());
	}
	
	public void close(){
		viewAlterarProduto.dispose();
	}
}
