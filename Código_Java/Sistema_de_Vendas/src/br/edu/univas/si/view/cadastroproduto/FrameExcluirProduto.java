package br.edu.univas.si.view.cadastroproduto;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.controller.produto.ControllerExcluir;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameExcluirProduto extends MyJFrame{

	private static final long serialVersionUID = -8194829439634842954L;

	private PanelProduto panelProduto;
	private ButtonsPanelConfirmaFecha buttons;
	private ControllerExcluir controller;
	
	public FrameExcluirProduto(ControllerExcluir controller ){
		super("Excluir - Produto");
		this.controller = controller;
		
		setPreferredSize(new Dimension(800, 360));
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getButtons(), BorderLayout.NORTH);
		add(getPanelProduto(), BorderLayout.SOUTH);
	}
	
	public PanelProduto getPanelProduto() {
		if(panelProduto==null){
			panelProduto = new PanelProduto();
			panelProduto.getTextFieldCodigoDeBarras().setEditable(false);
			panelProduto.getTextFieldDescricao().setEditable(false);
			panelProduto.getTextFieldCodigoUnidadeMedida().setEditable(false);
			panelProduto.getTextFieldPrecoVenda().setEditable(false);
			panelProduto.getTextFieldQuantidade().setEditable(false);
		}
		return panelProduto;
	}
	
	private ButtonsPanelConfirmaFecha getButtons() {
		if(buttons==null){
			buttons = new ButtonsPanelConfirmaFecha();
			buttons.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				
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
		return buttons;
	}
	
	private void confirmaClicked(){
	
		String codigoDeBarras =  String.valueOf(getPanelProduto().getTextFieldCodigoDeBarras().getText().trim().isEmpty() ? 
											"0" : getPanelProduto().getTextFieldCodigoDeBarras().getText().trim() );
	
		float precoVenda = Float.valueOf(getPanelProduto().getTextFieldPrecoVenda().getText().isEmpty() ? 
										"0" : getPanelProduto().getTextFieldPrecoVenda().getText());
		
		float quantidade = Float.valueOf(getPanelProduto().getTextFieldQuantidade().getText().isEmpty() ? 
										"0" : getPanelProduto().getTextFieldQuantidade().getText());
		
		String descricao = getPanelProduto().getTextFieldDescricao().getText().trim();
		String codigoUnidadeMedida = getPanelProduto().getTextFieldCodigoUnidadeMedida().getText(); 
		
		
		//Monta TO
		ProdutoTO produto = new ProdutoTO(codigoDeBarras, descricao, precoVenda, quantidade ,codigoUnidadeMedida);
		//Manda TO para controller.
		controller.deleteProduto(produto.getCodigoDeBarras()); 
		//Atualiza JTable
		controller.updateViewPrincipal();
		this.fechaClicked();
	}
	
	
	private void fechaClicked(){
		this.dispose();
	}
}
