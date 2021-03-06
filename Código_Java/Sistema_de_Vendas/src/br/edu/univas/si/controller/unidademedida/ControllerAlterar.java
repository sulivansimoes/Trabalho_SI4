package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastrounidademedida.FrameAlterarUnidadeMedida;
import br.edu.univas.si.view.cadastrounidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerAlterar {
	
	private FrameAlterarUnidadeMedida viewAlterarUnidadeMedida;
	private UnidadeMedidaDAO modelUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	
	public ControllerAlterar(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		this.viewAlterarUnidadeMedida = new FrameAlterarUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedidaDAO();
	}
	
	public void initialize(){
		viewAlterarUnidadeMedida.setVisible(true);
	}
	
	//Popula panel com informações da linha posicionada do table.
	public void populatePane(UnidadeMedidaTO unidade){
		viewAlterarUnidadeMedida.getPanelUnidadeMedida().getTextFieldCodigo().setText(unidade.getCodigo());
		viewAlterarUnidadeMedida.getPanelUnidadeMedida().getTextFieldDescricao().setText(unidade.getDescricao());
	}
	
	//Atualiza JTable da viewPrincipalUnidadeMedida.
	public void updateViewPrincipal(){ 
		viewPrincipalUnidadeMedida.getTableUnidadeMedia().getTable().setModel(new ControllerConsulta().searchUnidadeMedida());
	}
	
	//Faz update do registro no banco.
	public void updateUnidadeMedida(UnidadeMedidaTO unidade){
		try {
			modelUnidadeMedida.updateUnidadeMedida(unidade);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		viewAlterarUnidadeMedida.dispose();
	}
}
