package br.edu.univas.si.controller.usuario;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.cadastrousuario.FrameAlterarUsuario;
import br.edu.univas.si.view.cadastrousuario.FramePrincipalUsuario;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerAlterar {
	
	FramePrincipalUsuario viewPrincipalUsuario;
	FrameAlterarUsuario viewAlterarUsuario;
	UsuarioDAO modelUsuario;
	
	public ControllerAlterar(FramePrincipalUsuario viewPrincipalUsuario) {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		this.viewPrincipalUsuario = viewPrincipalUsuario;
		viewAlterarUsuario = new FrameAlterarUsuario(this);
		modelUsuario = new UsuarioDAO();
	}
	
	public void initialize(){
		viewAlterarUsuario.setVisible(true);
	}
	
	//Faz update do registro no banco de dados.
	public void updateUsuario(UsuarioTO usuario){
		try {
			modelUsuario.updateUsuario(usuario);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}
	
	//Pega informações da linha selecionada e coloca no panel
	public void populatePanel(UsuarioTO usuario){
		viewAlterarUsuario.getPanelUsuario().getTextFieldCpf().setText(usuario.getCpf());
		viewAlterarUsuario.getPanelUsuario().getTextFieldNome().setText(usuario.getNome());
		viewAlterarUsuario.getPanelUsuario().getCheckBoxAdminstrador().setSelected(usuario.isGerente());
		viewAlterarUsuario.getPanelUsuario().getCheckBoxCaixa().setSelected(usuario.isCaixa());
	}
	
	//Atualiza JTable da viewPrincipal
	public void updateViewPrincipal(){
		viewPrincipalUsuario.getTableUsuario().getTable().setModel(new ControllerConsulta().searchUsuario());
	}
	
	public void close(){
		
	}

}
