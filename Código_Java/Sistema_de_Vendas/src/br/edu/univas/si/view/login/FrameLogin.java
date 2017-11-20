package br.edu.univas.si.view.login;

import java.awt.BorderLayout;
import java.awt.Dimension;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.defaultcomponents.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyJFrame;

public class FrameLogin extends MyJFrame {

	private static final long serialVersionUID = -5190457170229789597L;

	PanelLogin panelLogin = null;
	ButtonsPanelConfirmaFecha buttonsLogin = null;
	
	public FrameLogin(){
		super("Login");
		initialize();
		
		setPreferredSize(new Dimension(350, 200));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);	
	}
	
	private void initialize() {
		add(getPanelLogin(), BorderLayout.NORTH);
		add(getButtonsPanelConfirmaFecha(), BorderLayout.SOUTH);
		
	}

	private PanelLogin getPanelLogin(){
		if(panelLogin == null){
			panelLogin = new PanelLogin();
		}
		return panelLogin;
	}
	
	private ButtonsPanelConfirmaFecha getButtonsPanelConfirmaFecha(){
		if(buttonsLogin==null){
			buttonsLogin = new ButtonsPanelConfirmaFecha();
			buttonsLogin.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				
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
		return buttonsLogin;
	}
	
	private void fechaClicked(){
		System.exit(0);
	}
	
	private void confirmaClicked(){
		//Extrai conteudo de campos.
		String cpf = this.getPanelLogin().getTextFieldUser().getText().replaceAll("\\D","");
		String senha = new String(this.getPanelLogin().getTextFieldSenha().getPassword());
		//Monta TO
		UsuarioTO usuario = new UsuarioTO();
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		//Chama controller passando TO FIXME: CHAMAR O CONTROLLER AO INVÉS DA DO MODEL DIRETO.
		UsuarioDAO d = new UsuarioDAO();
		try {
			d.autentifica(usuario);
		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {//TODO RETIRAR
		
		//setlookAndFeel(ACRYL);
		setlookAndFeel(AERO);
		FrameLogin t = new FrameLogin();
		t.setVisible(true);
	}
}
