package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.produto.ControllerAlterar;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameAlterarProduto extends MyJFrame{

	private static final long serialVersionUID = 1813337309570197083L;
	
	private PanelProduto panelProduto;
	private ButtonsPanelConfirmaFecha buttonsPanel;
	private ControllerAlterar controller;
	
	public FrameAlterarProduto(ControllerAlterar controller) {
		setTitle("Alterar - Produto");
		this.controller = controller;
		setPreferredSize(new Dimension(800, 360));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getPanelProduto(), BorderLayout.CENTER);
	}
	
	public PanelProduto getPanelProduto() {
		if(panelProduto==null){
			panelProduto = new PanelProduto();
			panelProduto.getTextFieldCodigoDeBarras().setEditable(false);
		}
		return panelProduto;
	}
	
	private ButtonsPanelConfirmaFecha getButtonsPanel() {
		if(buttonsPanel==null){
			buttonsPanel = new  ButtonsPanelConfirmaFecha();
			buttonsPanel.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				@Override
				public void fechaPerformed() {
					fechaClicked();					
				}
				
				@Override
				public void confirmaPerformed() {
					confirmaClicked();					
				}
			});
		}
		return buttonsPanel;
	}
	
	private void confirmaClicked(){
		String codigoDeBarras =  String.valueOf(getPanelProduto().getTextFieldCodigoDeBarras().getText().trim().isEmpty() ? 
				"0" : getPanelProduto().getTextFieldCodigoDeBarras().getText().trim()) ;

		float precoVenda = Float.valueOf(getPanelProduto().getTextFieldPrecoVenda().getText().isEmpty() ? 
					"0" : getPanelProduto().getTextFieldPrecoVenda().getText());
		
		float quantidade = Float.valueOf(getPanelProduto().getTextFieldQuantidade().getText().isEmpty() ? 
					"0" : getPanelProduto().getTextFieldQuantidade().getText());
		
		String descricao = getPanelProduto().getTextFieldDescricao().getText().trim();
		String codigoUnidadeMedida = getPanelProduto().getTextFieldCodigoUnidadeMedida().getText(); 
		
		if(! validaPreenchimento(codigoDeBarras, descricao, precoVenda, quantidade, codigoUnidadeMedida)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.");
		}else{			
			//Monta TO
			ProdutoTO produto = new ProdutoTO(codigoDeBarras, descricao, precoVenda, quantidade ,codigoUnidadeMedida);
			//Manda TO para controller
			controller.updateProduto(produto); 
			//Atualiza JTable
			controller.updateViewPrincipal();
			this.dispose();
		}
	}
	
	//Valida se os campos obrigatórios estão preenchidos antes de salvar.
	private boolean validaPreenchimento(String codigoBarras, String descricao, Float precoVenda, Float quantidade, String unid){
		
		if(codigoBarras.trim().isEmpty() || descricao.trim().isEmpty() || precoVenda==0 || quantidade==0 || unid.trim().isEmpty()){
			return false;
		}
		return true;
	}
	
	private void fechaClicked(){
		Object[] opcoes = {"Sim","Não"};
		int escolha = JOptionPane.showOptionDialog(this, 
												  "Deseja fechar sem salvar ?", 
												  "Aviso", 
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null , 
												  opcoes , 
												  opcoes[1]);
		
		if(escolha==0){ //Sim
				this.dispose();
		}
	}	
}
