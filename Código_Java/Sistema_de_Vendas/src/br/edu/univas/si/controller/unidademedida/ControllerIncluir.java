package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.processes.UnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastrounidademedida.FrameIncluirUnidadeMedida;
import br.edu.univas.si.view.util.MyJFrame;

public class ControllerIncluir {

	private UnidadeMedidaDAO modelUnidadeMedida;
	private FrameIncluirUnidadeMedida viewUnidadeMedida;
	
	public ControllerIncluir() {
		MyJFrame.setlookAndFeel(MyJFrame.AERO);
		this.viewUnidadeMedida = new FrameIncluirUnidadeMedida(this);
		this.modelUnidadeMedida = new UnidadeMedidaDAO();
	}
	
	public  void initialize(){
		this.viewUnidadeMedida.setVisible(true);
	}
	
	public void close(){
		viewUnidadeMedida.dispose();
	}
	
	//Inclui registro no banco.
	public void insertUnidadeMedida(UnidadeMedidaTO unidade){
		try {
			modelUnidadeMedida.insertNewUnidadeMedida(unidade);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
}
