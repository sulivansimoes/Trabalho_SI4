package br.edu.univas.si.view.cadastrounidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameAlterarUnidadeMedida extends MyJFrame{

	private static final long serialVersionUID = 7769731142209152371L;
	
	private ButtonsPanelConfirmaFecha buttons;
	private PanelUnidadeMedida panelUnidadeMedida;
	private ControllerAlterar controller;
	
	public FrameAlterarUnidadeMedida(ControllerAlterar controller){
		super("Alterar - Unidade Medida");
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
		}
		return panelUnidadeMedida;
	}
	
	private void confirmaClicked(){
		String codigo = getPanelUnidadeMedida().getTextFieldCodigo().getText().trim();
		String descricao = getPanelUnidadeMedida().getTextFieldDescricao().getText().trim();
		
		if(! validaPreechimento(codigo, descricao)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.","Problema",JOptionPane.ERROR_MESSAGE);
		}else{
				UnidadeMedidaTO unidade = new UnidadeMedidaTO(codigo, descricao);
				//Manda TO para controller.
				controller.updateUnidadeMedida(unidade);
				//Atualiza JTable da view principal
				controller.updateViewPrincipal();
				
				this.dispose();//TODO analisar
		}
	}	
	
	//Valida o prenchimento dos campos obrigatórios antes de salvar.
	private boolean validaPreechimento(String codigo, String descricao){
		if(codigo.trim().isEmpty() || descricao.trim().isEmpty()){
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
