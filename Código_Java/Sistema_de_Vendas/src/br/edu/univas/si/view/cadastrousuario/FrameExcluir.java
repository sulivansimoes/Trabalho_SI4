package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.controller.usuario.ControllerExcluir;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameExcluir extends MyJFrame {

	private static final long serialVersionUID = 7721331395312146125L;
	
	private PanelUsuario panel;
	private ButtonsPanelConfirmaFecha buttons;
	private ControllerExcluir controller;
	
	public FrameExcluir(ControllerExcluir controller) {
		super("Excluir - Usuário");
		
		this.controller = controller;
		setPreferredSize(new Dimension(700, 400));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);	
	}


	private void initialize(){
		add(getButtonsConfirmaFecha(),BorderLayout.NORTH);
		add(getPanelUsuario(),BorderLayout.CENTER);
	}


	public PanelUsuario getPanelUsuario() {
		if(panel == null){
			panel = new PanelUsuario();
			panel.getTextFieldCpf().setEditable(false);
			panel.getTextFieldNome().setEditable(false);
			panel.getTextFieldsenha().setEditable(false);
			panel.getCheckBoxCaixa().setEnabled(false);
			panel.getCheckBoxAdminstrador().setEnabled(false);
		}
		return panel;
	}


	private ButtonsPanelConfirmaFecha getButtonsConfirmaFecha() {
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
		//Extrai conteudo dos campos 
		String cpf  = getPanelUsuario().getTextFieldCpf().getText().replaceAll("\\D","");		
	
		//Deleta usuario do banco de dados.
		controller.deleteUsuario(cpf);
		//Atualiza JTable da viewPrincipal
		controller.updateViewPrincipal();
		this.fechaClicked();
	}
		
	private void fechaClicked(){
			this.dispose();
	}
}
