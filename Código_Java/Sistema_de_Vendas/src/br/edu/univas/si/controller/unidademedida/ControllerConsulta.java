package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.consulta.jtables.GridUnidadeMedidaDAO;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.tablemodel.TableModelUnidadeMedida;

public class ControllerConsulta {

	private GridUnidadeMedidaDAO modelUnidadeMedida;
	
	
	//Popula um TableModelUnidadeMedida para retornar no JScrollPane
	public TableModelUnidadeMedida searchUnidadeMedida(){
		modelUnidadeMedida = new GridUnidadeMedidaDAO();
		try {
			return new TableModelUnidadeMedida(modelUnidadeMedida.populateGridUnidadeMedida());
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
		return null;
	}
}
