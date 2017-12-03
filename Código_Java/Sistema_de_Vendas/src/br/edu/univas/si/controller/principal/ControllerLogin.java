package br.edu.univas.si.controller.principal;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.login.FrameLogin;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerLogin {

	UsuarioDAO modelUsuario;
	FrameLogin viewUsuarioLogin;
	
	public ControllerLogin() {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewUsuarioLogin  = new FrameLogin(this);
		modelUsuario = new UsuarioDAO();
	}
	
	
	public void  inititalize(){
		viewUsuarioLogin.setVisible(true);
	}
	
	public boolean autentifica(){
		
		//Extrai conteudo de campos.
		String cpf = viewUsuarioLogin.getPanelLogin().getTextFieldUser().getText().replaceAll("\\D","");
		String senha = new String(viewUsuarioLogin.getPanelLogin().getTextFieldSenha().getPassword());
		
		//Monta TO
		UsuarioTO usuario = new UsuarioTO();
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		
		//Verifica senha e user
		try {
			return modelUsuario.autentifica(usuario);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void close(){
		viewUsuarioLogin.dispose();
	}
}
