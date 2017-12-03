package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.controller.usuario.ControllerAlterar;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameAlterarUsuario extends MyJFrame {

	private static final long serialVersionUID = -2255867506674808534L;

	private ButtonsPanelConfirmaFecha buttonsPanel;
	private PanelUsuario panelUsuario;
	private ControllerAlterar controller;
	
	public FrameAlterarUsuario(ControllerAlterar controller) {
		super("Alterar -  Usuário");
		this.controller = controller;
		
		setPreferredSize(new Dimension(700, 400));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		
	}

	private void initialize() {
			add(getButtonsPanel(), BorderLayout.NORTH);
			add(getPanelUsuario(), BorderLayout.CENTER);
	}
	
	private ButtonsPanelConfirmaFecha getButtonsPanel() {
		if(buttonsPanel==null){
			buttonsPanel = new ButtonsPanelConfirmaFecha();
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
	
	public PanelUsuario getPanelUsuario() {
		if(panelUsuario==null){
			panelUsuario = new PanelUsuario();
			panelUsuario.getTextFieldCpf().setEditable(false);
		}
		return panelUsuario;
	}
	
	private void confirmaClicked(){
		//Extrai informações dos campos.
		String cpf = getPanelUsuario().getTextFieldCpf().getText().replaceAll("\\D", "");
		String nome = getPanelUsuario().getTextFieldNome().getText();
		String senha = new String(getPanelUsuario().getTextFieldsenha().getPassword());
		boolean administrador = getPanelUsuario().getCheckBoxAdminstrador().isSelected();
		boolean caixa = getPanelUsuario().getCheckBoxCaixa().isSelected();
		
		if(! validaPreechimento(cpf, nome, senha)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.");
		}else{
			//Monta TO
			UsuarioTO usuario = new UsuarioTO();
			usuario.setCpf(cpf);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setGerente(administrador);
			usuario.setCaixa(caixa);
			//Envia TO para controller.
			controller.updateUsuario(usuario);
			//Atualiza JTable da view Principal
			controller.updateViewPrincipal();
			
			this.fechaClicked();
		}
	}
	
	//Verifica se campos obrigatórios foram preenchidos antes de tentar salvar.
	private boolean validaPreechimento(String cpf, String nome, String senha){
		if(cpf.trim().isEmpty() || nome.trim().isEmpty() || senha.trim().isEmpty()){ 
			return false;
		}
		return true;
	}
	
	private void fechaClicked(){
		this.dispose();
	}
}
