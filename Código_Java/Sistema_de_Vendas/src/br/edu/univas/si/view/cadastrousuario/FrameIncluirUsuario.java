package br.edu.univas.si.view.cadastrousuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameIncluirUsuario extends MyJFrame {

	private static final long serialVersionUID = 5515241630872543611L;

	private PanelUsuario panelUsuario;
	private ButtonsPanelConfirmaFecha buttonsConfirmaFecha;

	public FrameIncluirUsuario() {
		super("Incluir - Usuário");
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

	private ButtonsPanelConfirmaFecha getButtonsConfirmaFecha() {
		if (buttonsConfirmaFecha == null) {
			buttonsConfirmaFecha = new ButtonsPanelConfirmaFecha();
			buttonsConfirmaFecha.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {

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

		return buttonsConfirmaFecha;
	}

	private PanelUsuario getPanelUsuario() {
		if (panelUsuario == null) {
			panelUsuario = new PanelUsuario();
		}
		return panelUsuario;
	}
	
	private void confirmaClicked(){
		
		//Extrai conteudo dos campos 
		String cpf  = getPanelUsuario().getTextFieldCpf().getText().replaceAll("\\D","");		
		String nome = getPanelUsuario().getTextFieldNome().getText();
		boolean caixa = getPanelUsuario().getCheckBoxCaixa().isSelected();
		boolean admnistrador =  getPanelUsuario().getCheckBoxAdminstrador().isSelected();
		String senha = new String(getPanelUsuario().getTextFieldsenha().getPassword());
		
		if(! validaPreechimento(cpf, nome, senha)){
			JOptionPane.showMessageDialog(this, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
										 + "campos obrigatórios antes de salvar.");
		}else{		
			//Monta TO
			UsuarioTO usuario = new UsuarioTO(cpf, nome, caixa, admnistrador, senha);
			
			//Chama model direto na view - FIXME: CHAMAR O CONTROLLER NO LUGAR DO MODEL
			UsuarioDAO d = new UsuarioDAO();
			try {
				d.insertNewUsuario(usuario);
			} catch (UsuarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			limpaCampos();
		}
	}
	
	//Verifica se campos obrigatórios foram preenchidos antes de tentar salvar.
	private boolean validaPreechimento(String cpf, String nome, String senha){
		if(cpf.trim().isEmpty() || nome.trim().isEmpty() || senha.trim().isEmpty()){ 
			return false;
		}
		return true;
	}
	
	private void limpaCampos(){
		getPanelUsuario().getTextFieldCpf().setText("");
		getPanelUsuario().getTextFieldNome().setText("");
		getPanelUsuario().getCheckBoxCaixa().setSelected(false);
		getPanelUsuario().getCheckBoxAdminstrador().setSelected(false);
		getPanelUsuario().getTextFieldsenha().setText("");	
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

	// FIXME retirar main
	public static void main(String[] args) {
		setlookAndFeel(AERO);

		FrameIncluirUsuario t = new FrameIncluirUsuario();
	//	t.setSize(new Dimension(400, 400));
		t.setVisible(true);

	}

}
