package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastrounidademedida.FrameIncluirUnidadeMedida;
import br.edu.univas.si.view.cadastrounidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerIncluir {

	private UnidadeMedidaDAO modelUnidadeMedida;
	private FrameIncluirUnidadeMedida viewIncluirUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	
	public ControllerIncluir(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		this.viewIncluirUnidadeMedida = new FrameIncluirUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedidaDAO();		
	}	
	
	public  void initialize(){
		this.viewIncluirUnidadeMedida.setVisible(true);
	}
	
	//Inclui registro no banco.
	public void insertUnidadeMedida(UnidadeMedidaTO unidade){
		
		try {
			modelUnidadeMedida.insertNewUnidadeMedida(unidade);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
		
	//Atualiza JTable da viewPrincipalUnidadeMedida.
	public void updateViewPrincipal(){ 
		viewPrincipalUnidadeMedida.getTableUnidadeMedia().getTable().setModel(new ControllerConsulta().searchUnidadeMedida());
	}
	
	public void close(){
		viewIncluirUnidadeMedida.dispose();
	}	
	
}