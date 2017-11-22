package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.controller.unidademedida.ControllerExcluir;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameExcluirUnidadeMedida extends MyJFrame{

	private static final long serialVersionUID = 2122781942450404590L;
	
	private ButtonsPanelConfirmaFecha buttons;
	private PanelUnidadeMedida panelUnidadeMedida;
	private ControllerExcluir controller;
	
	public FrameExcluirUnidadeMedida(ControllerExcluir controller) {
		super("Excluir - Unidade de Medida");
		this.controller = controller;
		setPreferredSize(new Dimension(700, 270));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getButtons(), BorderLayout.NORTH);
		add(getPanelUnidadeMedida(), BorderLayout.CENTER);
	}
	
	private ButtonsPanelConfirmaFecha getButtons(){
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
	
	public PanelUnidadeMedida getPanelUnidadeMedida(){
		if(panelUnidadeMedida==null){
			panelUnidadeMedida = new PanelUnidadeMedida();
			panelUnidadeMedida.getTextFieldCodigo().setEditable(false);
			panelUnidadeMedida.getTextFieldDescricao().setEditable(false);
		}
		return panelUnidadeMedida;
	}
	
	private void confirmaClicked(){
		String codigo = getPanelUnidadeMedida().getTextFieldCodigo().getText().trim();
		String descricao = getPanelUnidadeMedida().getTextFieldDescricao().getText().trim();
		
		UnidadeMedidaTO unidade = new UnidadeMedidaTO(codigo, descricao);
		//Envia TO para Controller.
		controller.deleteUnidadeMedida(unidade);
		controller.updateViewPrincipal();
		this.fechaClicked();
	}
	
	private void fechaClicked(){
		this.dispose();
	}
}
