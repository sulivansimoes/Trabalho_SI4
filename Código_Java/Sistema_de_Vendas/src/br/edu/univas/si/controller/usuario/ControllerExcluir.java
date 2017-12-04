package br.edu.univas.si.controller.usuario;

import br.edu.univas.si.model.dao.processes.UsuarioDAO;
import br.edu.univas.si.model.exception.UsuarioException;
import br.edu.univas.si.model.to.UsuarioTO;
import br.edu.univas.si.view.cadastrousuario.FrameExcluir;
import br.edu.univas.si.view.cadastrousuario.FramePrincipalUsuario;

public class ControllerExcluir {
	
	FramePrincipalUsuario viewPrincipalUsuario;
	FrameExcluir viewUsuario;
	UsuarioDAO modelUsuario;
	
	public ControllerExcluir(FramePrincipalUsuario viewPrincipalUsuario) {
		this.viewPrincipalUsuario = viewPrincipalUsuario;
		viewUsuario = new FrameExcluir(this);
		modelUsuario = new UsuarioDAO();
	}
	
	public void initialize(){
		viewUsuario.setVisible(true);
	}
	
	//Deleta usuario na base de dados
	public void deleteUsuario(String cpf){
		try {
			modelUsuario.deleteUsuario(cpf);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}
	
	//Notifica o Jtable da tela principal que houve mudança 
	public void updateViewPrincipal(){
		viewPrincipalUsuario.getTableUsuario().getTable().setModel(new ControllerConsulta().searchUsuario());
	}
	
	public void populatePanel(UsuarioTO usuario){
		viewUsuario.getPanelUsuario().getTextFieldCpf().setText(usuario.getCpf());
		viewUsuario.getPanelUsuario().getTextFieldNome().setText(usuario.getNome());
		viewUsuario.getPanelUsuario().getCheckBoxAdminstrador().setSelected(usuario.isGerente());
		viewUsuario.getPanelUsuario().getCheckBoxCaixa().setSelected(usuario.isCaixa());
	}
	
	public void close(){
		viewUsuario.dispose();
	}
}
