package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastrounidademedida.FrameExcluirUnidadeMedida;
import br.edu.univas.si.view.cadastrounidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerExcluir {
	
	private FrameExcluirUnidadeMedida viewExcluirUnidadeMedida;
	private UnidadeMedidaDAO modelUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	
	public ControllerExcluir(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		this.viewExcluirUnidadeMedida = new FrameExcluirUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedidaDAO();
	}
	
	public  void initialize(){
		this.viewExcluirUnidadeMedida.setVisible(true);
	}
	
	//Popula panel com informações da linha posicionada do table.
	public void populatePane(UnidadeMedidaTO unidade){
		viewExcluirUnidadeMedida.getPanelUnidadeMedida().getTextFieldCodigo().setText(unidade.getCodigo());
		viewExcluirUnidadeMedida.getPanelUnidadeMedida().getTextFieldDescricao().setText(unidade.getDescricao());
	}
	
	//Atualiza JTable da viewPrincipalUnidadeMedida.
	public void updateViewPrincipal(){ 
		viewPrincipalUnidadeMedida.getTableUnidadeMedia().getTable().setModel(new ControllerConsulta().searchUnidadeMedida());
	}
	
	//Deleta registro do banco de dados.
	public void deleteUnidadeMedida(UnidadeMedidaTO unidade){
		try {
			modelUnidadeMedida.deleteUnidadeMedida(unidade.getCodigo());
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		viewExcluirUnidadeMedida.dispose();
	}
}
