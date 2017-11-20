package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastrounidademedida.FrameAlterarUnidadeMedida;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerAlterar {
	
	private FrameAlterarUnidadeMedida viewUnidadeMedida;
	private UnidadeMedidaDAO modelUnidadeDeMedida;
	
	public ControllerAlterar() {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		viewUnidadeMedida = new FrameAlterarUnidadeMedida(this);
		modelUnidadeDeMedida = new UnidadeMedidaDAO();
	}
	
	public void initialize(){
		viewUnidadeMedida.setVisible(true);
	}
	
	public void close(){
		viewUnidadeMedida.dispose();
	}
	
	//Faz update do registro no banco.
	public void updateUnidadeMedida(UnidadeMedidaTO unidade){
		try {
			modelUnidadeDeMedida.updateUnidadeMedida(unidade);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
}
