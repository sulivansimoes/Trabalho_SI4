package br.edu.univas.si.controller.usuario;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.cadastrousuario.FrameIncluirUsuario;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerIncluir {

	private FrameIncluirUsuario viewIncluirUsuario;
	private UsuarioDAO modelUsuario;
	
	public ControllerIncluir(){
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewIncluirUsuario = new FrameIncluirUsuario(this);
		modelUsuario = new UsuarioDAO();
	}
	
	public void initialize(){
		viewIncluirUsuario.setVisible(true);
	}
	
	public void close(){
		viewIncluirUsuario.dispose();
	}
	
	//Insere registro no banco de dados.
	public void insertUsuario(UsuarioTO usuario){
		try {
			modelUsuario.insertNewUsuario(usuario);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}
	
}
